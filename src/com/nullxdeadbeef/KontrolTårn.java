package com.nullxdeadbeef;

import com.nullxdeadbeef.Log.IOSkriver;
import com.nullxdeadbeef.Service.FlyDAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class KontrolTårn {
    private static final int PORT = 42069;
//    Listen af alle fly, hentet fra databasen
    private ArrayList<FlyRejse> flyRejseListe;
//    Listen af alle de fly som på den givne dag ankommer, er skal blive klar til boarding
    private ArrayList<Fly> aktuelleFly;
//    Nummer til at holde styr paa log besked nummer
    private int num=1;
//    Listen af alle de fly som har skabt forbindelse til kontroltårnet, ved brug af protokollen
    private ArrayList<Fly> forbundedeFly;
    private LocalDateTime tidspunkt;
    private static ServerSocket server;
    private static Vector<Socket> personaleSockets = new Vector<>();
    private static FlyDAO flyDAO = new FlyDAO();
    private static Socket kontrolTaarnSocket;

    public static void main(String[] args) {
        Socket clientSocket = null;
        KontrolTårn kontrolTårn = new KontrolTårn();
        try {
            server = new ServerSocket( PORT );
        } catch ( IOException ex ) {
            System.out.println( "ERROR" );
            ex.printStackTrace();
            System.exit( 1 );
        }

        while (true) {
            try {
                clientSocket = server.accept();
                kontrolTaarnSocket = clientSocket;
                personaleSockets.add( clientSocket );
                kontrolTårn.startSimulering( LocalDateTime.parse( "2019-09-19T00:00:00" ));
            } catch ( IOException ex ) {
                ex.printStackTrace();
                System.exit( 1 );
            }
        }
    }

//    public void lyt(){
//        Thread lyttetråd = new KontrolTårn();
//        lyttetråd.start();
//    }

    public void run() {
        while ( true ) {
            String flyBesked = modtagBesked();
            if ( flyBesked.contains( "FORBIND_FLY" ) ) {
                String[] fly = flyBesked.split( ", " );
                String ac = fly[0];
                String ruteNr = fly[1];
                sendBesked( "FORBIND " + ac + " " + ruteNr );
            }
        }
    }

    public void startSimulering(LocalDateTime tidspunkt){
        //flyListe = flyDAO.getAll();

        this.tidspunkt = tidspunkt;
        while(true){
            simulering();
        }
    }
    public LocalDateTime simulering() {
//        Simuleringskode her
        boolean running = true;
        while ( true ) {
            ArrayList<FlyRejse> aktuelleFly = getAktuelleFlyRejser( flyRejseListe,
                    tidspunkt );
            indenforKlokkeslaet(aktuelleFly, tidspunkt);
            inkrementerTidspunkt();

            // TODO: remember to remove ;)
           if (!running) {
               break;
           }
        }

        return tidspunkt;
    }

    public void printOgLogKommunikation(String besked){
        IOSkriver ioSkriver = new IOSkriver();

        // Gemmer beskeden i loggen
        ioSkriver.skrivTilFil(tidspunkt.toLocalTime(), besked);

        // Udskriver Den givne kommunikation formateret eksempel:
        // [11:59:06] Log-1 Kontroltårn: DK1160 Modtaget besked om landing.

        // TODO: Færdiggør print statementet - der mangler om det er kontroltårn, personale eller et fly som sender beskeden
        System.out.println("["+tidspunkt.getHour()+":"+tidspunkt.getMinute()+":"+tidspunkt.getSecond()+"] "+
                "Log-"+num+" "+"MANGLER HER"+": "+besked);

        num++;
    }

    public void printLog() {}

    public void sendTilAlle( String message ) {
        for ( Socket s : personaleSockets ) {
            try {
                DataOutputStream out = new DataOutputStream( s.getOutputStream() );
                out.writeUTF( message );
            } catch( IOException ex ) {
                ex.printStackTrace();
            }
        }
    }
    // TODO: husk at logge besked
    public String modtagBesked() {
        try {
            DataInputStream inputStream =
                    new DataInputStream( kontrolTaarnSocket.getInputStream() );
            String besked = inputStream.readUTF();
            return besked;
        } catch ( IOException ex ) {
            ex.printStackTrace();
            System.exit( 1 );
        }

        return "FEJL i modtagBesked() kontroltaarnet";
    }

    public void sendBesked( String besked ) {
        try {
            DataOutputStream outputStream =
                    new DataOutputStream( kontrolTaarnSocket.getOutputStream() );
            outputStream.writeUTF( besked );
        } catch ( IOException ex ) {
            ex.printStackTrace();
            System.exit( 1 );
        }
    }

    public void inkrementerTidspunkt(){
        tidspunkt = tidspunkt.plusMinutes(5);
    }

    public int getPort() {
        return PORT;
    }

    public ArrayList<FlyRejse> getFlyRejseListe() {
//        TODO; hent alle fly ind fra databasen
        return flyRejseListe;
    }

    public void setFlyListe(ArrayList<FlyRejse> flyRejseListe) {
        this.flyRejseListe = flyRejseListe;
    }

    // Find fly med afgang eller ankomst indenfor tidspunkt
    public ArrayList<FlyRejse> getAktuelleFlyRejser( ArrayList<FlyRejse> flyRejser,
                                           LocalDateTime tidspunkt ) {
        ArrayList<FlyRejse> flyISimulation = new ArrayList<>();
        LocalDate tidspunktDate = tidspunkt.toLocalDate();

        for (FlyRejse flyRejse : flyRejser) {
            if ( flyRejse.getDato() == tidspunktDate) {
                flyISimulation.add(flyRejse);
            }
        }
        return flyISimulation;
    }

    //tjekker om et fly fra aktuelleFly er indenfor en time af simuleringstidspunkt, og starter så
    // en ny pilotThread med flyet som parameter
    public void indenforKlokkeslaet(ArrayList<FlyRejse> flyISimulation, LocalDateTime tidspunkt) {
        LocalTime tidspunktTime = tidspunkt.toLocalTime();
        // vi laver en size counter for at holde styr paa
        // hvornaar vi skal stoppe med at lave threads til vores fly
        int size_counter = 0;
        while (true) {
            if ( size_counter == flyISimulation.size() ) {
                break;
            }
            for (FlyRejse flyRejse : flyISimulation) {
                if ( flyRejse.getKlokkeslæt().isBefore( tidspunktTime.plusMinutes( 60 ) ) ) {
                    Thread pilotThread = new PilotThread(flyRejse);
                    pilotThread.start();
                    size_counter++;
                }
            }
        }
    }

    public void setAktuelleFly(ArrayList<Fly> aktuelleFly) {
        this.aktuelleFly = aktuelleFly;
    }

    public ArrayList<Fly> getForbundedeFly() {
        return forbundedeFly;
    }

    public void setForbundedeFly(ArrayList<Fly> forbundedeFly) {
        this.forbundedeFly = forbundedeFly;
    }

    public LocalDateTime getTidspunkt() {
        return tidspunkt;
    }

    public void setTidspunkt(LocalDateTime tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public ServerSocket getServer() {
        return server;
    }

    public void setServer(ServerSocket server) {
        this.server = server;
    }
}

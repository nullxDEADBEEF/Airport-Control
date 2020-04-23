package com.nullxdeadbeef;

import com.nullxdeadbeef.Service.FlyDAO;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class KontrolTårn {
    private final int PORT = 42069;
//    Listen af alle fly, hentet fra databasen
    private ArrayList<Fly> flyListe;
//    Listen af alle de fly som inden for 1 time ankommer, er skal blive klar til boarding
    private ArrayList<Fly> aktuelleFly;
//    Listen af alle de fly som har skabt forbindelse til kontroltårnet, ved brug af protokollen
    private ArrayList<Fly> forbundedeFly;
    private LocalDateTime tidspunkt;
    private ServerSocket server;
    private static Vector<Socket> personaleSockets = new Vector<>();
    private static FlyDAO flyDAO = new FlyDAO();

    public void main() {
        Socket clientSocket = null;
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
                Runnable r = new KontrolTårnThread( clientSocket );
                personaleSockets.add( clientSocket );
                r.run();
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

    public void startSimulering(LocalDateTime tidspunkt){
        flyListe = flyDAO.getAll();

        this.tidspunkt = tidspunkt;
        while(true){
            simulering();
        }
    }
    public LocalDateTime simulering() {
//        Simuleringskode her
        inkrementerTidspunkt();
        return tidspunkt;
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
    public void modtagBesked() {}
    public void sendBesked() {}
    public void inkrementerTidspunkt(){
        tidspunkt = tidspunkt.plusMinutes(5);
    }

    public int getPort() {
        return PORT;
    }

    public ArrayList<Fly> getFlyListe() {
//        TODO; hent alle fly ind fra databasen
        return flyListe;
    }

    public void setFlyListe(ArrayList<Fly> flyListe) {
        this.flyListe = flyListe;
    }

    // Find fly med afgang eller ankomst inden for tidspunkt
    public ArrayList<Fly> getAktuelleFly( ArrayList<Fly> alleFly, LocalDateTime tidspunkt ) {
        ArrayList<Fly> flyISimulation = new ArrayList<>();
        LocalTime tidspunkTime = tidspunkt.toLocalTime();
        LocalDate tidspunktDate = tidspunkt.toLocalDate();

        for ( Fly fly : alleFly ) {
            if ( fly.getFlyRejse().getKlokkeslæt() == tidspunkTime &&
                    fly.getFlyRejse().getDato() == tidspunktDate ) {
                flyISimulation.add( fly );
            }
        }
        return flyISimulation;
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

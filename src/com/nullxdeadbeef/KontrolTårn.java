package com.nullxdeadbeef;

import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class KontrolTårn extends Thread{
    private int port;
//    Listen af alle fly, hentet fra databasen
    private ArrayList<Fly> flyListe;
//    Listen af alle de fly som inden for 1 time ankommer, er skal blive klar til boarding
    private ArrayList<Fly> aktuelleFly;
//    Listen af alle de fly som har skabt forbindelse til kontroltårnet, ved brug af protokollen
    private ArrayList<Fly> forbundedeFly;
    private LocalDateTime tidspunkt;
    private Socket server;


//    public void run(){
//        while (true){
////            Lyt til socket
//        }
//    }
//    public void lyt(){
//        Thread lyttetråd = new KontrolTårn();
//        lyttetråd.start();
//    }

    public void startSimulering(LocalDateTime tidspunkt){
        this.tidspunkt = tidspunkt;
        while(true){
            simulering();
        }
    }
    public LocalDateTime simulering(){
//        Simuleringskode her
        inkrementerTidspunkt();
        return tidspunkt;
    }
    public void printLog() {}
    public void sendTilAlle() {}
    public void modtagBesked() {}
    public void sendBesked() {}
    public void inkrementerTidspunkt(){
        tidspunkt = tidspunkt.plusMinutes(5);
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ArrayList<Fly> getFlyListe() {
//        TODO; hent alle fly ind fra databasen
        return flyListe;
    }

    public void setFlyListe(ArrayList<Fly> flyListe) {
        this.flyListe = flyListe;
    }

    public ArrayList<Fly> getAktuelleFly() {
//        TODO; find de fly i Flyliste, som har afgang eller ankomst inden for 1 time
        return aktuelleFly;
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

    public Socket getServer() {
        return server;
    }

    public void setServer(Socket server) {
        this.server = server;
    }
}

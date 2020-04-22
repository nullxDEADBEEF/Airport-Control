package com.nullxdeadbeef;

import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class KontrolTårn {
    private int port;
    private ArrayList<Fly> flyListe;
    private ArrayList<Fly> aktuelleFly;
    private ArrayList<Fly> forbundedeFly;
    private LocalDateTime tidspunkt;
    private Socket server;

    public void printLog() {}
    public void sendTilAlle() {}
    public void modtagBesked() {}
    public void sendBesked() {}

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ArrayList<Fly> getFlyListe() {
        return flyListe;
    }

    public void setFlyListe(ArrayList<Fly> flyListe) {
        this.flyListe = flyListe;
    }

    public ArrayList<Fly> getAktuelleFly() {
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

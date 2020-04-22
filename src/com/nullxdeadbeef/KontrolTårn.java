package com.nullxdeadbeef;

import java.util.List;

public class KontrolTårn {
    private int port;
    private List<Fly> flyListe;

    public void printLog() {}
    public void sendTilAlle() {}

    public int getPort() {
        return port;
    }

    public void setPort( int port ) {
        this.port = port;
    }

    public List<Fly> getFlyListe() {
        return flyListe;
    }

    public void setFlyListe( List<Fly> flyListe ) {
        this.flyListe = flyListe;
    }
}

package com.nullxdeadbeef.Lufthavnspersonale;

import com.nullxdeadbeef.Standplads;

import java.net.Socket;

public class Lufthavnspersonale extends Thread {
    private int gruppeNr;
    private Socket walkie;
    private int operationTid;
    private Standplads placering;

    public void sendBesked() {}
    public void modtagBesked() {}

    public int getGruppeNr() {
        return gruppeNr;
    }

    public void setGruppeNr(int gruppeNr) {
        this.gruppeNr = gruppeNr;
    }

    public Socket getWalkie() {
        return walkie;
    }

    public void setWalkie(Socket walkie) {
        this.walkie = walkie;
    }

    public int getOperationTid() {
        return operationTid;
    }

    public void setOperationTid(int operationTid) {
        this.operationTid = operationTid;
    }

    public Standplads getPlacering() {
        return placering;
    }

    public void setPlacering(Standplads placering) {
        this.placering = placering;
    }
}

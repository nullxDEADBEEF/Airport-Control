package com.nullxdeadbeef.Lufthavnspersonale;

import com.nullxdeadbeef.Standplads;

import java.net.Socket;

public class Lufthavnspersonale extends Thread {
    private int gruppeNr;
    private Socket walkie;
    private int operationTid;
    private Standplads placering;

    public void run(){
//        sendBesked(FORBIND_FLY <aC, flyrejse>)
        sendBesked();
//        modtagBesked(OK<forbind>)
        String svarBesked = modtagBesked();
//        sendBesked(OK<ok>)
        sendBesked();
        while (true){
//            modtagBesked(ORDRE <gruppe>, <flag>)
            String modtagetBesked = modtagBesked();
//            sendBesked(OK <ordre:operationTid>)
            sendBesked();
//            modtagBesked(OK <ok>)
            String svarBesked2 = modtagBesked();
            if (svarBesked.equals("OK <ok>")){
                break;
            }
        }
    }

    public void sendBesked() {}
    public String modtagBesked() {
        return null;
    }

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

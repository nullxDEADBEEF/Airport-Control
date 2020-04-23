package com.nullxdeadbeef;

import java.net.Socket;

public class Pilot extends Thread {
    private Fly fly;
    private Socket socket;

    @Override
    public void run() {
        sendBesked( "FORBIND_FLY " + fly.getaC() + ", " + fly.getFlyRejse().getRuteNr() );
    }

    public void sendBesked( String besked ) {}
    public void modtagBesked( String besked ) {}

    public void mayday() {}

    public Fly getFly() {
        return fly;
    }

    public void setFly( Fly fly ) {
        this.fly = fly;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket( Socket socket ) {
        this.socket = socket;
    }
}

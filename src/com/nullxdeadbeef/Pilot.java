package com.nullxdeadbeef;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Pilot extends Thread {
    private Fly fly;
    private Socket socket;

    public Pilot(Fly fly) {
        this.fly = fly;
    }

    @Override
    public void run() {
        sendBesked( "FORBIND_FLY " + fly.getaC() + ", " + fly.getFlyRejse().getRuteNr() );
        modtagBesked();

    }

    public void sendBesked( String besked ) {
        try {
            DataOutputStream outputStream =
                    new DataOutputStream( socket.getOutputStream() );
            outputStream.writeUTF( besked );
        } catch ( IOException ex ) {
            ex.printStackTrace();
            System.exit( 1 );
        }

    }
    public void modtagBesked() {
        try {
            DataInputStream inputStream =
                    new DataInputStream( socket.getInputStream() );
            String besked = inputStream.readUTF();
            if ( besked.contains( "FORBIND" ) ) {
                // TODO: check if right airplane

            }
        } catch ( IOException ex ) {
            ex.printStackTrace();
            System.exit( 1 );
        }
    }

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

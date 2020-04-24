package com.nullxdeadbeef;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class PilotThread extends Thread {
    private FlyRejse flyRejse;
    private Socket socket;
    private InetAddress host;
    private int port;

    public PilotThread( FlyRejse flyRejse ) {
        this.flyRejse = flyRejse;
        this.port = 42069;
        try {
            host = InetAddress.getLocalHost();
        } catch ( UnknownHostException ex ) {
            ex.printStackTrace();
            System.exit( 1 );
        }
    }

    @Override
    public void run() {
        try {
            socket = new Socket( host, port );
            sendBesked( "FORBIND_FLY " + flyRejse.getFly().getaC() + ", " + flyRejse.getRuteNr() );
            modtagBesked();
        } catch ( IOException ex ) {
            ex.printStackTrace();
            System.exit( 1 );
        } finally {
            try {
                socket.close();
            } catch ( IOException ex ) {
                ex.printStackTrace();
                System.exit( 1 );
            }
        }

    }

    // TODO: husk at logge beskeden
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

    // TODO: husk at logge beskeden
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

    public FlyRejse getFly() {
        return flyRejse;
    }

    public void setFly( FlyRejse flyRejse ) {
        this.flyRejse = flyRejse;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket( Socket socket ) {
        this.socket = socket;
    }
}

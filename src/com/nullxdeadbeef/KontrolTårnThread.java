package com.nullxdeadbeef;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class KontrolTårnThread implements Runnable {
    protected Socket socket;
    public DataOutputStream data;

    KontrolTårnThread() {}
    KontrolTårnThread( Socket socket ) {
        this.socket = socket;
    }

    public void run() {
        try {
            DataInputStream inputStream = new DataInputStream( socket.getInputStream() );
            data = new DataOutputStream( socket.getOutputStream() );
            KontrolTårn kontrolTårn = new KontrolTårn();
            while ( true ) {
                String besked = inputStream.readUTF();
                kontrolTårn.sendTilAlle( besked );
                System.out.println( besked );
            }
        } catch ( IOException ex ) {
            ex.printStackTrace();
            System.exit( 1 );
        }

        finally {
            try {
                socket.close();
                System.out.println( "Lukker forbindelse..." );
            } catch ( IOException ex ) {
                ex.printStackTrace();
                System.exit( 1 );
            }
        }
    }
}

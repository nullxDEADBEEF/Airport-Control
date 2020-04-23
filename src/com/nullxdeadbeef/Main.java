package com.nullxdeadbeef;

import com.nullxdeadbeef.Log.IOSkriver;
import com.nullxdeadbeef.Service.StandpladsDAO;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
	    //StandpladsDAO st = new StandpladsDAO();
        //System.out.println(st.selectAll());
        //st.update(true, 1);
        //System.out.println(st.selectAll());


        // Test af Log funktionen
        IOSkriver ioSkriver = new IOSkriver();

        ioSkriver.skrivTilFil(LocalDateTime.now());
        ioSkriver.skrivTilFil(LocalDateTime.now());
        ioSkriver.skrivTilFil(LocalDateTime.now());
        ioSkriver.skrivTilFil(LocalDateTime.now());
        ioSkriver.skrivTilFil(LocalDateTime.now());
        ioSkriver.skrivTilFil(LocalDateTime.now());
        ioSkriver.skrivTilFil(LocalDateTime.now());
        ioSkriver.skrivTilFil(LocalDateTime.now());


    }
}

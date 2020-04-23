package com.nullxdeadbeef;

import com.nullxdeadbeef.Log.IOSkriver;
import com.nullxdeadbeef.Lufthavnspersonale.Pilot;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class IOTest {

    @Test
    void ioTest(){
        FlyRejse testFlyRejse =
                new FlyRejse(LocalDate.parse("2019-09-19"), true, "D8 3563", LocalTime.of(11, 22, 10), "KRK");
        Standplads testStandplads = new Standplads(16, Standplads.Type.SMALL, false, 1000);
        Fly testFly = new Fly("73H", testStandplads, testFlyRejse, true, true);
        com.nullxdeadbeef.Lufthavnspersonale.Pilot testPilot = new Pilot(testFly);

        IOSkriver ioSkriver = new IOSkriver();

        assertTrue(ioSkriver.skrivTilFil(testPilot, testFlyRejse.getKlokkeslæt(), "Dette er en besked til Hanne"));

    }
}

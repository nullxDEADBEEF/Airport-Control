package com.nullxdeadbeef;

import com.nullxdeadbeef.Log.IOSkriver;
import com.nullxdeadbeef.Lufthavnspersonale.Pilot;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FlyTest {

    @Test
    void taxi() {
        Standplads testStandplads = new Standplads(16, Standplads.Type.SMALL, false, 1000);
        Fly testFly = new Fly("73H", testStandplads, true, true);
        FlyRejse testFlyRejse =
                new FlyRejse(LocalDate.parse("2019-09-19"), true, "D8 3563",
                        LocalTime.of(00, 10), "KRK", testFly);

        Pilot testPilot = new Pilot(testFlyRejse);
//        Burde tage 2 minutter at køre 1000 meter med 30km/h

        assertEquals(2, testPilot.getFlyRejse().getFly().taxi());
    }
}
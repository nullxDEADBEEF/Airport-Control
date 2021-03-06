package com.nullxdeadbeef;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KontrolTårnTest {


    @Test
    void startSimulering() {
        Standplads testStandplads = new Standplads(16, Standplads.Type.SMALL, false, 1000);
        Fly testFly = new Fly("73H", testStandplads, true, true);
        FlyRejse testFlyRejse =
                new FlyRejse(LocalDate.parse("2019-09-19"), true, "D8 3563",
                        LocalTime.of(00, 10), "KRK", testFly);
        KontrolTårn kontrolTårn = new KontrolTårn();
        ArrayList<FlyRejse> aktuelleFly = new ArrayList<>();
        aktuelleFly.add(testFlyRejse);
        LocalDateTime tidspunkt = LocalDateTime.parse("2019-09-19T01:00:00");
        kontrolTårn.indenforKlokkeslaet( aktuelleFly, tidspunkt );

    }

    @Test
    void indenforKlokkeslaet() {
        //tester om der skabes en ny tråd hvis flyet er indenfor tidspunkt
    }

    @Test
    void sendTilAlle() {
    }

    @Test
    void modtagBesked() {
    }

    @Test
    void sendBesked() {
    }

    @Test
    void getFlyListe() {
    }

    @Test
    void getAktuelleFly() {
    }

    @Test
    void getForbundedeFly() {
    }

    @Test
    void inkrementerTidspunkt() {
    }

    @Test
    void klokkeTest(){
        Standplads testStandplads = new Standplads(16, Standplads.Type.SMALL, false, 1000);
        Fly testFly = new Fly("73H", testStandplads, true, true);
        FlyRejse testFlyRejse =
                new FlyRejse(LocalDate.parse("2019-09-19"), true, "D8 3563",
                        LocalTime.of(00, 10), "KRK", testFly);
        KontrolTårn kontrolTårn = new KontrolTårn();
        ArrayList<FlyRejse> aktuelleFly = new ArrayList<>();

        ArrayList<Fly> testArray = new ArrayList<>();
        testArray.add(testFly);

    }
}
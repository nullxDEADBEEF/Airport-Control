package com.nullxdeadbeef;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class KontrolTårnTest {

    @Test
    void startSimulering() {
        FlyRejse testFlyRejse =
                new FlyRejse(LocalDate.parse("2019-09-19"), true, "D8 3563", LocalTime.of(00, 10), "KRK");
        Standplads testStandplads = new Standplads(16, Standplads.Type.SMALL, false, 1000);
        Fly testFly = new Fly("73H", testStandplads, testFlyRejse, true, true);
        KontrolTårn kontrolTårn = new KontrolTårn();
        LocalDateTime now = LocalDateTime.now();
        kontrolTårn.startSimulering(now);
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
}
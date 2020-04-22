package com.nullxdeadbeef;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class KontrolTårnTest {

    @Test
    void startSimulering() {
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
package com.nullxdeadbeef.Lufthavnspersonale;

import com.nullxdeadbeef.Standplads;

public class Brændstof extends Lufthavnspersonale {
    public Brændstof(Standplads placering) {
        this.setPlacering(placering);
//        Påfyldning af brændstof, 15 min
        setOperationTid(15);
    }
}

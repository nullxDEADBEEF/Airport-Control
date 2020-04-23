package com.nullxdeadbeef.Lufthavnspersonale;

import com.nullxdeadbeef.Standplads;

public class Gate extends Lufthavnspersonale {
    public Gate(Standplads placering) {
        this.setPlacering(placering);
//        Påfyldning af passagerer, 25 min
        setOperationTid(25);
    }
}

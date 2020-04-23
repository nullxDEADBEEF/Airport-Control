package com.nullxdeadbeef.Lufthavnspersonale;

import com.nullxdeadbeef.Standplads;

public class Bagage extends Lufthavnspersonale {
    public Bagage(Standplads placering) {
        this.setPlacering(placering);
//        Påfyldning af bagage, 15 min
        setOperationTid(15);
    }
}

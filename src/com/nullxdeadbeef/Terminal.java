package com.nullxdeadbeef;

import java.util.Map;

public class Terminal {
    private Map<Integer, Standplads> standpladser;

    public Terminal(Map<Integer, Standplads> standpladser) {
        this.standpladser = standpladser;
    }

    public Map<Integer, Standplads> getStandpladser() {
        return standpladser;
    }

    public void setStandpladser( Map<Integer, Standplads> standpladser ) {
        this.standpladser = standpladser;
    }
}



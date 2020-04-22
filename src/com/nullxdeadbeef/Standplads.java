package com.nullxdeadbeef;

enum Type {
    SMALL, MEDIUM, BIG
}

public class Standplads {
    private int standpladsNr;
    private Type type;

    public int getStandpladsNr() {
        return standpladsNr;
    }

    public void setStandpladsNr( int standpladsNr ) {
        this.standpladsNr = standpladsNr;
    }

    public Type getType() {
        return type;
    }

    public void setType( Type type ) {
        this.type = type;
    }
}

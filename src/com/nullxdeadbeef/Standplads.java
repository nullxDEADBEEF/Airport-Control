package com.nullxdeadbeef;


public class Standplads {
    private int standpladsNr;
    private Type type;
    private Boolean ledig;

    public enum Type {
        SMALL, MEDIUM, BIG
    }

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

    public Boolean getLedig() {
        return ledig;
    }

    public void setLedig(Boolean ledig) {
        this.ledig = ledig;
    }
}

package com.nullxdeadbeef;


public class Standplads {
    private int standpladsNr;
    private Type type;
    private boolean ledig;
/*    Ved at holde styr paa distancen mellem standplads og landingsbane sådan her
    gør vi det super nemt at beregne tiden det tager at køre til og fra standpladser.*/
    private int meterTilLandingsbane;

    public enum Type {
        SMALL, MEDIUM, BIG
    }

    public Standplads(){}

    public Standplads(int standpladsNr, Type type, boolean ledig) {
        this.standpladsNr = standpladsNr;
        this.type = type;
        this.ledig = ledig;
    }

    public Standplads(int standpladsNr, Type type, boolean ledig, int meterTilLandingsbane) {
        this.standpladsNr = standpladsNr;
        this.type = type;
        this.ledig = ledig;
        this.meterTilLandingsbane = meterTilLandingsbane;
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

    public boolean getLedig() {
        return ledig;
    }

    public void setLedig(boolean ledig) {
        this.ledig = ledig;
    }

    public String toString() {
        return "Nr: " + standpladsNr + " Type: " + type + " ledig: " + ledig;
    }

    public boolean isLedig() {
        return ledig;
    }

    public int getMeterTilLandingsbane() {
        return meterTilLandingsbane;
    }

    public void setMeterTilLandingsbane(int meterTilLandingsbane) {
        this.meterTilLandingsbane = meterTilLandingsbane;
    }
}

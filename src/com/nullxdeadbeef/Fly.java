package com.nullxdeadbeef;

public class Fly {
    private String aC;
    private Standplads standplads;
    private FlyRejse flyRejse;
    private Status status;
    private boolean passagerer;
    private boolean baggage;
    private boolean brændstof;
    private int taxiHastinghedMeterMin;

    public Fly() {
    }

    public Fly(String aC, Standplads standplads, FlyRejse flyRejse, boolean passagerer, boolean baggage) {
        this.aC = aC;
        this.standplads = standplads;
        this.flyRejse = flyRejse;
        this.passagerer = passagerer;
        this.baggage = baggage;
//        Fly mangler altid brændstof
        this.brændstof = false;
//        500 Meter/Min = 30 KM/H
        taxiHastinghedMeterMin = 500;
    }

    //    returnerer tiden det tager at køre distancen mellem standplads og landingsbane, i minutter
    public int taxi(){
        return this.standplads.getMeterTilLandingsbane() / taxiHastinghedMeterMin;
    }

    public void passagererAf() {}
    public void baggageAf() {}
    public void brændstofPå() {}
    public void baggagePå() {}
    public void passagererPå() {}

    public String getaC() {
        return aC;
    }

    public void setaC(String aC) {
        this.aC = aC;
    }

    public Standplads getStandplads() {
        return standplads;
    }

    public void setStandplads(Standplads standplads) {
        this.standplads = standplads;
    }

    public FlyRejse getFlyRejse() {
        return flyRejse;
    }

    public void setFlyRejse(FlyRejse flyRejse) {
        this.flyRejse = flyRejse;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isPassagerer() {
        return passagerer;
    }

    public void setPassagerer(boolean passagerer) {
        this.passagerer = passagerer;
    }

    public boolean isBaggage() {
        return baggage;
    }

    public void setBaggage(boolean baggage) {
        this.baggage = baggage;
    }

    public boolean isBrændstof() {
        return brændstof;
    }

    public void setBrændstof(boolean brændstof) {
        this.brændstof = brændstof;
    }
}

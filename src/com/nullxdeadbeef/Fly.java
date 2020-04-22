package com.nullxdeadbeef;

public class Fly {
    private Standplads standplads;
    private FlyRejse flyRejse;
    private TaxiRute taxiRute;
    private Status status;
    private String ac;

    public void passagererAf() {}
    public void baggageAf() {}
    public void brændstofPå() {}
    public void baggagePå() {}
    public void passagererPå() {}

    public Standplads getStandplads() {
        return standplads;
    }

    public void setStandplads( Standplads standplads ) {
        this.standplads = standplads;
    }

    public FlyRejse getFlyRejse() {
        return flyRejse;
    }

    public void setFlyRejse( FlyRejse flyRejse ) {
        this.flyRejse = flyRejse;
    }

    public TaxiRute getTaxiRute() {
        return taxiRute;
    }

    public void setTaxiRute( TaxiRute taxiRute ) {
        this.taxiRute = taxiRute;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus( Status status ) {
        this.status = status;
    }

    public String getAc() { return ac; }

    public void setAc(String ac) { this.ac = ac; }
}

package com.nullxdeadbeef;

public class Fly {
    private String aC;
    private Standplads standplads;
    private FlyRejse flyRejse;
    private TaxiRute taxiRute;
    private Status status;
    private boolean passagerer;
    private boolean baggage;
    private boolean brændstof;

    public void passagererAf() {
        setPassagerer(false);
    }
    public void baggageAf() {
        setBaggage(false);
    }
    public void brændstofPå() {
        setBrændstof(true);
    }
    public void baggagePå() {
        setBaggage(true);
    }
    public void passagererPå() {
        setPassagerer(true);
    }

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

    public TaxiRute getTaxiRute() {
        return taxiRute;
    }

    public void setTaxiRute(TaxiRute taxiRute) {
        this.taxiRute = taxiRute;
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

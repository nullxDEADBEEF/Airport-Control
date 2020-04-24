package com.nullxdeadbeef;

import java.time.*;

public class FlyRejse {

    private LocalDate dato;
    private Boolean ankomst;
    private String ruteNr;
    private LocalTime klokkeslæt;
    private String origin_destination;
    private Fly fly;

    public FlyRejse() {
    }

    public FlyRejse(LocalDate dato, Boolean ankomst, String ruteNr, LocalTime klokkeslæt, String origin_destination) {
        this.dato = dato;
        this.ankomst = ankomst;
        this.ruteNr = ruteNr;
        this.klokkeslæt = klokkeslæt;
        this.origin_destination = origin_destination;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public Boolean getAnkomst() {
        return ankomst;
    }

    public void setAnkomst(Boolean ankomst) {
        this.ankomst = ankomst;
    }

    public String getRuteNr() {
        return ruteNr;
    }

    public void setRuteNr(String ruteNr) {
        this.ruteNr = ruteNr;
    }

    public LocalTime getKlokkeslæt() {
        return klokkeslæt;
    }

    public void setKlokkeslæt(LocalTime klokkeslæt) {
        this.klokkeslæt = klokkeslæt;
    }

    public String getOrigin_destination() {
        return origin_destination;
    }

    public void setOrigin_destination(String origin_destination) {
        this.origin_destination = origin_destination;
    }

    public Fly getFly() {
        return fly;
    }

    public void setFly(Fly fly) {
        this.fly = fly;
    }

    @Override
    public String toString() {
        return "FlyRejse{" +
                "dato=" + dato +
                ", ankomst=" + ankomst +
                ", ruteNr='" + ruteNr + '\'' +
                ", klokkeslæt=" + klokkeslæt +
                ", origin_destination='" + origin_destination + '\'' +
                ", fly=" + fly +
                '}';
    }
}

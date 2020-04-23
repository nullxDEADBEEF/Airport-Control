package com.nullxdeadbeef;

import java.sql.Time;
import java.util.Date;

public class FlyRejse {

    private Date dato;
    private Boolean ankomst;
    private String ruteNr;
    private Time klokkeslæt;
    private String origin_destination;

    public FlyRejse() {
    }

    public FlyRejse(Date dato, Boolean ankomst, String ruteNr, Time klokkeslæt, String origin_destination) {
        this.dato = dato;
        this.ankomst = ankomst;
        this.ruteNr = ruteNr;
        this.klokkeslæt = klokkeslæt;
        this.origin_destination = origin_destination;
    }

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
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

    public Time getKlokkeslæt() {
        return klokkeslæt;
    }

    public void setKlokkeslæt(Time klokkeslæt) {
        this.klokkeslæt = klokkeslæt;
    }

    public String getOrigin_destination() {
        return origin_destination;
    }

    public void setOrigin_destination(String origin_destination) {
        this.origin_destination = origin_destination;
    }
}

package com.nullxdeadbeef;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public class FlyRejse {

    private Date dato;
    private Boolean ankomst;
    private String ruteNr;
    private LocalTime klokkeslæt;
    private String origin_destination;

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

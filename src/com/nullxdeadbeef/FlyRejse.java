package com.nullxdeadbeef;

import java.sql.Time;
import java.util.Date;

public class FlyRejse {

    private Date dato;
    private Boolean arrival;
    private String ruteNr;
    private Time scheduledTime;
    private String origin_destination;
    private Fly fly;

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public Boolean getArrival() {
        return arrival;
    }

    public void setArrival(Boolean arrival) {
        this.arrival = arrival;
    }

    public String getRuteNr() {
        return ruteNr;
    }

    public void setRuteNr(String ruteNr) {
        this.ruteNr = ruteNr;
    }

    public Time getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Time scheduledTime) {
        this.scheduledTime = scheduledTime;
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
}

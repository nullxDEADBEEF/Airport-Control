package com.nullxdeadbeef.Lufthavnspersonale;

import com.nullxdeadbeef.FlyRejse;

public class Pilot extends Lufthavnspersonale {
    private FlyRejse flyRejse;

    public Pilot(FlyRejse flyRejse) {
        this.flyRejse = flyRejse;
//        Operationstiden for en pilot er tiden det tager at taxie til eller fra standpladsen.
        setOperationTid(flyRejse.getFly().taxi());
    }

    public void mayday() {}

    public FlyRejse getFlyRejse() {
        return flyRejse;
    }

    public void setFlyRejse(FlyRejse flyRejse) {
        this.flyRejse = flyRejse;
    }
}

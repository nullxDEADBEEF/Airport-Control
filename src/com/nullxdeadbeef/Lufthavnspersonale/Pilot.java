package com.nullxdeadbeef.Lufthavnspersonale;

import com.nullxdeadbeef.Fly;

public class Pilot extends Lufthavnspersonale {
    private Fly fly;

    public Pilot(Fly fly) {
        this.fly = fly;
//        Operationstiden for en pilot er tiden det tager at taxie til eller fra standpladsen.
        setOperationTid(fly.taxi());
    }

    public void mayday() {}

    public Fly getFly() {
        return fly;
    }

    public void setFly(Fly fly) {
        this.fly = fly;
    }
}

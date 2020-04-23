package com.nullxdeadbeef.Lufthavnspersonale;

import com.nullxdeadbeef.Fly;

public class Pilot extends Lufthavnspersonale {
    private Fly fly;

    public Pilot(Fly fly) {
        this.fly = fly;
    }

    public void mayday() {}

    public Fly getFly() {
        return fly;
    }

    public void setFly(Fly fly) {
        this.fly = fly;
    }
}

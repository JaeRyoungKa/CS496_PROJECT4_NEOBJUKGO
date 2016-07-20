package com.example.q.neobjukgo;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreatureMob extends StuffCreature {

    public String name;
    public StuffCreatureMob(double health, double attack, double armor, String name) {
        super(health,attack,armor);
        this.name = name;
    }


}

package com.example.q.neobjukgo;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreatureMob extends StuffCreature {

    private String name;
    public StuffCreatureMob(Room room, double health, double attack, double armor, String name) {
        super(room,health,attack,armor);
        this.name = name;
    }
}

package com.example.q.neobjukgo;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreature {

    private Room room;
    private double health;
    private double attack;
    private double armor;

    public StuffCreature(Room room, double health, double attack, double armor) {
        this.room = room;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    public void moveTo(int x, int y) {

    }

}

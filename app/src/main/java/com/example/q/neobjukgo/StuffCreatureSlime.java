package com.example.q.neobjukgo;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreatureSlime extends StuffCreature {

    public StuffCreatureSlime(double health, double attack, double armor) {
        super(health, attack, armor);
    }

    @Override
    public void onUpdate() {
        for (Map.Direction dir : Map.Direction.values()) {
            Room i = room.getRoom(dir);
        }
    }

}

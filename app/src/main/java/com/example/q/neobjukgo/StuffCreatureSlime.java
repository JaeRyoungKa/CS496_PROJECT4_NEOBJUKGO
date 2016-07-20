package com.example.q.neobjukgo;

import java.util.Random;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreatureSlime extends StuffCreatureMob {
    public StuffCreatureSlime(double health, double attack, double armor) {
        super(health, attack, armor, null);
        this.name = naming("슬라임");
    }

    @Override
    public void onUpdate() {
        // moving part
        Random random = new Random();
        int value = random.nextInt(10000);
        double prob = 0.08;
        if (value < 10000 * prob * 0.25) this.onMove(Map.Direction.UP);
        else if (value < 10000 * prob * 0.50 ) this.onMove(Map.Direction.LEFT);
        else if (value < 10000 * prob * 0.75 ) this.onMove(Map.Direction.RIGHT);
        else if (value < 10000 * prob * 1.00 ) this.onMove(Map.Direction.DOWN);

        // attacking part
        Room i = room.getRoom();
        for (Object things : i.getStuffs()) {
            if (things instanceof StuffCreaturePlayer) {
                ((StuffCreaturePlayer) things).attack(this);
            }
        }
    }
}

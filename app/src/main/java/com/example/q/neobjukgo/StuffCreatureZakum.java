package com.example.q.neobjukgo;

import java.util.Random;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreatureZakum extends StuffCreatureMob {
    public StuffCreatureZakum(double health, double attack, double armor) {
        super(health, attack, armor, null);
        this.name = naming("식인 식물");
    }

    @Override
    public void onUpdate() {
        // moving part
        Random random = new Random();
        int value = random.nextInt(10000);
        double prob = 0.00;
        if (value < 10000 * prob * 0.25) this.onMove(Map.Direction.UP);
        else if (value < 10000 * prob * 0.50 ) this.onMove(Map.Direction.LEFT);
        else if (value < 10000 * prob * 0.75 ) this.onMove(Map.Direction.RIGHT);
        else if (value < 10000 * prob * 1.00 ) this.onMove(Map.Direction.DOWN);

        // attacking part
        Room i = room.getRoom();
        for (Object things : i.getStuffs()) {
            if (things instanceof StuffCreaturePlayer) {
                this.attack((StuffCreaturePlayer) things);
            }
        }
    }
}

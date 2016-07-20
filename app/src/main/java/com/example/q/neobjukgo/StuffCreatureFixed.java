package com.example.q.neobjukgo;

import java.util.Random;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreatureFixed extends StuffCreatureMob {
    public StuffCreatureFixed(String prefix, String name, double health, double attack, double armor, int fortune) {
        super(health, attack, armor, fortune, name, prefix);
    }

    public StuffCreatureFixed(String prefix, String name, double health, double attack, double armor) {
        super(health, attack, armor, name, prefix);
    }

    @Override
    public void onUpdate() {
        // moving part
        Random random = new Random();

        double prob = 0.00;

        if (random.nextDouble() < prob) {
            int cnt = 0;
            for (Map.Direction i : Map.Direction.values()) {
                Room iRoom = getRoom().getRoom(i);
                if (iRoom !=  null)
                    cnt++;
            }
            int value = random.nextInt(cnt);
            int curIndex = 0;
            for (Map.Direction i : Map.Direction.values()) {
                Room iRoom = getRoom().getRoom(i);
                if (iRoom !=  null && curIndex++==value)
                    this.moveTo(i);
            }
        }

        // attacking part
        Room i = room.getRoom();
        for (Object things : i.getStuffs()) {
            if (things instanceof StuffCreaturePlayer) {
                this.attack( ((StuffCreaturePlayer) things));
            }
        }
    }
}

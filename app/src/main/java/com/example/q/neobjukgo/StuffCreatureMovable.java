package com.example.q.neobjukgo;

import android.util.Log;

import java.util.Random;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreatureMovable extends StuffCreatureMob {

    private double move;

    public StuffCreatureMovable(String prefix, String name, double health, double attack, double armor, int fortune, double move) {
        super(health, attack, armor, fortune, name, prefix);
        this.move = move;
    }

    public StuffCreatureMovable(String prefix, String name, double health, double attack, double armor, double move) {
        super(health, attack, armor, name, prefix);
        this.move = move;
    }

    @Override
    public void onUpdate() {
        // moving part
        if (random.nextDouble() < move) {
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
                if (iRoom !=  null && (curIndex++)==value) {
                    this.moveTo(i);
                }
            }
        }

        // attacking part
        Room i = room.getRoom();
        for (Object things : i.getStuffs()) {
            if (things instanceof StuffCreaturePlayer) {
                this.attack(((StuffCreaturePlayer) things));
            }
        }
    }
}

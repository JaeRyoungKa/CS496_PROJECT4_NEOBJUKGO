package com.example.q.neobjukgo;

import java.util.Random;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreatureWolf extends StuffCreatureMob {
    public StuffCreatureWolf(double health, double attack, double armor) {
        super(health, attack, armor, null);
        String prefix1 = null;
        String prefix2 = null;
        switch ((int) attack/10) { // TODO : fix this if needed
            case 0 : prefix1 = "짱짱 약하고"; break;
            case 1 : prefix1 = "짱 약하고"; break;
            case 2 : prefix1 = "약하고"; break;
            case 3 : prefix1 = "조금 약하고"; break;
            case 4 : prefix1 = "다소 약하고"; break;
            case 5 : prefix1 = "다소 강하고"; break;
            case 6 : prefix1 = "조금 강하고"; break;
            case 7 : prefix1 = "강하고"; break;
            case 8 : prefix1 = "짱 강하고"; break;
            case 9 : prefix1 = "짱짱 강하고"; break;
        }
        switch ((int) armor/10) { // TODO : fix this if needed
            case 0 : prefix2 = "부서지기 쉬운"; break;
            case 1 : prefix2 = "공격에 취약한"; break;
            case 2 : prefix2 = "방어도가 낮은"; break;
            case 3 : prefix2 = "허름한"; break;
            case 4 : prefix2 = "평범한"; break;
            case 5 : prefix2 = "평범한"; break;
            case 6 : prefix2 = "튼튼한"; break;
            case 7 : prefix2 = "강인한"; break;
            case 8 : prefix2 = "매우 튼튼한"; break;
            case 9 : prefix2 = "매우 강인한"; break;
        }
        this.name = prefix1+" "+prefix2+" 웨어울프";
    }

    @Override
    public void onUpdate() {
        Random random = new Random();
        int value = random.nextInt(10000);
        double prob = 0.1;
        if (value < 10000 * prob * 0.25) this.onMove(Map.Direction.UP);
        else if (value < 10000 * prob * 0.50 ) this.onMove(Map.Direction.LEFT);
        else if (value < 10000 * prob * 0.75 ) this.onMove(Map.Direction.RIGHT);
        else if (value < 10000 * prob * 1.00 ) this.onMove(Map.Direction.DOWN);
    }

    protected void onMove(Map.Direction dir) {
        Room i = room.getRoom(dir);
        boolean flag = false;
        for (Object things : i.getStuffs()) {
            if (things instanceof StuffCreatureMob) flag = true;
        }
        if (!flag) this.moveTo(dir);
    }

    protected void onDead() {
        // TODO : Drop item(s)
    }


}
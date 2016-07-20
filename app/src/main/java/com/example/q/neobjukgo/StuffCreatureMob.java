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

    @Override
    protected void onDead() {
        StuffItem droppeditem = new StuffItem();
        
    }

    protected void onMove(Map.Direction dir) {
        Room i = room.getRoom(dir);
        boolean flag = false;
        for (Object things : i.getStuffs()) {
            if (things instanceof StuffCreatureMob) flag = true;
        }
        if (!flag) this.moveTo(dir);
    }

    protected String naming(String monstername) {
        String prefix1 = null;
        String prefix2 = null;
        switch ((int) super.attack/10) { // TODO : fix this if needed
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
        switch ((int) super.armor/10) { // TODO : fix this if needed
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

        return prefix1+" "+prefix2+" "+monstername;
    }


}

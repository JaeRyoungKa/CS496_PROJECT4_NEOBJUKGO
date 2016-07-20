package com.example.q.neobjukgo;

import java.util.Random;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreatureMob extends StuffCreature {

    private String name;
    private String prefix;
    private double attack;
    private double armor;
    private int fortune;

    public StuffCreatureMob(double health, double attack, double armor, String name, String prefix) {
        super(health);
        this.attack = attack;
        this.armor = armor;
        this.name = name;
        this.prefix = prefix;
        this.fortune = 1;
    }

    public StuffCreatureMob(double health, double attack, double armor, int fortune, String name, String prefix) {
        super(health);
        this.attack = attack;
        this.armor = armor;
        this.name = name;
        this.prefix = prefix;
        this.fortune = fortune;
    }

    @Override
    public double getAttack() {
        return attack;
    }
    @Override
    public double getArmor() {
        return armor;
    }

    @Override
    protected void onDeath() {
        ManagerLogger.getInstance().log(toString()+"이(가) 죽었습니다.");
        for (int i = 0 ; i < fortune; i++) {
            if (random.nextInt(5) == 0) {
                if (random.nextInt(2) == 0) {
                    StuffItem droppeditem = new StuffItemArmor(random.nextInt((int) Math.max(10, attack + 2)));
                    getRoom().putStuff(droppeditem);
                    ManagerLogger.getInstance().log(droppeditem.toString() + "이(가) 드롭되었습니다.");
                }
                if (random.nextInt(2) == 0) {
                    StuffItem droppeditem = new StuffItemWeapon(random.nextInt((int) Math.max(10, armor + 2)));
                    getRoom().putStuff(droppeditem);
                    ManagerLogger.getInstance().log(droppeditem.toString() + "이(가) 드롭되었습니다.");
                }
            }
        }
        getRoom().remove(this);
    }

    public String toStringRender() {
        return name;
    }

    public String toString() {
        /*
        switch ((int) this.attack) { // TODO : fix this if needed
            case 0 : prefix1 = "무해하고"; break;
            case 1 : prefix1 = "연약하고"; break;
            case 2 : prefix1 = "손쉽고"; break;
            case 3 : prefix1 = "약하고"; break;
            case 4 : prefix1 = "일반적이고"; break;
            case 5 : prefix1 = "강하고"; break;
            case 6 : prefix1 = "괴력과"; break;
            case 7 : prefix1 = "위험하고"; break;
            case 8 : prefix1 = "치명적이고"; break;
            case 9 : prefix1 = "막을수없고"; break;
        }
        switch ((int) this.armor) { // TODO : fix this if needed
            case 0 : prefix2 = "유리같은"; break;
            case 1 : prefix2 = "취약한"; break;
            case 2 : prefix2 = "벌거벗은"; break;
            case 3 : prefix2 = "허름한"; break;
            case 4 : prefix2 = "평범한"; break;
            case 5 : prefix2 = "튼튼한"; break;
            case 6 : prefix2 = "강인한"; break;
            case 7 : prefix2 = "중무장의"; break;
            case 8 : prefix2 = "바위같은"; break;
            case 9 : prefix2 = "부서지지않는"; break;
        }
        */

        if (prefix != null)
             return prefix+" "+name + " [" + attack +", " + armor + "]";
        else
            return name + " [" + attack +", " + armor + "]";
    }


}

package com.example.q.neobjukgo;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreatureMob extends StuffCreature {

    public String name;
    public double attack;
    public double armor;

    public StuffCreatureMob(double health, double attack, double armor, String name) {
        super(health);
        this.attack = attack;
        this.armor = armor;
        this.name = name;
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
        StuffItem droppeditem = new StuffItem();
        getRoom().add(droppeditem);
        ManagerLogger.getInstance().log(toString()+"이(가) 죽었습니다.");
        ManagerLogger.getInstance().log(droppeditem.toString()+"이(가) 드롭되었습니다.");
        getRoom().remove(this);
    }

    protected void move(Map.Direction dir) {
        Room i = room.getRoom(dir);
        boolean flag = false;
        for (Object things : i.getStuffs()) {
            if (things instanceof StuffCreatureMob) flag = true;
        }
        if (!flag) this.moveTo(dir);
    }

    public String toString() {
        String prefix1 = null;
        String prefix2 = null;
        switch ((int) this.attack/10) { // TODO : fix this if needed
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
        switch ((int) this.armor/10) { // TODO : fix this if needed
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

        return prefix1+" "+prefix2+" "+name;
    }


}

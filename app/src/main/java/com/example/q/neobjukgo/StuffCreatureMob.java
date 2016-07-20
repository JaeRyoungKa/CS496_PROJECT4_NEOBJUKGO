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
    private double maxhealth;

    public StuffCreatureMob(double health, double attack, double armor, String name, String prefix) {
        super(health);
        this.maxhealth = health;
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
        ManagerLogger.getInstance().log(toString() + "이(가) 죽었습니다.");
        for (int i = 0; i < fortune; i++) {
            if (random.nextInt(4) == 0) {
                if (random.nextInt(2) == 0) {
                    StuffItem droppeditem = new StuffItemArmor(1+random.nextInt((int) attack + 2));
                    getRoom().putStuff(droppeditem);
                    ManagerLogger.getInstance().log(droppeditem.toString() + "이(가) 드롭되었습니다.");
                }
                if (random.nextInt(2) == 0) {
                    StuffItem droppeditem = new StuffItemWeapon(1+random.nextInt((int) armor + 2));
                    getRoom().putStuff(droppeditem);
                    ManagerLogger.getInstance().log(droppeditem.toString() + "이(가) 드롭되었습니다.");
                }
            }
            if (random.nextInt(5) == 0) {
                StuffItem droppeditem = new StuffItemPotion((int)(random.nextDouble()*8*(attack+armor))+1);
                getRoom().putStuff(droppeditem);
                ManagerLogger.getInstance().log(droppeditem.toString() + "이(가) 드롭되었습니다.");
            }
        }
        getRoom().remove(this);
    }

    public String toStringRender() {
        return name;
    }

    public String toString() {
        if (prefix != null)
            return prefix + " " + name + " [" + attack + ", " + armor + "]";
        else
            return name + " [" + attack + ", " + armor + "]";
    }

    @Override
    public double getMaxHealth() {
        return maxhealth;
    }
}

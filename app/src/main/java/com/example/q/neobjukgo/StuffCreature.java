package com.example.q.neobjukgo;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreature extends Stuff {


    private double health;
    public double attack;
    public double armor;

    public StuffCreature(double health, double attack, double armor) {
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    protected void onDead() {}

    public void moveTo(Map.Direction dir) {

    }
    public void attack(StuffCreature target) {
        double HPLost = (target.attack - this.armor);
        double DMGDealt = (this.attack - target.armor);
        this.health -= HPLost;
        target.health -= DMGDealt;
        ManagerLogger.getInstance().log(HPLost+"의 피해를 입고 "+DMGDealt+"의 피해를 입혔습니다.");
        if (target.health <= 0) target.onDead();
        if (this.health <= 0) this.onDead();
    }

}

package com.example.q.neobjukgo;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreature extends Stuff {


    private double health;


    public StuffCreature(double health) {
        this.health = health;
    }

    public double getAttack() {
        return 0;
    }

    public double getArmor() {
        return 0;
    }

    protected void onDeath() {}

    public void moveTo(Map.Direction dir) {

    }
    public void attack(StuffCreature target) {
        double HPLost = (target.getAttack() - this.getArmor());
        double DMGDealt = (this.getAttack() - target.getArmor());
        this.health -= HPLost;
        target.health -= DMGDealt;
        ManagerLogger.getInstance().log(target.toString()+"(으)로부터 "+HPLost+"의 피해를 입었습니다.");
        ManagerLogger.getInstance().log(target.toString()+"에게 "+DMGDealt+"의 피해를 입혔습니다.");
        if (target.health <= 0) target.onDeath();
        if (this.health <= 0) this.onDeath();
    }

}

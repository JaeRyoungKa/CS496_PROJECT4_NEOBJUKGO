package com.example.q.neobjukgo;

import java.util.Random;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreature extends Stuff {

    protected double health;
    protected Random random = new Random();

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

    public boolean isDead() {
        return health<=0;
    }

    public void moveTo(Map.Direction dir) {
        getRoom().remove(this);
        getRoom().getRoom(dir).putStuff(this);
    }

    public void attack(StuffCreature target) {
        if (!target.isDead()) {
            double damage = (this.getAttack()/Math.sqrt(target.getArmor()+1));
            target.health -= damage;
            ManagerLogger.getInstance().log(this.toString()+"(이)가 " + target.toString() + " 에게 "+((int)(10*damage))/10.0+"의 피해를 입혔습니다.");
            if (target.health <= 0) target.onDeath();
        }
    }

}

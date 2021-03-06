package com.example.q.neobjukgo;

import java.util.ArrayList;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreaturePlayer extends StuffCreature {

    private int level;
    private double exp;

    protected ArrayList<StuffItem> inventory;
    protected StuffItemWeapon weapon = new StuffItemWeapon(1);
    protected StuffItemArmor armor = new StuffItemArmor(1);

    public StuffCreaturePlayer (double health) {
        super(health);
        this.inventory = new ArrayList<>();
        this.level = 1;
        this.exp = 0;
    }

    @Override
    public double getAttack() {
        if (weapon==null) return level;
        return weapon.rank+level;
    }
    @Override
    public double getArmor() {
        if (armor==null) return level;
        return armor.rank+level;
    }

    public StuffItemArmor getItemArmor() {
        return armor;
    }

    public StuffItemWeapon getItemWeapon() {
        return weapon;
    }

    public double getHP() {
        return health;
    }

    public StuffItem equipItem(StuffItem item) {
        if (item instanceof  StuffItemWeapon)
            return equipItem((StuffItemWeapon)item);
        if (item instanceof  StuffItemArmor)
            return equipItem((StuffItemArmor)item);
        if (item instanceof  StuffItemPotion)
            return equipItem((StuffItemPotion)item);
        return null;
    }

    public StuffItem equipItem(StuffItemPotion item) {
        inventory.remove(item);
        heal(item.getHeal());
        return null;
    }

    public StuffItem equipItem(StuffItemWeapon item) {
        StuffItem temp = weapon;
        weapon=item;
        if (temp!=null)
            inventory.add(temp);
        inventory.remove(weapon);
        return temp;
    }

    public StuffItem equipItem(StuffItemArmor item) {
        StuffItem temp = armor;
        armor=item;
        if (temp!=null)
            inventory.add(temp);
        inventory.remove(armor);
        return temp;
    }

    @Override
    protected void onDeath() {
        if (weapon != null)
           dropItem(weapon);
        if (armor != null)
            dropItem(armor);
        weapon = null;
        armor = null;
        ManagerLogger.getInstance().log("죽어서 장비하고 있는 아이템을 잃었습니다.");
        getRoom().remove(this);
    }

    @Override
    public String toString() {
        return "플레이어";
    }

    public String toStringRender() {
        return "플레이어";
    }

    public void pickUpItem(StuffItem item) {
        if (item.getRoom().has(item)) {
            item.getRoom().remove(item);
            this.inventory.add(item);
        }
    }

    public void dropItem(StuffItem item) {
        if (this.inventory.contains(item)) {
            this.inventory.remove(item);
            getRoom().putStuff(item);
        }
    }

    public ArrayList<StuffItem> getInventory() {
        return inventory;
    }

    @Override
    public void onUpdate() {
        Room i = room.getRoom();
        for (Object things : i.getStuffs()) {
            if (things instanceof StuffCreatureMob) {
                this.attack((StuffCreatureMob) things);
                break;
            }
        }
        heal(getMaxHealth()/400.0);
    }

    public void heal(double amount) {
        health+=amount;
        health = Math.min(health,getMaxHealth());
    }

    @Override
    public double getMaxHealth() {
        return (level+3)*10.0;
    }

    @Override
    protected void onKill(StuffCreature target) {
        exp+=(target.getAttack()+target.getArmor())*target.getMaxHealth();
        while (exp > getExpGoal()) {
            exp -= getExpGoal();
            level+=1;
            heal(10);
        }
    }

    public int getLevel() {
        return level;
    }

    public double getExp() {
        return exp;
    }

    public double getExpGoal() {
        return (level+1)*50;
    }

}

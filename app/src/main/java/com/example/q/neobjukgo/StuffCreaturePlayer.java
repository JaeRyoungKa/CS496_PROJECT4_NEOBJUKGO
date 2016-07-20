package com.example.q.neobjukgo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreaturePlayer extends StuffCreature {

    protected ArrayList<StuffItem> inventory;
    protected StuffItemWeapon weapon = new StuffItemWeapon(2);
    protected StuffItemArmor armor = new StuffItemArmor(2);

    public StuffCreaturePlayer (double health) {
        super(health);
        this.inventory = new ArrayList<>();
    }

    @Override
    public double getAttack() {
        if (weapon==null) return 0;
        return weapon.item_performance;
    }
    @Override
    public double getArmor() {
        if (armor==null) return 0;
        return armor.item_performance;
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
        return null;
    }

    public StuffItem equipItem(StuffItemWeapon item) {
        StuffItem temp = weapon;
        weapon=item;
        inventory.add(temp);
        return temp;
    }

    public StuffItem equipItem(StuffItemArmor item) {
        StuffItem temp = armor;
        armor=item;
        inventory.add(temp);
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
        health+=0.1;


    }
}

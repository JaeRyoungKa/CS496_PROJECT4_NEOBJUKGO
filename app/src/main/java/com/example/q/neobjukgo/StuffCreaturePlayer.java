package com.example.q.neobjukgo;

import java.util.ArrayList;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreaturePlayer extends StuffCreature {

    private ArrayList<StuffItem> inventory;
    private StuffItemWeapon weapon;
    private StuffItemArmor armor;

    public StuffCreaturePlayer (double health) {
        super(health);
        this.inventory = new ArrayList<>();
        this.weapon = new StuffItemWeapon(1);
        this.armor = new StuffItemArmor(1);
    }

    @Override
    public double getAttack() {
        return weapon.item_performance;
    }
    @Override
    public double getArmor() {
        return armor.item_performance;
    }

    @Override
    protected void onDeath() {
        this.inventory = new ArrayList<StuffItem>();
        ManagerLogger.getInstance().log("죽어서 인벤토리에 있는 아이템을 모두 잃었습니다.");
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
            item.getRoom().remove(item);
            this.inventory.add(item);
        }
    }

    public ArrayList<StuffItem> getInventory() {
        return inventory;
    }

}

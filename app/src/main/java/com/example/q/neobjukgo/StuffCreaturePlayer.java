package com.example.q.neobjukgo;

import java.util.ArrayList;

/**
 * Created by q on 2016-07-20.
 */
public class StuffCreaturePlayer extends StuffCreature {

    protected ArrayList<StuffItem> inventory;
    protected StuffItemWeapon weapon;
    protected StuffItemArmor armor;

    public StuffCreaturePlayer (double health, double attack, double armor) {
        super(health,attack,armor);
        this.inventory = new ArrayList<>();
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
}

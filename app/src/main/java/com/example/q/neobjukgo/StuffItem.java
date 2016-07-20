package com.example.q.neobjukgo;

import java.util.Random;

/**
 * Created by q on 2016-07-20.
 */
public class StuffItem extends  Stuff {

    public int item_performance;
    Random random = new Random();
    int category = random.nextInt(2);

    public StuffItem(int item_performance) {
        if (category == 0) {
            StuffItemArmor item = new StuffItemArmor();
            item.item_performance = item_performance;
        }
        else {
            StuffItemWeapon item = new StuffItemWeapon();
            item.item_performance = item_performance;
        }
    }
    public StuffItem() {
        if (category == 0) {
            StuffItemArmor item = new StuffItemArmor();
            item.item_performance = random.nextInt(10);
        }
        else {
            StuffItemWeapon item = new StuffItemWeapon();
            item.item_performance = random.nextInt(10);
        }
    }


    public String toString() {
        String prefix = "";
        String surfix = "무기";
        if (this.category == 0) surfix = "방어구";
        switch (this.item_performance) {
            case 0 : prefix = "투명"; break;
            case 1 : prefix = "곧 깨질"; break;
            case 2 : prefix = "허름한"; break;
            case 3 : prefix = "부족한"; break;
            case 4 : prefix = "약한"; break;
            case 5 : prefix = "평범한"; break;
            case 6 : prefix = "레어"; break;
            case 7 : prefix = "에픽"; break;
            case 8 : prefix = "유니크"; break;
            case 9 : prefix = "레전드리"; break;
        }
        return prefix+" "+surfix;
    }

}

package com.example.q.neobjukgo;

import java.util.Random;

/**
 * Created by q on 2016-07-20.
 */
public class StuffItem extends  Stuff {

    private int Category; // 0 : Armor, 1 : weapon
    public int item_number;
    Random random = new Random();

    public StuffItem(int Category, int item_number) {
        this.Category = Category;
        this.item_number = item_number;
    }


    public StuffItem() {
        this.Category = random.nextInt(2);
        this.item_number = random.nextInt(10);
    }


    public String toString() {
        return "Item Sample 1";
    }

}

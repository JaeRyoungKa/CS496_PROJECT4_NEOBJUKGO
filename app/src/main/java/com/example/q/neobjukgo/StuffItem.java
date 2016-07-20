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
        this.item_performance = item_performance;
    }
    public StuffItem() {
        this.item_performance = random.nextInt(10);
    }




}

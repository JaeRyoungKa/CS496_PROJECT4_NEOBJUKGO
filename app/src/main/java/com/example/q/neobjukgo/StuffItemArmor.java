package com.example.q.neobjukgo;

import java.util.Random;

/**
 * Created by q on 2016-07-20.
 */
public class StuffItemArmor extends StuffItem {

    public StuffItemArmor(int performance) {
        super(performance);
    }

    public StuffItemArmor() {
        super (0);
        this.item_performance = random.nextInt(10);
    }
}

package com.example.q.neobjukgo;

import java.util.Random;

/**
 * Created by q on 2016-07-20.
 */
public class StuffItemArmor extends StuffItem {

    public StuffItemArmor(int number) {
        super(0,number);
    }

    public StuffItemArmor() {
        super (0, 0);
        this.item_number = random.nextInt(10);
    }
}

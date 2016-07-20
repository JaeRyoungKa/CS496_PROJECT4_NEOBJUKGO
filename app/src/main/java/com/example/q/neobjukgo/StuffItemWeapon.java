package com.example.q.neobjukgo;

/**
 * Created by q on 2016-07-20.
 */
public class StuffItemWeapon extends StuffItem {

    public StuffItemWeapon(int number) {
        super(1,number);
    }

    public StuffItemWeapon() {
        super (1, 0);
        this.item_number = random.nextInt(10);
    }
}

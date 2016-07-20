package com.example.q.neobjukgo;

/**
 * Created by q on 2016-07-20.
 */
public class StuffItemWeapon extends StuffItem {

    public StuffItemWeapon(int performance) {
        super(performance);
    }

    public StuffItemWeapon() {
        super (0);
        this.item_performance = random.nextInt(10);
    }
}

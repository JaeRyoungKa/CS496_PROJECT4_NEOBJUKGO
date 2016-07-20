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

    public String toString() {
        String prefix = "";
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
        return prefix+" "+"무기";
    }
}

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

    @Override
    public String toString() {
        String prefix = "";
        switch (this.item_performance) {
            case 0 : prefix = "망가진"; break;
            case 1 : prefix = "녹슨"; break;
            case 2 : prefix = "허름한"; break;
            case 3 : prefix = "불량"; break;
            case 4 : prefix = "약한"; break;
            case 5 : prefix = "평범한"; break;
            case 6 : prefix = "우수한"; break;
            case 7 : prefix = "최상품"; break;
            case 8 : prefix = "장인의"; break;
            case 9 : prefix = "전설의"; break;
        }
        return prefix+" "+"무기";
    }

    @Override
    public String toStringRender() {
        return toString();
    }
}

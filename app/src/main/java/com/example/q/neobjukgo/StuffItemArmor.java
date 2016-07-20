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
            case 6 : prefix = "괜찮은"; break;
            case 7 : prefix = "우수한"; break;
            case 8 : prefix = "최상급의"; break;
            case 9 : prefix = "최고의"; break;
            case 10 : prefix = "장인의"; break;
            case 11 : prefix = "금세기 최고의"; break;
            case 12 : prefix = "전설의"; break;
            case 13 : prefix = "악마가 가진"; break;
            case 14 : prefix = "신이 가진"; break;
            default: prefix = "+" + this.item_performance; break;
        }
        return prefix+" "+"방패";
    }

    @Override
    public String toStringRender() {
        return toString();
    }
}

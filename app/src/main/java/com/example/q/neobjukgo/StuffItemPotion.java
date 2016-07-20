package com.example.q.neobjukgo;

/**
 * Created by q on 2016-07-21.
 */
public class StuffItemPotion extends StuffItem {

    public StuffItemPotion(int rank) {
        super(rank);
    }

    @Override
    public String toString() {
        return "포션["+ rank +"]";
    }

    @Override
    public String toStringRender() {
        return "포션";
    }

    public double getHeal() {
        return this.rank;
    }

}

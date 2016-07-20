package com.example.q.neobjukgo;

/**
 * Created by q on 2016-07-20.
 */
public class StuffItem extends  Stuff {

    protected int rank;
    private int life;

    public StuffItem(int item_performance) {
        this.rank = item_performance;
        life=60;
    }

    public String toStringRender() {
        return "Unknown Item";
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        life--;
        if (life<0)
            getRoom().remove(this);
    }
}

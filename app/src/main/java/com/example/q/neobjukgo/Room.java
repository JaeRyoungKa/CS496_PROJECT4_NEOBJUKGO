package com.example.q.neobjukgo;

import android.graphics.Rect;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by q on 2016-07-20.
 */
public class Room {

    private ArrayList<Stuff> stuffs;
    private int x;
    private int y;
    private Map map;

    public Room(int x, int y, Map map) {
        this.x=x;
        this.y=y;
        this.map=map;
        stuffs = new ArrayList<Stuff>();
    }

    public Room getRoom(Map.Direction dir) {
        return map.getRoomAt(x+dir.getX(), y+dir.getY());
    }

    public void remove(Stuff s) {
        stuffs.remove(s);
    }

    public void add(Stuff s) {
        stuffs.add(s);
    }

    public ArrayList<Stuff> getStuffs() {
        return stuffs;
    }

    public void onUpdate() {
        for (Stuff i : stuffs) {
            i.onUpdate();
        }
    }

    public Rect getRect() {
        Rect ret = new Rect();
        ret.set(x*MapView.LENGTH,y*MapView.LENGTH,(x+1)*MapView.LENGTH,(y+1)*MapView.LENGTH);
        return ret;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

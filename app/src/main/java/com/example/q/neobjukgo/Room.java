package com.example.q.neobjukgo;

import android.graphics.Rect;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by q on 2016-07-20.
 */
public class Room {

    private ArrayList<Stuff> stuffs;
    private int x;
    private int y;
    private Map map;

    private LinkedList<Request> requests;

    public Room(int x, int y, Map map) {
        this.x = x;
        this.y = y;
        this.map = map;
        stuffs = new ArrayList<Stuff>();
        requests = new LinkedList<>();
    }

    public Room getRoom(Map.Direction dir) {
        return map.getRoomAt(x + dir.getX(), y + dir.getY());
    }

    public Room getRoom() {
        return map.getRoomAt(x, y);
    }

    public void putStuff(Stuff s) {
        this.add(s);
        s.setRoom(this);
    }

    public boolean has(Stuff s) {
        return stuffs.contains(s);
    }

    public void remove(Stuff s) {
        requests.addLast(new Request(false, s));
    }

    public void add(Stuff s) {
        requests.addLast(new Request(true, s));
    }

    public ArrayList<Stuff> getStuffs() {
        return stuffs;
    }

    public void onUpdate() {

        for (Stuff i : stuffs) {
            i.onUpdate();
        }

        while (!requests.isEmpty()) {
            Request r = requests.pop();
            if (r.add) {
                stuffs.add(r.s);
            } else {
                stuffs.remove(r.s);
            }
        }

    }

    public Rect getRect() {
        Rect ret = new Rect();
        ret.set(x * MapView.LENGTH, y * MapView.LENGTH, (x + 1) * MapView.LENGTH, (y + 1) * MapView.LENGTH);
        return ret;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private class Request {
        public boolean add;
        public Stuff s;

        public Request(boolean add, Stuff s) {
            this.add = add;
            this.s = s;
        }

    }

}

package com.example.q.neobjukgo;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by q on 2016-07-20.
 */
public class Room {

<<<<<<< HEAD
=======


>>>>>>> origin/master
    private ArrayList<Stuff> stuffs;
    private int x;
    private int y;
    private Map map;

    public Room getRoom(Map.Direction dir) {
        return map.getRoomAt(x+dir.getX(), y+dir.getY());
    }

    public void remove(Stuff s) {
        stuffs.remove(s);
    }

    public void add(Stuff s) {
        stuffs.add(s);
    }

}

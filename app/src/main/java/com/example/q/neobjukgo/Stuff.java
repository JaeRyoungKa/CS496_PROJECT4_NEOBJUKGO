package com.example.q.neobjukgo;

import java.util.Random;

/**
 * Created by q on 2016-07-20.
 */
public class Stuff {

    protected Room room;
    protected Random random = new Random();

    public Stuff() {
    }

    public void onUpdate() {

    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public String toStringRender() {
        return "Unknown Stuff";
    }

}

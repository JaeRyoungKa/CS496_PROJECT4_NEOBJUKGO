package com.example.q.neobjukgo;

import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.lang.reflect.Array;

/**
 * Created by q on 2016-07-20.
 */
public class ManagerGame {

    private static ManagerGame instance;
    private Map map;
    private StuffCreaturePlayer player;

    private ArrayAdapter<String> adapter;

    private ManagerGame() {
        map = new Map();
    }

    public static ManagerGame getInstance() {
        if (instance == null)
            instance = new ManagerGame();
        return instance;
    }

    public StuffCreaturePlayer getPlayer() {
        return player;
    }

    public void registerAdapter(BaseAdapter ad) {

    }

}

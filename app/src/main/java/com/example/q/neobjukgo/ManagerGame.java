package com.example.q.neobjukgo;

/**
 * Created by q on 2016-07-20.
 */
public class ManagerGame {

    private ManagerGame instance;
    private Map map;

    private ManagerGame() {
        map = new Map();
    }

    public ManagerGame getInstance() {
        if (instance == null)
            instance = new ManagerGame();
        return instance;
    }


}

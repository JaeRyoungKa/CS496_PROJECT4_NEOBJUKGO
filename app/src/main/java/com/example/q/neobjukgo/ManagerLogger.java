package com.example.q.neobjukgo;

import android.widget.ArrayAdapter;

/**
 * Created by q on 2016-07-20.
 */
public class ManagerLogger {

    private static ManagerLogger instance;
    private ArrayAdapter<String> adapter;

    private ManagerLogger() {

    }

    public static ManagerLogger getInstance() {
        if (instance == null)
            instance = new ManagerLogger();
        return instance;
    }

    public void registerAdapter(ArrayAdapter<String> ad) {
        this.adapter=ad;
    }

    public void log(String str) {
        adapter.add(str);
    }

}

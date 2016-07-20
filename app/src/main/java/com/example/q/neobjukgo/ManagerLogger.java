package com.example.q.neobjukgo;

/**
 * Created by q on 2016-07-20.
 */
public class ManagerLogger {

    private ManagerLogger instance;

    private ManagerLogger() {

    }

    public ManagerLogger getInstance() {
        if (instance == null)
            instance = new ManagerLogger();
        return instance;
    }

}

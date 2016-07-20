package com.example.q.neobjukgo;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.lang.reflect.Array;
import java.util.Timer;

/**
 * Created by q on 2016-07-20.
 */
public class ManagerGame {

    private static ManagerGame instance;
    private Map map;
    private MapView mapView;
    private StuffCreaturePlayer player;

    private ArrayAdapter<String> adapter;

    private ManagerGame() {
        map = new Map();
        player = new StuffCreaturePlayer(10,1,1);
        map.putStuffAt(player,0,0);
        ManagerPosition.getInstance().registerMap(map);
        new TimerTask().execute();
    }

    public static ManagerGame getInstance() {
        if (instance == null)
            instance = new ManagerGame();
        return instance;
    }

    public StuffCreaturePlayer getPlayer() {
        return player;
    }

    public void registerMapView(MapView mapView) {
        this.mapView = mapView;
        this.mapView.registerMap(map);
    }

    private void onUpdate() {
        ManagerPosition.getInstance().onUpdate();
        map.onUpdate();
        mapView.onUpdate();
    }

    private class TimerTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            onUpdate();
            new TimerTask().execute();
        }
    }

}

package com.example.q.neobjukgo;

import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by q on 2016-07-20.
 */
public class ManagerPosition {

    private static ManagerPosition instance;

    private Map map;
    private WifiManager wm;
    private ManagerPosition() {    }

    public static ManagerPosition getInstance() {
        if (instance == null)
            instance = new ManagerPosition();
        return instance;
    }

    public void onReceive(int pos) {

        if (pos == -1)
            return;

        int X = pos%10;
        int Y = pos/10;
        if (Y>3) Y--;
        map.moveStuffTo(ManagerGame.getInstance().getPlayer(),X,Y);
    }

    public void registerMap(Map map) {
        this.map = map;
    }

    public void registerWIFI(WifiManager wm) {
        this.wm = wm;
        wm.startScan();
    }

    public  void onUpdate() {
    }

    public class SendMSGTask extends AsyncTask<JSONObject, Void, Integer> {
        String rawURL;

        @Override
        protected Integer doInBackground(JSONObject... params) {
            rawURL = "http://oortcloud.ddns.net:8081";
            return  putJSON(params[0]);
        }

        @Override
        protected void onPostExecute(Integer zone) {
            onReceive(zone);
        }

        public int putJSON(JSONObject jobj) {
            OutputStream os = null;
            InputStream is = null;

            int len = 0;
            try {
                len = jobj.toString().getBytes("UTF-8").length;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            try {
                URL url = new URL(rawURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(5000 /* milliseconds */);
                conn.setConnectTimeout(1000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setFixedLengthStreamingMode(len);
                os = conn.getOutputStream();
                OutputStreamWriter wrt = new OutputStreamWriter(os, "UTF-8");
                Log.i("LogCat", "[SEND]ENCODING: " + wrt.getEncoding());
                Log.i("LogCat", "[SEND]JSON RAW: " + jobj.toString());
                wrt.write(jobj.toString());
                wrt.flush();
                conn.connect();
                int response = conn.getResponseCode();
                is = conn.getInputStream();
                //int zone = StreamHelper.readInt(is);
                int zone = 0;
                String res = StreamHelper.readIt(is);
                Log.i("LogCat", "[SEND]RESPOND : " + res);
                os.close();
                is.close();
                return Integer.parseInt(res);
            } catch (MalformedURLException e) {
                Log.i("LogCat", "[SEND]FAILED TO CONNECT by MalformedURLException");
            } catch (IOException e) {
                Log.i("LogCat", "[SEND]FAILED TO CONNECT by IOException");
                Log.i("LogCat", e.toString());
            }

            return -1;
        }
    }

}

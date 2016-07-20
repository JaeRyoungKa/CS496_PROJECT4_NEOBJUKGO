package com.example.q.neobjukgo;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ListView m_ListView;
    private ArrayAdapter<String> m_Adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Android에서 제공하는 string 문자열 하나를 출력 가능한 layout으로 어댑터 생성
        m_Adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
        ManagerLogger.getInstance().registerAdapter(m_Adapter);
        ManagerGame.getInstance().registerMapView((MapView)findViewById(R.id.map));
        // Xml에서 추가한 ListView 연결
        m_ListView = (ListView) findViewById(R.id.main_listview);
        // ListView에 어댑터 연결
        m_ListView.setAdapter(m_Adapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(0xBB000000));

        ((Button)findViewById(R.id.button_I)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ActivityInventory.class);
                startActivity(i);
            }
        });

        ((Button)findViewById(R.id.button_S)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ActivityStatus.class);
                startActivity(i);
            }
        });

        ManagerPosition.getInstance().registerWIFI(initializeWIFI());
    }

    private WifiManager initializeWIFI() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        // No explanation needed, we can request the permission.

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},2);

        Intent intent= new Intent(this.getIntent());

        String connectivity_context = Context.WIFI_SERVICE;
        final WifiManager wifi = (WifiManager)getSystemService(connectivity_context);

        if(!wifi.isWifiEnabled()){
            if(!wifi.isScanAlwaysAvailable() && wifi.getWifiState() != WifiManager.WIFI_STATE_ENABLING){
                wifi.setWifiEnabled(true);
            }
        }

        registerReceiver(new BroadcastReceiver(){
            @Override
            public void onReceive(Context context, Intent intent) {
                //       WifiInfo info = wifi.getConnectionInfo();
                List list = wifi.getScanResults();

                JSONObject obj = new JSONObject();
                try {
                    JSONArray jArray = new JSONArray();//배열이 필요할때
                    for (int i = 0; i < list.size(); i++)//배열
                    {
                        JSONObject sObject = new JSONObject();//배열 내에 들어갈 json
                        ScanResult temp = (ScanResult) list.get(i);
                        sObject.put("BSSID", temp.BSSID);
                        sObject.put("level", temp.level);
                        jArray.put(sObject);
                    }
                    obj.put("data", jArray);//배열을 넣음

                    // 20160717 15:38 for debugging purpose.
                    ManagerPosition.getInstance().new SendMSGTask().execute(obj);
                    wifi.startScan();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

        return wifi;
    }


    class BackgroundTask extends AsyncTask<Integer , Integer , Integer> {
        protected void onPreExecute() {
        }

        protected Integer doInBackground(Integer ... values) {
            return null;
        }

        protected void onProgressUpdate(Integer ... values) {
        }

        protected void onPostExecute(Integer result) {
        }
        protected void onCancelled() {
        }

    }
}

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
    String att;
    String def;
    int ATT;
    int DEF;
    int HP = 100;
    boolean isClear = false;
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

        ManagerLogger.getInstance().log("하나");
        ManagerLogger.getInstance().log("둘");
        ManagerLogger.getInstance().log("셋");
        ManagerLogger.getInstance().log("넷");
        ManagerLogger.getInstance().log("다섯");
        ManagerLogger.getInstance().log("여섯");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(0xBB000000));

         int temp = summon_random();
         ATT = temp/10;
         DEF = 80+temp%10*4;

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
            if(wifi.getWifiState() != WifiManager.WIFI_STATE_ENABLING){
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

    protected int summon_random() {
        int equip_number = getRandom(99,0);
        switch (equip_number/10) {
            case 0 : att = "짱짱 약하고"; break;
            case 1 : att = "짱 약하고"; break;
            case 2 : att = "약하고"; break;
            case 3 : att = "조금 약하고"; break;
            case 4 : att = "다소 약하고"; break;
            case 5 : att = "다소 강하고"; break;
            case 6 : att = "조금 강하고"; break;
            case 7 : att = "강하고"; break;
            case 8 : att = "짱 강하고"; break;
            case 9 : att = "짱짱 강하고"; break;
        }
        switch (equip_number%10) {
            case 0 : def = "부서지기 쉬운"; break;
            case 1 : def = "공격에 취약한"; break;
            case 2 : def = "방어도가 낮은"; break;
            case 3 : def = "허름한"; break;
            case 4 : def = "평범한"; break;
            case 5 : def = "평범한"; break;
            case 6 : def = "튼튼한"; break;
            case 7 : def = "강인한"; break;
            case 8 : def = "매우 튼튼한"; break;
            case 9 : def = "매우 강인한"; break;
        }

        return equip_number;
    }

    protected int getRandom(int max, int offset) {
        Random mRand = new Random();
        int nResult = mRand.nextInt(max) + offset;
        return nResult;
    }

    protected void onFight() {
        int temp2 = ATT/2+getRandom(9,1);
        if (temp2 < 0) temp2 = 0;
        HP -= temp2;
        int temp = getRandom(15,1);
        DEF -= temp;
        if (DEF <= 0) DEF = 0;
        if (HP <= 0) HP = 0;
        Toast.makeText(this,temp+"의 피해를 입혔다!\n"+temp2+"의 피해를 입었다!",Toast.LENGTH_SHORT).show();

        if (DEF <= 0) onClear();
        if (HP <= 0) onDead();
    }

    protected void onClear() {
        isClear = true;
    }

    protected void onDead() {
        isClear = true;
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

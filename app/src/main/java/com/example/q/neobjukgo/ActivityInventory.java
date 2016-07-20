package com.example.q.neobjukgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ActivityInventory extends AppCompatActivity {

    ListView invView;
    ListView fieldView;
    ArrayAdapter<StuffItem> adapterField;
    ArrayAdapter<StuffItem> adapterInv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_inventory);

        invView = (ListView) findViewById(R.id.invItems);
        fieldView = (ListView) findViewById(R.id.fieldItems);

        adapterField = new ArrayAdapter<StuffItem>(getApplicationContext(), android.R.layout.simple_list_item_1);
        adapterInv = new ArrayAdapter<StuffItem>(getApplicationContext(), android.R.layout.simple_list_item_1);

        for (Stuff i : ManagerGame.getInstance().getPlayer().getRoom().getStuffs()) {
            if (i instanceof StuffItem)
                adapterField.add((StuffItem) i);
        }

        for (Stuff i : ManagerGame.getInstance().getPlayer().getInventory()) {
            if (i instanceof StuffItem)
                adapterInv.add((StuffItem) i);
        }

        fieldView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                StuffItem item = (StuffItem)adapterView.getItemAtPosition(i);
                ManagerGame.getInstance().getPlayer().pickUpItem(item);
                adapterField.remove(item);
                adapterInv.add(item);
            }
        });
        fieldView.setAdapter(adapterField);

        invView.setAdapter(adapterInv);
        invView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                StuffItem item = (StuffItem)adapterView.getItemAtPosition(i);
                StuffItem returned = ManagerGame.getInstance().getPlayer().equipItem(item);
                if (returned != null)
                    adapterInv.add(returned);
                adapterInv.remove(item);
            }
        });
        invView.setOnItemLongClickListener(new ListView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                StuffItem item = (StuffItem)adapterView.getItemAtPosition(i);
                ManagerGame.getInstance().getPlayer().dropItem(item);
                adapterInv.remove(item);
                adapterField.add(item);
                return true;
            }
        });
    }
}

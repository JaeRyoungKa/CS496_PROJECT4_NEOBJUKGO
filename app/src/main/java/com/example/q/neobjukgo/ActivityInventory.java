package com.example.q.neobjukgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ActivityInventory extends AppCompatActivity {

    ListView invView;
    ListView fieldView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_inventory);

        invView = (ListView)findViewById(R.id.invItems);
        fieldView = (ListView)findViewById(R.id.fieldItems);

        ArrayAdapter<StuffItem> adapter1 = new ArrayAdapter<StuffItem>(getApplicationContext(), android.R.layout.simple_list_item_1);

        for (Stuff i : ManagerGame.getInstance().getPlayer().getRoom().getStuffs()) {
            if (i instanceof  StuffItem)
                adapter1.add((StuffItem)i);
        }

        fieldView.setAdapter(adapter1);
    }
}

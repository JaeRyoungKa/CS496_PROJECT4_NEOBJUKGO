package com.example.q.neobjukgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_status);
        TextView HP = (TextView) findViewById(R.id.HP);
        TextView Weapon = (TextView) findViewById(R.id.Weapon);
        TextView Armor = (TextView) findViewById(R.id.Armor);
        TextView Stat = (TextView) findViewById(R.id.stat);
        TextView Turn = (TextView) findViewById(R.id.turnnum);
        HP.setText((int) ManagerGame.getInstance().getPlayer().getHP()+" / 30");
        Weapon.setText(ManagerGame.getInstance().getPlayer().getItemWeapon().toString());
        Armor.setText(ManagerGame.getInstance().getPlayer().getItemArmor().toString());
        Stat.setText(ManagerGame.getInstance().getPlayer().getAttack()+" / "+ManagerGame.getInstance().getPlayer().getArmor());
        Turn.setText(Integer.toString(ManagerGame.getInstance().getTurn()));
    }
}

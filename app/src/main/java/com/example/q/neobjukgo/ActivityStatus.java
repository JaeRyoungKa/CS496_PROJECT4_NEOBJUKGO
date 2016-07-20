package com.example.q.neobjukgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_status);
        TextView Level = (TextView) findViewById(R.id.Level);
        TextView Exp = (TextView) findViewById(R.id.Exp);
        TextView HP = (TextView) findViewById(R.id.HP);
        TextView Weapon = (TextView) findViewById(R.id.Weapon);
        TextView Armor = (TextView) findViewById(R.id.Armor);
        TextView Stat = (TextView) findViewById(R.id.stat);
        TextView Turn = (TextView) findViewById(R.id.turnnum);
        Level.setText(Integer.toString(ManagerGame.getInstance().getPlayer().getLevel()));
        double exp = (int)(10*ManagerGame.getInstance().getPlayer().getExp())/10.0;
        double goal = (int)(10*ManagerGame.getInstance().getPlayer().getExpGoal())/10.0;
        double percent = (int)(100*exp/goal)/100.0;
        Exp.setText(Double.toString(exp) + " / " + Double.toString(goal));
        HP.setText((int) (ManagerGame.getInstance().getPlayer().getHP()*10)/10.0+" / " + ManagerGame.getInstance().getPlayer().getMaxHealth());
        if (ManagerGame.getInstance().getPlayer().getItemWeapon() != null)
            Weapon.setText(ManagerGame.getInstance().getPlayer().getItemWeapon().toString());
        else
            Weapon.setText("없음");
        if (ManagerGame.getInstance().getPlayer().getItemArmor() != null)
            Armor.setText(ManagerGame.getInstance().getPlayer().getItemArmor().toString());
        else
            Armor.setText("없음");
        Stat.setText(ManagerGame.getInstance().getPlayer().getAttack()+" / "+ManagerGame.getInstance().getPlayer().getArmor());
        Turn.setText(Integer.toString(ManagerGame.getInstance().getTurn()));
    }
}

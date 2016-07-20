package com.example.q.neobjukgo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Iterator;

/**
 * Created by q on 2016-07-20.
 */
public class MapView extends View {

    private Map map;

    public static final int LENGTH = 200;

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void onUpdate() {
        invalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint p = new Paint();
        p.setColor(Color.WHITE);
        int x = ManagerGame.getInstance().getPlayer().getRoom().getX();
        int y = ManagerGame.getInstance().getPlayer().getRoom().getY();
        super.onDraw(canvas);

        Iterator<Room> iter = map.getIterator();
        while (iter.hasNext()) {
            Room i = iter.next();
            Rect r = i.getRect();
            if (i == ManagerGame.getInstance().getPlayer().getRoom()) {
                p.setColor(Color.RED);
            } else {
                p.setColor(Color.WHITE);
            }
            int offX = -x*LENGTH+getWidth()/2-LENGTH/2;
            int offY = -y*LENGTH+getHeight()/2-LENGTH/2;
            r.offset(offX,offY);
            canvas.drawRect(r,p);

            p.setColor(Color.BLACK);
            for (int j = 0; j < i.getStuffs().size(); j++) {
                String text = i.getStuffs().get(j).toStringRender();
                p.setTextSize(30);
                canvas.drawText(text,0,text.length(),offX+i.getX()*LENGTH,offY+(j+1)*30+i.getY()*LENGTH,p);
            }
        }
    }

    public void registerMap(Map map) {
        this.map = map;
    }
}

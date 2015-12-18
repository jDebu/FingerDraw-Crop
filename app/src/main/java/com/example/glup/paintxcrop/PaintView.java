package com.example.glup.paintxcrop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Glup on 17/12/15.
 */
public class PaintView extends View implements View.OnTouchListener {
    private static final String TAG = "PaintView";

    List<Point> points = new ArrayList<Point>();
    Paint paint = new Paint();

    public PaintView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);

        this.setOnTouchListener(this);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(4);
        paint.setAntiAlias(true);
    }

    @Override
    public void onDraw(Canvas canvas) {
        for (Point point : points) {
            canvas.drawCircle(point.x, point.y, 4, paint);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        Point point = new Point();
        point.x = event.getX();
        point.y = event.getY();
        points.add(point);
        invalidate();
        Log.d(TAG, "point: " + point);
        return true;
    }
    class Point {
        float x, y;

        @Override
        public String toString() {
            return x + ", " + y;
        }
    }
}



package com.example.w13b1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    final static int LINE = 1, CIRCLE = 2, RECTANGLE = 3;
    static int curShape = LINE;
    static int curColor = Color.DKGRAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(new MyGraphicView(this));
        setContentView(new MyGraphicView(this));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        setTitle("간단 그림판");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "선 그리기");
        menu.add(0, 2, 0, "원 그리기");
        menu.add(0, 3, 0, "사각형 그리기");
        SubMenu sMenu = menu.addSubMenu("색상 변경 >>");
        sMenu.add(0, 4, 0, "빨강");
        sMenu.add(0, 5, 0, "초록");
        sMenu.add(0, 6, 0, "파랑");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case 1:
                curShape = LINE; // 선
                return true;
            case 2:
                curShape = CIRCLE; // 원
                return true;
            case 3:
                curShape = RECTANGLE; // 사각형
                return true;
            case 4:
                curColor = Color.RED;
                return true;
            case 5:
                curColor = Color.GREEN;
                return true;
            case 6:
                curColor = Color.BLUE;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private static class MyGraphicView extends View {
        int startX = -1, startY = -1, stopX = -1, stopY = -1;

        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = (int) event.getX();
                    startY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    this.invalidate();
                    break;
            }
            return true;
        }

            protected void onDraw(Canvas canvas){
                super.onDraw(canvas);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setStrokeWidth(5);
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(curColor);

//                paint.setColor(Color.RED);
                switch (curShape) {
                    case LINE:
                        canvas.drawLine(startX, startY, stopX, stopY, paint);
                        break;
                    case CIRCLE:
                        int radius = (int) Math.sqrt(Math.pow(stopX - startX, 2)
                                + Math.pow(stopY - startY, 2));
                        canvas.drawCircle(startX, startY, radius, paint);
                        break;
                    case RECTANGLE:
                        Rect rect = new Rect(startX, startY, stopX, stopY);
                        canvas.drawRect(rect, paint);
                        break;
                }
//                paint.setColor(Color.GREEN);
//                paint.setStrokeWidth(10);
//                canvas.drawLine(20, 20, 600, 40, paint);
//
//                paint.setColor(Color.BLUE);
//                paint.setStrokeWidth(10);
//                canvas.drawLine(20, 60, 600, 60, paint);
//
//                paint.setColor(Color.MAGENTA);
//                paint.setStrokeWidth(0);
//                paint.setStyle(Paint.Style.FILL);
//                Rect rect1 = new Rect(20, 100, 20 + 200, 100 + 150);
//                canvas.drawRect(rect1, paint);
//
//                paint.setStyle(Paint.Style.STROKE);
//                paint.setStrokeWidth(5);
//                Rect rect2 = new Rect(260, 100, 260 + 200, 100 + 200);
//                canvas.drawRect(rect2, paint);
//
//                RectF rect3 = new RectF(500, 100, 500 + 200, 100 + 200);
//                canvas.drawRoundRect(rect3, 40, 40, paint);
//
//                canvas.drawCircle(120, 440, 100, paint);
//
//                paint.setStrokeWidth(10);
//                Path path1 = new Path();
//                path1.moveTo(20, 580);
//                path1.lineTo(20 + 100, 580 + 100);
//                path1.lineTo(20 + 200, 580);
//                path1.lineTo(20 + 300, 580 + 100);
//                path1.lineTo(20 + 400, 580);
//                canvas.drawPath(path1, paint);
//
//
//                canvas.drawCircle(150, 1000, 100, paint);
//                path1.moveTo(350, 900);
//                path1.lineTo(350, 900 + 200);
//                path1.moveTo(350, 1200);
//                path1.lineTo(350, 1200 + 150);
//                path1.moveTo(150, 1200);
//                path1.lineTo(150, 1200 + 150);
//                path1.moveTo(150, 1350);
//                path1.lineTo(150 + 200, 1200 + 150);
//                path1.moveTo(150, 1200);
//                path1.lineTo(150 + 200, 1200);
//                canvas.drawPath(path1, paint);
//
//
//                paint.setStrokeWidth(5);
//                paint.setTextSize(120);
//
//                canvas.drawText("안드로이드", 20, 780, paint);


            }
        }
    }


package com.cookandroid.w07t;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout;
    Button button1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        //setTitle("배경색 바꾸기");

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);

        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //return super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.itemRed){
            baseLayout.setBackgroundColor(Color.RED);
            return true;
        }else if (item.getItemId() ==R.id.itemGreen){
            baseLayout.setBackgroundColor(Color.GREEN);
            return true;
        }else if (item.getItemId() ==R.id.itemBlue){
            baseLayout.setBackgroundColor(Color.BLUE);
            return true;
        }else if (item.getItemId()==R.id.subRotate){
            button1.setRotation(45);
            return true;
        }else if (item.getItemId()==R.id.subSize){
            button1.setScaleX(2);
            return true;
        }
        return false;
    }
}
/*
            switch (item.getItemId()) {
                case R.id.itemRed:
                    baseLayout.setBackgroundColor(Color.RED);
                    return true;
                case R.id.itemGreen:
                    baseLayout.setBackgroundColor(Color.GREEN);
                    return true;
                case R.id.itemBlue:
                    baseLayout.setBackgroundColor(Color.BLUE);
                    return true;
                case R.id.subRotate:
                    button1.setRotation(45);
                    return true;
                case R.id.subSize:
                    button1.setScaleX(2);
                    return true;
            }
            */

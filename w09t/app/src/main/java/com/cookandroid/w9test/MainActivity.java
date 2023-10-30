package com.cookandroid.w9test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;
public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout;
    Button button1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 1) {
            baseLayout.setBackgroundColor(Color.RED);
        } else if (item.getItemId() == 2) {
            baseLayout.setBackgroundColor(Color.GREEN);
        } else if (item.getItemId() == 3) {
            baseLayout.setBackgroundColor(Color.BLUE);
        } else if (item.getItemId() == 4) {
            button1.setRotation(45);
        } else if (item.getItemId() == 5) {
            button1.setScaleX(2);
        } else {
            return false;
        }
        return true;

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "배경색 (빨강)C");
        menu.add(0, 2, 0, "배경색 (초록)C");
        menu.add(0, 3, 0, "배경색 (파랑)C");
        SubMenu sMenu = menu.addSubMenu("버튼 변경 >>C");
        sMenu.add(0, 4, 0, "버튼 45도 회전C");
        sMenu.add(0, 5, 0, "버튼 2배 확대C");
        return true;
    }


}
package com.example.w12a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnFileList;
        final EditText edtFileList;
        btnFileList = (Button) findViewById(R.id.btnFileList);
        edtFileList = (EditText) findViewById(R.id.edtFileList);
        btnFileList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String sysDir = Environment.getRootDirectory().getAbsolutePath(); // /system/

                //String sysDir = Environment.getExternalStorageDirectory().getAbsolutePath(); // /storage/
                File[] sysFiles = (new File(sysDir).listFiles());
                String strFname;
                for (int i = 0; i < sysFiles.length; i++) {
                    if (sysFiles[i].isDirectory() == true)
                        strFname = "<폴더> " + sysFiles[i].toString();
                    else
                        strFname = "<파일> " + sysFiles[i].toString();
                    edtFileList.setText(edtFileList.getText() + "\n" + strFname);
            }
            }
        });
    }
}
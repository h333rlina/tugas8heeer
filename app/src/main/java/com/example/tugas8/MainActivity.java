package com.example.tugas8;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {
    private static final int Calender_PERMISSION_CODE = 112;
    private static final int STORAGE_PERMISSION_CODE = 113;
    Button btnGaleri,btnStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btnGaleri=findViewById(R.id.btnCalender);
        btnStorage=findViewById(R.id.btmStorage);

        btnGaleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission(Manifest.permission.READ_CALENDAR,Calender_PERMISSION_CODE);
            }
        });

        btnStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE,STORAGE_PERMISSION_CODE);

            }
        });

    }
    public void checkPermission(String permission, int requestCode){

        if (ContextCompat.checkSelfPermission(MainActivity.this,permission)== PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{permission}, requestCode);
        }else {
            Toast.makeText(MainActivity.this, "permission already granted", Toast.LENGTH_SHORT).show();
        }
    }
    @Override

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permission, @NonNull int[] grantResult){
        super.onRequestPermissionsResult(requestCode, permission, grantResult);

        if(requestCode==Calender_PERMISSION_CODE){
            if (grantResult.length>0 && grantResult[0]==PackageManager.PERMISSION_GRANTED){
                btnGaleri.setText("Permission Granted");
                Toast.makeText(MainActivity.this, "Calender Permission Granted", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this, "Calender Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }else if (requestCode==STORAGE_PERMISSION_CODE){
            if (grantResult.length>0 && grantResult[0]==PackageManager.PERMISSION_GRANTED){
                btnStorage.setText("Permission Granted");
                Toast.makeText(MainActivity.this, "Calender Permission Granted", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this, "Calender Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
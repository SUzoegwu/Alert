package com.example.somtouzoegwu.migraalert;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;

/**
 * Created by Somto Uzoegwu on 11/10/2017.
 */

public class thisApp extends AppCompatActivity{
    int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
    }

    public void btn_SendSMS_OnClick(View v){
        String message = "Hey! This test button works";
        String telNumber = "909-929-4214";

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String []{Manifest.permission.SEND_SMS},
                    MY_PERMISSIONS_REQUEST_SEND_SMS);
        }
        else{
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(telNumber, null, message, null, null);
        }

    }
}

package com.example.androidtaskday10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sms extends AppCompatActivity {

    EditText etMobile,etSms;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        etMobile=findViewById(R.id.etMobile);
        etSms=findViewById(R.id.etMsg);
        button=findViewById(R.id.btnSend);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no=etMobile.getText().toString();
                String msg=etSms.getText().toString();
                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(no,null,msg,null,null);
                Toast.makeText(getApplicationContext(), "Message Sent Successfully!!", Toast.LENGTH_LONG).show();

            }
        });
    }
}
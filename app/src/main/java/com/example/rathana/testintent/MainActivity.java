package com.example.rathana.testintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnDail,btnSendMail,btnOwnIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDail=findViewById(R.id.btnDailNumber);
        btnSendMail=findViewById(R.id.btnSendMail);
        btnOwnIntent=findViewById(R.id.btnOwnIntent);

        btnDail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:012294335"));
                startActivity(intent);
            }
        });
        btnSendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent=new Intent(Intent.ACTION_SEND);
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"Dear Customer! I really say thank to you that you always support");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Dear Customer");
                intent.putExtra(Intent.EXTRA_CC,"rathanavoy07@gmail.com");
                startActivity(intent);
            }
        });
        btnOwnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW);
                intent.putExtra("name","Odom");
                intent.putExtra("gender","male");
                intent.putExtra("phone","012334455");
                startActivity(intent);
            }
        });


    }
}

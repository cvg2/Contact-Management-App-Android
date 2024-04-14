package com.example.project6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactDetail extends AppCompatActivity {
    private TextView showname;
    private TextView showphone;
    private TextView showemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        showname = findViewById(R.id.showname);
        showphone = findViewById(R.id.showphone);
        showemail = findViewById(R.id.showemail);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String email = intent.getStringExtra("email");

        showname.setText(name);
        showphone.setText(phone);
        showemail.setText(email);

        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            finish();
          }
        });
    }
}

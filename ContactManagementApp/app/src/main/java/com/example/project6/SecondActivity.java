package com.example.project6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        EditText textname = (EditText) findViewById(R.id.varname2);
        textname.requestFocus();
    }

    public void goMainAct(View view1) {
      EditText textname = (EditText) findViewById(R.id.varname2);
      EditText textphone = (EditText) findViewById(R.id.varphone2);
      EditText textemail = (EditText) findViewById(R.id.varemail2);



      Intent intent = new Intent();
      String name = textname.getText().toString();
      String phone = textphone.getText().toString();
      String email = textemail.getText().toString();

      intent.putExtra("name", name);
      intent.putExtra("phone", phone);
      intent.putExtra("email", email);
      setResult(RESULT_OK, intent);
      finish();
    }
}

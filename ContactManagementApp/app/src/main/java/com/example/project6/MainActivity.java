package com.example.project6;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Contact> contactos;
    private ContactListAdapter adapter;

    private DBAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      db = new DBAdapter(this);

      contactos =  new ArrayList<>();
      adapter = new ContactListAdapter(this, contactos);

      ListView listViewContacts = findViewById(R.id.listViewContacts);
      listViewContacts.setAdapter(adapter);
      listViewContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          Contact contact = (Contact) parent.getItemAtPosition(position);
          Intent intent = new Intent(MainActivity.this, ContactDetail.class);
          intent.putExtra("name", contact.getName());
          intent.putExtra("phone", contact.getPhone());
          intent.putExtra("email", contact.getEmail());
          startActivity(intent);
        }
      });

      db.open();
      Cursor c = db.getAllContacts();
      if (c.moveToFirst())
      {
        do {
          String name = c.getString(1);
          String email = c.getString(2);
          String phone = c.getString(3);
          contactos.add(new Contact(name,phone,email));
        } while (c.moveToNext());
      }
      db.close();
    }

    ActivityResultLauncher<Intent> callSecondAct= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
      new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
          if (result.getResultCode() == RESULT_OK) {
            Intent data = result.getData();
            String name = data.getStringExtra("name").toString();
            String email = data.getStringExtra("email").toString();
            String phone =data.getStringExtra("phone").toString();

            contactos.add(new Contact(name,phone,email));
            db.open();
            db.insertContact(name,email,phone);
            db.close();
            adapter.notifyDataSetChanged();
          }
        }
      });


    public void startSecondAct(View view) {
      Intent intent = new Intent(this, SecondActivity.class);
      callSecondAct.launch(intent);
    }
  }


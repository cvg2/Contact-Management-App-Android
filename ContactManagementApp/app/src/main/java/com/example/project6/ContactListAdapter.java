package com.example.project6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactListAdapter extends ArrayAdapter<Contact> {

  public ContactListAdapter(Context context, List<Contact> contacts) {
    super(context, 0, contacts);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    Contact contact = getItem(position);

    if (convertView == null) {
      convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_contact, parent, false);
    }

    TextView textViewName = convertView.findViewById(R.id.contact_name);

    textViewName.setText(contact.getName());

    return convertView;
  }
}

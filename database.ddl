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
# We also need to add this line to add the contact in the databae once we added it our second activity: db.open();
            db.insertContact(name,email,phone);
            db.close();

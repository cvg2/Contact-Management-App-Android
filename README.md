# Contact-Management-App-Android
Develop a contact management app that allows users to create and store contacts in a database in Android Studio


The aim of this project is to develop a contact management app that allows users to create and store contacts in a database. In summary, the app allows users to manage contacts by creating, editing, and viewing their details. It has a main activity that displays a list of contacts, a contact detail activity that shows the details of a selected contact, and a contact edit activity that allows users to add new contacts or edit existing ones. The app uses an adapter to display the contacts in the main activity and updates the list with any changes made in the contact edit activity. Overall, the app provides a simple and efficient way for users to manage their contacts on a mobile device. 
Now we need to implement the database adapter class from the lecture in our app. For that we just need to add it as a java class and initialize the database on our create. One of the more important things of this task, is making sure that once we have some contacts in our app and we close the app, if we open it again we should still have all our contacts because of our database. We do that using this lines, we go through the contacts using a cursor that will get every contact and display in our listview.



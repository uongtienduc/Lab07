package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    private EditText personNameEdit;
    private Button addNameBtn;
    private DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);

//        // Inserting Contacts
//        Log.d("Insert: ", "Inserting ..");
//        db.addContact(new Contact("Ravi", "9100000000"));
//        db.addContact(new Contact("Srinivas", "9199999999"));
//        db.addContact(new Contact("Tommy", "9522222222"));
//        db.addContact(new Contact("Karthik", "9533333333"));
//
//        // Reading all contacts
//        Log.d("Reading: ", "Reading all contacts..");
//        List<Contact> contacts = db.getAllContacts();
//
//        for (Contact cn : contacts) {
//            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
//                    cn.getPhoneNumber();
//            // Writing Contacts to log
//            Log.d("Name: ", log);
//        }
        personNameEdit = findViewById(R.id.PersonName);
        addNameBtn = findViewById(R.id.button);

        dbHandler = new DatabaseHandler(MainActivity.this);

        addNameBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String Name = personNameEdit.getText().toString();

                if (Name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHandler.addName(Name);

                Toast.makeText(MainActivity.this, "Name has been added", Toast.LENGTH_SHORT).show();
                personNameEdit.setText("");

                // Reading all contacts
                Log.d("Reading: ", "Reading all contacts..");
                List<Contact> contacts = db.getAllContacts();

                for (Contact cn : contacts) {
                    String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                            cn.getPhoneNumber();
                    // Writing Contacts to log
                    Log.d("Name: ", log);
                }

            }
        });


    }
}




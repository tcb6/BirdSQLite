package com.example.thomasberkey.birdsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper db = new DbHelper(this);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addBird(new Bird(0, "Robin", "Red Bird"));
        db.addBird(new Bird(1, "Blue Jay", "Blue Bird"));
        db.addBird(new Bird(2, "Flamingo", "Pink Bird"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all birds..");
        List<Bird> birds = db.getAllBirds();

        for (Bird bird : birds) {
            String log = "Id: "+bird.getId()+" ,Name: " + bird.getName() + " ,Description: " + bird.getDescription();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }
}

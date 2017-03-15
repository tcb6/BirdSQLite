package com.example.thomasberkey.birdsqlite;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText descript;
    Button button;
    DbHelper db = new DbHelper(this);
    private List<Bird> birdList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BirdsAdapter bAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // LinearLayout linearLayout = new LinearLayout(this);
        // linearLayout.setOrientation(LinearLayout.VERTICAL);


        // Enter row
        name = (EditText)findViewById(R.id.tableName);
        descript = (EditText)findViewById(R.id.tabledDescription);
        button = (Button)findViewById(R.id.insertButton);


        bAdapter = new BirdsAdapter(birdList);
        RecyclerView.LayoutManager bLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(bLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(bAdapter);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");

        // Reading all contacts
        Log.d("Reading: ", "Reading all birds..");
        List<Bird> birds = db.getAllBirds();
        // Button[] birdButton = new Button[birds.size()];
        // int i = 0;

        for (Bird bird : birds) {
            String log = "Id: "+bird.getId()+" ,Name: " + bird.getName() + " ,Description: " + bird.getDescription();

            birdList.add(bird);

            // birdButton[i] = new Button(this); //initialize the button here
            // birdButton[i].setText(bird.getName());

            // linearLayout.addView(birdButton[i++]);

            Log.d("Name: ", log);
        }

        bAdapter.notifyDataSetChanged();

        // ScrollView scroll = (ScrollView) findViewById(R.id.buttonList);

        // scroll.addView(linearLayout);
    }

    public void insertRow(View v){
        db.addBird(new Bird(name.getText().toString(), descript.getText().toString()));

        birdList.clear();

        List<Bird> birds = db.getAllBirds();

        for (Bird bird : birds) {
            String log = "Id: "+bird.getId()+" ,Name: " + bird.getName() + " ,Description: " + bird.getDescription();
            // Writing Contacts to log

            birdList.add(bird);

            Log.d("Name: ", log);


        }
        bAdapter.notifyDataSetChanged();
    }
}

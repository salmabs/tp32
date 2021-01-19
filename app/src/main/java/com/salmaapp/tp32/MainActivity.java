package com.salmaapp.tp32;


import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG=MainActivity.class.getSimpleName();
    private LinkedList<String> recipes_list = new LinkedList<>();
    private LinkedList<String> description = new LinkedList<>();
    String  s1[] ,s2[] ;

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        reponse();


        // Put initial data into the word list.
        s1=getResources().getStringArray(R.array.recipes);
        s2=getResources().getStringArray(R.array.short_description);
        Collections.addAll(recipes_list,s1) ;
        Collections.addAll(description,s2);
        // Create recycler view.
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new WordListAdapter(this, recipes_list,description);
        // Connect the adapter with the recycler view.
        mRecyclerView.setAdapter(mAdapter);
        // Give the recycler view a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // This comment suppresses the Android Studio warning about simplifying
        // the return statements.
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void reponse(){
        Log.d(TAG,"Quest 1 : You don't need a layout manager with a RecyclerView to handle " +
                "the hierarchy and layout of View elements.") ;


        Log.d(TAG,"Quest 2 : RecyclerView.Adapter") ;


        Log.d(TAG,"Quest 3: RecyclerView.ViewHolder") ;

    }
}
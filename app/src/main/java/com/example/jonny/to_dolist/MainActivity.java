package com.example.jonny.to_dolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.*;
//import stanford.androidlib.SimpleActivity;


public class MainActivity extends AppCompatActivity {
    private ArrayList<String> myArray;
    private ArrayAdapter<String> myAdapter;
    private EditText editText;
    //private Button myButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myArray = new ArrayList<String>() ; // load data from file
        myAdapter = new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        myArray);

        ListView list = (ListView) findViewById(R.id.myList);
        list.setAdapter(myAdapter);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                myArray.remove(position);
                myAdapter.notifyDataSetChanged();
                return false;
            }
        });


    }


    public void add_click(View view){
        editText = (EditText)findViewById(R.id.editText);
        //myButton = (Button)findViewById(R.id.myButton);
        myArray.add(editText.getText().toString());
        myAdapter.notifyDataSetChanged();
    }


}

package com.example.trip_planner;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.*;
class trips
{
    String name;
    String budject;
    trips(String n,String b)
    {
        name=n;
        budject=b;
    }
    String getname()
    {
        return "Destination: "+budject+"\n Budject:Rs. "+name;
    }
    public   String toString()
    {
       return this.getname();
    }
}
public class MainActivity extends AppCompatActivity {
    ArrayList<trips> list = new ArrayList<trips>();
    ArrayAdapter<trips> adapter;
    ListView listView;
     String b1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar t=findViewById(R.id.tools);
        setSupportActionBar(t);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText e1 =  findViewById(R.id.editText);
               EditText e2 = findViewById(R.id.editText2);
                final String n=e1.getText().toString();
                 b1=(e2.getText().toString());
                trips t=new trips(n,b1);

                list.add(t);

                e1.setText("");
                e2.setText("");
                adapter.notifyDataSetChanged();

                listView.setAdapter(adapter);

            }
        });

         listView=findViewById(R.id.listview);
        adapter = new ArrayAdapter<trips>(this, android.R.layout.simple_list_item_1, list);
        addItems(listView);

    }


    public void addItems(View view) {

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int is, long l) {

        if(is==0) {
            Intent intent = new Intent(view.getContext(), SubActivity.class);
            intent.putExtra("destination",b1);
            startActivity(intent);
        }
    }
});

    }






}

package com.example.trip_planner;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.*;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

class subPlaces
{
    String name;
    String desc;
    subPlaces(String n,String d)
    {
        name=n;
        desc=d;
    }

    String getName()
    {
        return name+"\n"+desc;
    }

    public String toString()
    {
        return this.getName();

}
}

public class SubActivity extends AppCompatActivity {

    ArrayList<subPlaces> list = new ArrayList<subPlaces>();
    ArrayAdapter<subPlaces> adapter;
    ListView list_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String des="Bangalore";
        Toolbar t=findViewById(R.id.tool1);
        setSupportActionBar(t);
        SQLiteDatabase mydatabase = openOrCreateDatabase("trips_planner",MODE_PRIVATE,null);
        //mydatabase.execSQL("CREATE TABLE IF NOT EXISTS trips1(destination VARCHAR,subPlace VARCHAR,description VARCHAR);");
        //mydatabase.execSQL("INSERT INTO trips1 VALUES('Bangalore','Lalbag','this is a botanical garden');");
        //mydatabase.execSQL("INSERT INTO trips1 VALUES('Bangalore','Vidhana Soudha','this is our adminstration block');");
        mydatabase.execSQL("INSERT INTO trips1 VALUES('Hyderabad','Wonder la','this is a world famous fantasy park');");
//mydatabase.execSQL("DELETE FROM trips1;");
String desti=getIntent().getStringExtra("destination");
Cursor resultSet = mydatabase.rawQuery("SELECT * FROM trips1 where destination=?",new String[]{des});
resultSet.moveToFirst();
            String name = resultSet.getString(1);
            String destination = resultSet.getString(2);
            subPlaces s1 = new subPlaces(name, destination);
            list.add(s1);
            setContentView(R.layout.activity_sub);
            list_View = findViewById(R.id.list_view);
            adapter = new ArrayAdapter<subPlaces>(this, android.R.layout.simple_list_item_1, list);

            while (resultSet.moveToNext()) {
                String name1 = resultSet.getString(1);
                String destination1 = resultSet.getString(2);
                subPlaces s = new subPlaces(name1, destination1);
                list.add(s);
            }
        list_View.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
}

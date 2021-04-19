package com.example.homerentalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;



import java.util.ArrayList;

public class ViewRenter extends AppCompatActivity {

    private ListView listView;
    private Adapter adapter;
    private ArrayList<Renter> renters;
    private DatabaseSource databaseSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_renter);

        listView=(ListView)findViewById(R.id.listview);
        databaseSource=new DatabaseSource(this);

        renters=databaseSource.getAllRenter();

        adapter=new Adapter(this,renters);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String rentername=renters.get(position).getRentername();
                String flatname=renters.get(position).getFlatname();
                String contactnumber=renters.get(position).getContactnumber();
                int rowid=renters.get(position).getRenterid();
                startActivity(new Intent(ViewRenter.this,ViewDetails.class).putExtra("id",rowid)
                        .putExtra("rentername",rentername).
                                putExtra("flatname",flatname).
                                putExtra("contactnumber",contactnumber));
            }
        });
    }
}
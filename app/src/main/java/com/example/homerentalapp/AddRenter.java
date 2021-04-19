package com.example.homerentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddRenter extends AppCompatActivity {
    TextView textView1,textView2,textView3;
    private ArrayList<Renter> persons;
    private Renter renter;
    private Adapter Adapter;
    private DatabaseSource DatabaseSource;
    private String renterName,flatName,contactNumber;
    private int rowid;
    private Button addbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_renter);

        textView1=(TextView)findViewById(R.id.renterName);
        textView2=(TextView)findViewById(R.id.flatName);
        textView3=(TextView)findViewById(R.id.contactNumber);
        addbtn=(Button)findViewById(R.id.btnsubmit);
        DatabaseSource=new DatabaseSource(this);

        renterName=getIntent().getStringExtra("renterName");
        flatName=getIntent().getStringExtra("flatName");
        contactNumber=getIntent().getStringExtra("contactNumber");
        rowid=getIntent().getIntExtra("id",0);

        textView1.setText(renterName);
        textView2.setText(flatName);
        textView3.setText(contactNumber);
        if (rowid>0){
            addbtn.setText("update");

        }
    }
    public void addRenter(View view) {

        String renterName=textView1.getText().toString();
        String flatName=textView2.getText().toString();
        String contactNumber=textView3.getText().toString();
        if (renterName.isEmpty()){
            textView1.setError("This field must not be empty");}
        else if (flatName.isEmpty()){
            textView2.setError("This field must not be empty");}
        else if (contactNumber.isEmpty()){
            textView3.setError("This field must not be empty");}
        else{
            if (rowid > 0) {
                renter=new Renter(renterName,flatName,contactNumber,rowid);
                boolean status=DatabaseSource.updateRenter(renter,rowid);
                if (status){
                    Toast.makeText(this,"Updated",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddRenter.this,ViewRenter.class));
                }else {
                    Toast.makeText(this," failed to Updated",Toast.LENGTH_SHORT).show();
                }

            }else {

                renter=new Renter(renterName,flatName,contactNumber,rowid);
                boolean status=DatabaseSource.addRenter(renter);
                if (status){
                    Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddRenter.this,ViewRenter.class));
                }else{
                    Toast.makeText(this,"could not save",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }






}
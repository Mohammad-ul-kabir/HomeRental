package com.example.homerentalapp;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Renter> {
    private Context context;
    private ArrayList<Renter> renters;

    public Adapter(@NonNull Context context, ArrayList<Renter>renters) {
        super(context, R.layout.row_item,renters);

        this.context=context;
        this.renters=renters;
    }
    class Viewholder{
        TextView rentername;
        TextView flatname;
        TextView contactnumber;
        ImageView MyImage;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        Viewholder holder;
        if (convertView==null){
            holder=new Viewholder();
            convertView=inflater.inflate(R.layout.row_item,parent,false);
            holder.rentername=(TextView)convertView.findViewById(R.id.renterName);
            holder.flatname=(TextView)convertView.findViewById(R.id.flatName);
            holder.contactnumber=(TextView)convertView.findViewById(R.id.contactNumber);
            holder.MyImage=(ImageView)convertView.findViewById(R.id.myimage);
            convertView.setTag(holder);

        }else {
            holder=(Viewholder)convertView.getTag();
        }
        holder.rentername.setText(renters.get(position).getRentername());
        holder.flatname.setText(renters.get(position).getFlatname());
        holder.contactnumber.setText(renters.get(position).getContactnumber());
        return convertView;




    }
}

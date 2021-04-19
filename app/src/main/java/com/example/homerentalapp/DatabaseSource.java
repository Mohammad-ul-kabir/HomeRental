package com.example.homerentalapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Array;
import java.util.ArrayList;

public class DatabaseSource {
    private DataHelper dataHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Renter renter;

    public DatabaseSource(Context context) {
        dataHelper=new DataHelper(context);
    }

    public void open(){
        sqLiteDatabase=dataHelper.getWritableDatabase();

    }
    public void close(){

        sqLiteDatabase.close();
    }
    public boolean addRenter(Renter renter){
        this.open();
        ContentValues values= new ContentValues();
        values.put(DataHelper.COL_NAME,renter.getRentername());
        values.put(DataHelper.COL_FLATNAME,renter.getFlatname());
        values.put(DataHelper.COL_number,renter.getContactnumber());
        long id=sqLiteDatabase.insert(DataHelper.TABLE_RENTER,null,values);
        this.close();
        if (id>0){
            return true;

        }else {
            return false;
        }
    }
    public ArrayList<Renter> getAllRenter(){
        ArrayList<Renter>renters=new ArrayList<>();
        this.open();
        Cursor cursor=sqLiteDatabase.query(DataHelper.TABLE_RENTER,null,null,null,null,
                null,null);
        cursor.moveToFirst();
        if (cursor !=null && cursor.getCount()>0 ){
            for (int i=0;i<cursor.getCount();i++){
                int id=cursor.getInt(cursor.getColumnIndex(DataHelper.COL_ID));
                String rentername=cursor.getString(cursor.getColumnIndex(DataHelper.COL_NAME));
                String flatname=cursor.getString(cursor.getColumnIndex(DataHelper.COL_FLATNAME));
                String contactnumber=cursor.getString(cursor.getColumnIndex(DataHelper.COL_number));
                renter=new Renter(rentername,flatname,contactnumber,id);
                renters.add(renter);
                cursor.moveToNext();
            }
        }
        cursor.close();
        this.close();
        return renters;

    }
    public boolean updateRenter(Renter renter,int rowid){
        this.open();
        ContentValues values= new ContentValues();
        values.put(DataHelper.COL_ID,renter.getRenterid());
        values.put(DataHelper.COL_NAME,renter.getRentername());
        values.put(DataHelper.COL_FLATNAME,renter.getFlatname());
        values.put(DataHelper.COL_number,renter.getContactnumber());
        int updatedId= sqLiteDatabase.update(DataHelper.TABLE_RENTER,values,DataHelper.COL_ID+"=?",
                new String[]{Integer.toString(rowid)});
        if (updatedId>0){
            return true;
        }else {
            return false;
        }



    }

    public boolean deleteRenter(int rowid){
        this.open();
        int deletedId=sqLiteDatabase.delete(DataHelper.TABLE_RENTER,DataHelper.COL_ID+"=?",new String[]{Integer.toString(rowid)});
        this.close();
        if (deletedId>0){
            return true;
        }else {
            return false;
        }
    }
}

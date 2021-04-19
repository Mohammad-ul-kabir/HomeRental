package com.example.homerentalapp;


import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import org.w3c.dom.Text;
import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {
    
    public static final String DATABASE_NAME="Renter_database";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE_RENTER= "tbl_renter";
    public static final String COL_ID="tbl_id";
    public static final String COL_NAME="tbl_renterName";
    public static final String COL_FLATNAME="tbl_flatName";
    public static final String COL_number="tbl_contactNumber";
    private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_RENTER;
    public static final String CREATE_RENTER_TABLE="CREATE TABLE "+TABLE_RENTER+ "("+
            COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            COL_NAME+" TEXT,"+
            COL_FLATNAME+" TEXT,"+
            COL_number+" Text);";


    public DataHelper(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_RENTER_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS"+TABLE_RENTER);
//        onCreate(db);

        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
}

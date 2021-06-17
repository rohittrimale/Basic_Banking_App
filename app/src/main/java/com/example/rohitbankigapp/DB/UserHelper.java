package com.example.rohitbankigapp.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.rohitbankigapp.DB.UserContract.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table

        //name of account and there mobile and how much money in account that show
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Tejas Dumane', 'tejas@gmail.com','7584','91874568x', 150000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Aniket Dakhore', 'aniket@gmail.com','1258','91874568x', 50000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Rohan Kadatn', 'Rohan@gmail.com','8896','91454568x', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Saurab Joshi', 'saurab@gmail.com','7752','91835568x', 80000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Shivani Joshi', 'shivani@gmail.com','3669','91895568x', 75000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Pritesh Kulkarni', 'pritesh@gmail.com','9985','91574568x', 65000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Yash Raj', 'yash@gmail.com','1207','918574568x', 45000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Khushi Sharma', 'khushi@gmail.com','4522','91374568x', 25000)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Ritik Yadav', 'ritik@gmail.com','6582','917874568x', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Rohit Gujrati', 'rohit@gmail.com','5450','9145874568x', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Mohit Sharma', 'mohit@gmail.com','2656','918456568x', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Somveer Kumar', 'somveer@gmail.com','1203','918254568x', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Naveen Reday', 'naveen@gmail.com','5566','91654568x', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Akash Jaiswal', 'akash@gmail.com','2236','91784568x', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Omkar Kattekar', 'omkar@gmail.com','6692','91154568x', 10010)");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}
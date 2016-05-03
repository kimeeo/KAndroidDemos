package com.kimeeo.kAndroidDemos.services.sqlLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kimeeo.kAndroidDemos.services.DataBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by BhavinPadhiyar on 03/05/16.
 */
public class MySQLiteDataHelper extends SQLiteOpenHelper
{
        private static final int DATABASE_VERSION = 3;
        private static final String DATABASE_NAME = "sampleManager";
        private static final String TABLE_SAMPLE = "sample";

        private static final String KEY_ID = "id";
        private static final String KEY_NAME = "name";
        private static final String KEY_DETAILS = "details";

        public MySQLiteDataHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_SAMPLE + "("
                    + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                    + KEY_DETAILS + " TEXT" + ")";
            db.execSQL(CREATE_CONTACTS_TABLE);
        }

        private DataBean getSample(String name, String phone) {
            DataBean o = new DataBean();
            o.setName(name);
            o.setDetails(phone);
            return o;
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SAMPLE);
            onCreate(db);
        }

        void addEntry(DataBean data) {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(KEY_NAME, data.getName()); // Contact Name
            values.put(KEY_DETAILS, data.getDetails()); // Contact Phone

            // Inserting Row
            db.insert(TABLE_SAMPLE, null, values);
            db.close(); // Closing database connection
        }
        boolean isAdded=false;
        public void addSample()
        {
            if(isAdded==false) {
                addEntry(getSample("B1", "534534"));
                addEntry(getSample("B2", "534534"));
                addEntry(getSample("B3", "534534"));
                addEntry(getSample("B4", "534534"));
                addEntry(getSample("B5", "534534"));
                addEntry(getSample("B6", "534534"));
                addEntry(getSample("B7", "534534"));
                addEntry(getSample("B8", "534534"));
                addEntry(getSample("B9", "534534"));
                addEntry(getSample("B10", "534534"));
                isAdded=true;
            }
        }
        public List getList()
        {
            List<DataBean> contactList = new ArrayList<>();
            String selectQuery = "SELECT  * FROM " + TABLE_SAMPLE;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    DataBean contact = new DataBean();
                    contact.setImage(Integer.parseInt(cursor.getString(0))+"");
                    contact.setName(cursor.getString(1));;
                    contact.setDetails(cursor.getString(2));
                    contactList.add(contact);
                } while (cursor.moveToNext());
            }
            return contactList;
        };



}

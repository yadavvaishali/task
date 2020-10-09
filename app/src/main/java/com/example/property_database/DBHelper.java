package com.example.property_database;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBNamenew1.db";
    public static final String CONTACTS_TABLE_NAME = "mycontacts1";
    public static final String Property_ID = "id";
    public static final String CONTACTS_sdp = "sdp";
    public static final String CONTACTS_name = "name";
    public static final String CONTACTS_property_type = "property_type";
    public static final String CONTACTS_location = "location";
    public static final String CONTACTS_dimension = "dimension";
    public static final String sq_yrd = "sqyrd";
    public static final String onsite = "onsite";
    public static final String carpet = "carpet";
    public static final String superarea = "superarea";
    public static final String costpersqr = "costpersqr";
    public static final String clientds = "clientds";
    public static final String Clientdf = "clientdf";
    public static final String other = "other";

    private static final String CREATE_TABLE = "create table " + CONTACTS_TABLE_NAME + "(" + Property_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CONTACTS_name + " TEXT NOT NULL, " + CONTACTS_location + " TEXT ," +
              CONTACTS_sdp + " TEXT," + CONTACTS_property_type + " TEXT," + CONTACTS_dimension + " TEXT,"
            + sq_yrd + " TEXT," + onsite + " TEXT," + carpet + " TEXT," + superarea + " TEXT," + costpersqr + " TEXT," +
            clientds + " TEXT," + Clientdf + " TEXT," + other + " TEXT);";

    public DBHelper(@Nullable Context context) {
        super(context,  DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(sqLiteDatabase);
    }

    public boolean insertContact(Property property){

                SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name",property.getName());
        contentValues.put("location",property.getLocation());
        contentValues.put("sdp",property.getSpd());
        contentValues.put("property_type",property.getProperty_type());
        contentValues.put("dimension",property.getDimension());
        contentValues.put("sqyrd",property.getSqrd());
        contentValues.put("onsite",property.getOnsites());
        contentValues.put("carpet",property.getCarpets());
        contentValues.put("superarea",property.getSuperareas());
        contentValues.put("costpersqr",property.getCost());
        contentValues.put("clientds",property.getStart());
        contentValues.put("clientdf",property.getFinalcost());
        contentValues.put("other",property.getOther());


        db.insert("mycontacts1", null, contentValues);
        return true;

    }

    public List<Property> getAllCotacts() {
        List<Property> get_propertylist=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select * from mycontacts1", null );
        cursor.moveToFirst();


        while(cursor.isAfterLast() == false){
            Property property=new Property();
            property.setName(cursor.getString(cursor.getColumnIndex(CONTACTS_name)));
            property.setLocation(cursor.getString(cursor.getColumnIndex(CONTACTS_location)));
            property.setId(cursor.getString(cursor.getColumnIndex(Property_ID)));
            property.setProperty_type(cursor.getString(cursor.getColumnIndex(CONTACTS_property_type)));
            property.setSpd(cursor.getString(cursor.getColumnIndex(CONTACTS_sdp)));
            property.setDimension(cursor.getString(cursor.getColumnIndex(CONTACTS_dimension)));
            property.setOnsites(cursor.getString(cursor.getColumnIndex(onsite)));
            property.setCarpets(cursor.getString(cursor.getColumnIndex(carpet )));
            property.setSuperareas(cursor.getString(cursor.getColumnIndex(superarea)));
            property.setCost(cursor.getString(cursor.getColumnIndex(costpersqr)));
            property.setStart(cursor.getString(cursor.getColumnIndex(clientds )));
            property.setFinalcost(cursor.getString(cursor.getColumnIndex(Clientdf)));
            property.setOther(cursor.getString(cursor.getColumnIndex(other)));
            property.setSqrd(cursor.getString(cursor.getColumnIndex(sq_yrd)));


            get_propertylist.add(property);

            cursor.moveToNext();

        }
        return get_propertylist;

    }

    public List<Property> detailContact(String value) {
        List<Property> get_propertylist=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select * from mycontacts1" + " WHERE "+ "id" + " = " + value, null );
        cursor.moveToFirst();


        while(cursor.isAfterLast() == false){
            Property property=new Property();
            property.setName(cursor.getString(cursor.getColumnIndex(CONTACTS_name)));
            property.setLocation(cursor.getString(cursor.getColumnIndex(CONTACTS_location)));
            property.setId(cursor.getString(cursor.getColumnIndex(Property_ID)));
            property.setProperty_type(cursor.getString(cursor.getColumnIndex(CONTACTS_property_type)));
            property.setSpd(cursor.getString(cursor.getColumnIndex(CONTACTS_sdp)));
            property.setDimension(cursor.getString(cursor.getColumnIndex(CONTACTS_dimension)));
            property.setOnsites(cursor.getString(cursor.getColumnIndex(onsite)));
            property.setCarpets(cursor.getString(cursor.getColumnIndex(carpet )));
            property.setSuperareas(cursor.getString(cursor.getColumnIndex(superarea)));
            property.setCost(cursor.getString(cursor.getColumnIndex(costpersqr)));
            property.setStart(cursor.getString(cursor.getColumnIndex(clientds )));
            property.setFinalcost(cursor.getString(cursor.getColumnIndex(Clientdf)));
            property.setOther(cursor.getString(cursor.getColumnIndex(other)));
            property.setSqrd(cursor.getString(cursor.getColumnIndex(sq_yrd)));



            Log.e("name",""+property.getName());
            get_propertylist.add(property);

            cursor.moveToNext();

        }
        return get_propertylist;

    }

}

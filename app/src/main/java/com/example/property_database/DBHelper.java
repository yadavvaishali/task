package com.example.property_database;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    Context context;

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

    public static final String Realestates_TABLE_NAME = "realestates";
    public static final String realestatesid = "realestatesid";
    public static final String realname = "realname";
    public static final String reallocation = "reallocation";
    public static final String realsqr= "realsqr";
    public static final String realbuild = "realbuild";
    public static final String realcarpet = "realcarpet";
    public static final String superreal = "superreal";
    public static final String realcost = "realcost";
    public static final String discounted = "discounted";
    public static final String bspreal = "bspreal";
    public static final String finalreal = "finalreal";
    public static final String phnreal = "phnreal";
    public static final String otherreal = "otherreal";
    public static final String ptypereal = "ptypereal";
    public static final String typesreal = "typesreal";

    public static final String Rental_TABLE_NAME = "rentproperty";
    public static final String owner = "owner";
    public static final String locationrent = "locationrent";
    public static final String sqrrent = "sqrrent";
    public static final String carpetrent= "carpetrent";
    public static final String superrent = "superrent";
    public static final String sqftrent = "sqftrent";
    public static final String rent = "rent";
    public static final String otherrent = "otherrent";
    public static final String category = "category";
    public static final String ptype = "ptype";
    public static final String rentid = "rentid";

    private static final String CREATE_TABLE = "create table " + CONTACTS_TABLE_NAME + "(" + Property_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CONTACTS_name + " TEXT NOT NULL, " + CONTACTS_location + " TEXT ," +
              CONTACTS_sdp + " TEXT," + CONTACTS_property_type + " TEXT," + CONTACTS_dimension + " TEXT,"
            + sq_yrd + " TEXT," + onsite + " TEXT," + carpet + " TEXT," + superarea + " TEXT," + costpersqr + " TEXT," +
            clientds + " TEXT," + Clientdf + " TEXT," + other + " TEXT);";

    private static final String CREATE_TABLE2 = "create table " + Realestates_TABLE_NAME  + "(" + realestatesid
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + realname + " TEXT NOT NULL, " + reallocation + " TEXT ," +
            realsqr+ " TEXT," + realbuild  + " TEXT," +realcarpet+ " TEXT,"
            +superreal + " TEXT," + realcost + " TEXT," + discounted + " TEXT," + bspreal + " TEXT," + finalreal  + " TEXT," +
            phnreal + " TEXT," + otherreal + " TEXT," + ptypereal + " TEXT," + typesreal + " TEXT);";

    private static final String CREATE_TABLE3 = "create table " + Rental_TABLE_NAME  + "(" + rentid
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + owner  + " TEXT NOT NULL, " + locationrent + " TEXT ," +
            sqrrent+ " TEXT," + carpetrent + " TEXT," +superrent + " TEXT,"
            +sqftrent + " TEXT," +rent + " TEXT," +  otherrent + " TEXT," + category + " TEXT," + ptype  + " TEXT);";

    public DBHelper(@Nullable Context context) {
        super(context,  DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        sqLiteDatabase.execSQL(CREATE_TABLE2);
        sqLiteDatabase.execSQL(CREATE_TABLE3);

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

    public boolean insertRent(Property property){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("owner",property.getOwnerName());
        contentValues.put("locationrent",property.getLocation_rent());
        contentValues.put("sqrrent",property.getSqr_rent());
        contentValues.put("carpetrent",property.getCarpet_rent());
        contentValues.put("superrent",property.getSuper_rent());
        contentValues.put("sqftrent",property.getSqft_rent());
        contentValues.put("rent",property.getRent());
        contentValues.put("otherrent",property.getOther_details_rent());
        contentValues.put("category",property.getSpinner_category());
        contentValues.put("ptype ",property.getSpinner_ptyp());

        db.insert(Rental_TABLE_NAME, null, contentValues);
        return true;

    }

    public boolean insertRealEstate(Property property){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("realname",property.getReal_Name());
        contentValues.put("reallocation",property.getLocation_real());
        contentValues.put("realsqr",property.getSqr_real());
        contentValues.put("realbuild",property.getBuild());
        contentValues.put("realcarpet",property.getCarpet_real());
        contentValues.put("superreal",property.getSuper_area_real());
        contentValues.put("realcost",property.getCost_real());
        contentValues.put("discounted",property.getDiscounted());
        contentValues.put(" bspreal",property.getBsp_real());
        contentValues.put("finalreal",property.getFinalcost_real());
        contentValues.put("phnreal",property.getPhn_real());
        contentValues.put(" otherreal",property.getOther_details_real());
        contentValues.put("ptypereal",property.getPtyp());
        contentValues.put("typesreal",property.getType());



        db.insert("realestates", null, contentValues);
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

    public List<Property> getAllRent() {
        List<Property> get_propertylist=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "SELECT * FROM " + Rental_TABLE_NAME, null );

        cursor.moveToFirst();


        while(cursor.isAfterLast() == false){
            Property property=new Property();
            property.setOwnerName(cursor.getString(cursor.getColumnIndex(owner)));
            property.setLocation_rent(cursor.getString(cursor.getColumnIndex(locationrent)));
            property.setRentid(cursor.getString(cursor.getColumnIndex(rentid)));
//            property.setProperty_type(cursor.getString(cursor.getColumnIndex(CONTACTS_property_type)));
//            property.setSpd(cursor.getString(cursor.getColumnIndex(CONTACTS_sdp)));
//            property.setDimension(cursor.getString(cursor.getColumnIndex(CONTACTS_dimension)));
//            property.setOnsites(cursor.getString(cursor.getColumnIndex(onsite)));
//            property.setCarpets(cursor.getString(cursor.getColumnIndex(carpet )));
//            property.setSuperareas(cursor.getString(cursor.getColumnIndex(superarea)));
//            property.setCost(cursor.getString(cursor.getColumnIndex(costpersqr)));
//            property.setStart(cursor.getString(cursor.getColumnIndex(clientds )));
//            property.setFinalcost(cursor.getString(cursor.getColumnIndex(Clientdf)));
//            property.setOther(cursor.getString(cursor.getColumnIndex(other)));
//            property.setSqrd(cursor.getString(cursor.getColumnIndex(sq_yrd)));
//            Log.e("OWNER name",""+property.getOwnerName());

            get_propertylist.add(property);

            cursor.moveToNext();

        }
        return get_propertylist;

    }
    public List<Property> getAllRealestate() {
        List<Property> get_propertylist=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select * from realestates ", null );
        cursor.moveToFirst();


        while(cursor.isAfterLast() == false){
            Property property=new Property();
            property.setReal_Name(cursor.getString(cursor.getColumnIndex(realname)));
            property.setLocation_real(cursor.getString(cursor.getColumnIndex(reallocation)));
            property.setRealid(cursor.getString(cursor.getColumnIndex(realestatesid)));
//            property.setProperty_type(cursor.getString(cursor.getColumnIndex(CONTACTS_property_type)));
//            property.setSpd(cursor.getString(cursor.getColumnIndex(CONTACTS_sdp)));
//            property.setDimension(cursor.getString(cursor.getColumnIndex(CONTACTS_dimension)));
//            property.setOnsites(cursor.getString(cursor.getColumnIndex(onsite)));
//            property.setCarpets(cursor.getString(cursor.getColumnIndex(carpet )));
//            property.setSuperareas(cursor.getString(cursor.getColumnIndex(superarea)));
//            property.setCost(cursor.getString(cursor.getColumnIndex(costpersqr)));
//            property.setStart(cursor.getString(cursor.getColumnIndex(clientds )));
//            property.setFinalcost(cursor.getString(cursor.getColumnIndex(Clientdf)));
//            property.setOther(cursor.getString(cursor.getColumnIndex(other)));
//            property.setSqrd(cursor.getString(cursor.getColumnIndex(sq_yrd)));


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
    public List<Property> detailRent(String value) {
        List<Property> get_propertylist=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select * from rentproperty" + " WHERE "+ "rentid" + " = " + value, null );
        cursor.moveToFirst();


        while(cursor.isAfterLast() == false){
            Property property=new Property();
            property.setOwnerName(cursor.getString(cursor.getColumnIndex(owner)));
            property.setLocation_rent(cursor.getString(cursor.getColumnIndex(locationrent)));
            property.setRentid(cursor.getString(cursor.getColumnIndex(rentid)));
            property.setSqr_rent(cursor.getString(cursor.getColumnIndex(sqrrent)));
            property.setCarpet_rent(cursor.getString(cursor.getColumnIndex(carpetrent)));
            property.setSuper_rent(cursor.getString(cursor.getColumnIndex(superrent)));
            property.setSqft_rent(cursor.getString(cursor.getColumnIndex(sqftrent)));
            property.setRent(cursor.getString(cursor.getColumnIndex(rent )));
            property.setOther_details_rent(cursor.getString(cursor.getColumnIndex(otherrent)));
            property.setSpinner_category(cursor.getString(cursor.getColumnIndex(category )));
            property.setSpinner_ptyp(cursor.getString(cursor.getColumnIndex(ptype)));




            get_propertylist.add(property);

            cursor.moveToNext();

        }
        return get_propertylist;

    }
    public List<Property> detailRealestates(String value) {
        List<Property> get_propertylist=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select * from realestates" + " WHERE "+ "realestatesid" + " = " + value, null );
        cursor.moveToFirst();


        while(cursor.isAfterLast() == false){
            Property property=new Property();
            property.setReal_Name(cursor.getString(cursor.getColumnIndex(realname)));
            property.setLocation_real(cursor.getString(cursor.getColumnIndex(reallocation)));
            property.setRealid(cursor.getString(cursor.getColumnIndex(realestatesid)));
            property.setSqr_real(cursor.getString(cursor.getColumnIndex(realsqr)));
            property.setBuild(cursor.getString(cursor.getColumnIndex(realbuild)));
            property.setCarpet_real(cursor.getString(cursor.getColumnIndex(realcarpet)));
            property.setSuper_area_real(cursor.getString(cursor.getColumnIndex(superreal)));
            property.setCost_real(cursor.getString(cursor.getColumnIndex(realcost)));
            property.setDiscounted(cursor.getString(cursor.getColumnIndex(discounted )));
            property.setBsp_real(cursor.getString(cursor.getColumnIndex(bspreal)));
            property.setFinalcost_real(cursor.getString(cursor.getColumnIndex(finalreal )));
            property.setPhn_real(cursor.getString(cursor.getColumnIndex( phnreal)));
            property.setOther_details_real(cursor.getString(cursor.getColumnIndex(otherreal)));
            property.setPtyp(cursor.getString(cursor.getColumnIndex(ptypereal)));
            property.setType(cursor.getString(cursor.getColumnIndex(typesreal)));




            get_propertylist.add(property);

            cursor.moveToNext();

        }
        return get_propertylist;

    }



}

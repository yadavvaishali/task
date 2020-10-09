package com.example.property_database;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity4 extends AppCompatActivity {

    TextView sdp, name,property_type,location,dimension,sqyrd,onsite,carpet,superarea,costpersqr,clientds,clientdf,other;

    private DBHelper db;
    List<Property> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#0909D9"));
        actionBar.setBackgroundDrawable(colorDrawable);
        db=new DBHelper(MainActivity4.this);

        sdp=(TextView)findViewById(R.id.sdp2);
        name=(TextView) findViewById(R.id.name2);
        property_type=(TextView) findViewById(R.id.propertytype2);
        location=(TextView) findViewById(R.id.location2);
        dimension=(TextView) findViewById(R.id.plotdimension2);
        sqyrd=(TextView) findViewById(R.id.sqr2);
        onsite=(TextView) findViewById(R.id.onsite2);
        carpet=(TextView) findViewById(R.id.carpet2);
        superarea=(TextView) findViewById(R.id.superarea2);
        costpersqr=(TextView) findViewById(R.id.cost2);
        clientds=(TextView) findViewById(R.id.start2);
        clientdf=(TextView) findViewById(R.id.finalcost2);
        other=(TextView) findViewById(R.id.other2);
        Intent i= getIntent();
        String id = i.getStringExtra("itemid");
        item= db.detailContact(id);

        for (int j=0;j < item.size();j++)
        {

            Log.i("name "+j,item.get(j).getName());
            name.setText(item.get(j).getName());
            location.setText(item.get(j).getLocation());
            sdp.setText(item.get(j).getSpd());
             property_type.setText(item.get(j).getProperty_type());
            dimension.setText(item.get(j).getDimension());
            sqyrd.setText(item.get(j).getSqrd());
                    onsite.setText(item.get(j).getOnsites());
                    carpet.setText(item.get(j).getCarpets());
                    superarea.setText(item.get(j).getSuperareas());
            costpersqr.setText(item.get(j).getCost());
                    clientds.setText(item.get(j).getStart());
            clientdf.setText(item.get(j).getFinalcost());
                    other.setText(item.get(j).getOther());

        }



    }
}
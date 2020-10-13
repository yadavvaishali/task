package com.example.property_database;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Show_Rental extends AppCompatActivity {
TextView ownerName,location_rent,sqr_rent,carpet_rent,super_rent,sqft_rent,rent,other_details_rent,spinner_category,spinner_ptyp;
    List<Property> item;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__rental);
        db=new DBHelper(Show_Rental.this);

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0909D9"));
        actionBar.setBackgroundDrawable(colorDrawable);
       ownerName=(TextView)findViewById(R.id.owner);
       location_rent=(TextView)findViewById(R.id.loca_rent_show);
       spinner_category=(TextView)findViewById(R.id.category);
       spinner_ptyp=(TextView)findViewById(R.id.pt_rent);
       sqr_rent=(TextView)findViewById(R.id.sqr_rent_show);
       carpet_rent=(TextView)findViewById(R.id.carpet_rent_show);
       super_rent=(TextView)findViewById(R.id.super_show_rent);
       sqft_rent=(TextView)findViewById(R.id.sq_show_rent);
       rent=(TextView)findViewById(R.id.cost_per_mon);
       other_details_rent=(TextView)findViewById(R.id.other_show_rent);
        Intent i= getIntent();
        String id = i.getStringExtra("itemid");
        item= db.detailRent(id);
        for (int j=0;j < item.size();j++) {
            ownerName.setText(item.get(j).getOwnerName());
            location_rent.setText(item.get(j).getLocation_rent());
            spinner_category.setText(item.get(j).getSpinner_category());
            spinner_ptyp.setText(item.get(j).getSpinner_ptyp());
            sqr_rent.setText(item.get(j).getSqr_rent());
            carpet_rent.setText(item.get(j).getCarpet_rent());
            super_rent.setText(item.get(j).getSuper_rent());
            sqft_rent.setText(item.get(j).getSqft_rent());
            rent.setText(item.get(j).getRent());
            other_details_rent.setText(item.get(j).getOther_details_rent());
        }
        }

    }

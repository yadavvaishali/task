package com.example.property_database;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShowAllFields extends AppCompatActivity {
    Button miscellaneous_show,realestate_show,rental_show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_fields);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0909D9"));
        actionBar.setBackgroundDrawable(colorDrawable);
        miscellaneous_show=(Button)findViewById(R.id.miscellaneous_show);
        realestate_show=(Button)findViewById(R.id.realestate_show);
        rental_show=(Button)findViewById(R.id.rental_properties_show);
        miscellaneous_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Show_property.class);
                startActivity(i);
            }
        });
        realestate_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Recycle_realestate.class);
                startActivity(i);
            }
        });
        rental_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Rent_recycle.class);
                startActivity(i);
            }
        });
    }
}
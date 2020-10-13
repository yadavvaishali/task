package com.example.property_database;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Rental_Property extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText ownerName,location_rent,sqr_rent,carpet_rent,super_rent,sqft_rent,rent,other_details_rent;
    Spinner spinner_category,spinner_ptyp;
    ArrayList<String> pjtyperent,typesprent;
    ArrayAdapter<String> dataAdapterptrent,dataAdaptertrent;
    Button submit_rent;
    String ownerNamevalue,location_rentvalue,sqr_rentvalue,carpet_rentvalue,super_rentvalue,sqft_rentvalue,rentvalue,other_details_rentvalue,spinner_categoryvalue,spinner_ptypvalue;
    private DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental__property);
        db=new DBHelper(Rental_Property.this);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0909D9"));
        actionBar.setBackgroundDrawable(colorDrawable);
        spinner_category=(Spinner)findViewById(R.id.spinner_category);
        spinner_ptyp=(Spinner)findViewById(R.id.spinner_propetytype);
        ownerName=(EditText)findViewById(R.id.ownerName);
        location_rent=(EditText)findViewById(R.id.location_rent);
        sqr_rent=(EditText)findViewById(R.id.sqr_rent);
        carpet_rent=(EditText)findViewById(R.id.carpet_rent);
        super_rent=(EditText)findViewById(R.id.super_rent);
        sqft_rent=(EditText)findViewById(R.id.sqft_rent);
        rent=(EditText)findViewById(R.id.rent);

        other_details_rent=(EditText)findViewById(R.id.otherdetails_rent);
        submit_rent=(Button)findViewById(R.id.submit_rent);

        pjtyperent = new ArrayList<String>();
        typesprent= new ArrayList<String>();
        pjtyperent.add("Residential");
        pjtyperent.add("Commercial");
                typesprent.add("Rooms 2Bhk");
                typesprent.add("Rooms 3Bhk");
                typesprent.add("Flats");
                typesprent.add("Shops");


        spinner_category.setOnItemSelectedListener(this);
        spinner_ptyp.setOnItemSelectedListener(this);
        dataAdapterptrent = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pjtyperent);
        dataAdaptertrent = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,typesprent);
        dataAdapterptrent.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdaptertrent.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_category.setAdapter(dataAdapterptrent);
        spinner_ptyp.setAdapter(dataAdaptertrent);

        submit_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ownerNamevalue=ownerName.getText().toString();
                location_rentvalue=location_rent.getText().toString();
                        sqr_rentvalue=sqr_rent.getText().toString();
                        carpet_rentvalue=carpet_rent.getText().toString();
                        super_rentvalue=super_rent.getText().toString();
                        sqft_rentvalue=sqft_rent.getText().toString();
                        rentvalue=rent.getText().toString();
                        other_details_rentvalue=other_details_rent.getText().toString();
                        spinner_categoryvalue=spinner_category.getSelectedItem().toString();
                        spinner_ptypvalue=spinner_ptyp.getSelectedItem().toString();

                Property property=new Property();
                property.setOwnerName(ownerNamevalue);
                property.setLocation_rent(location_rentvalue);
                property.setCarpet_rent(carpet_rentvalue);
                property.setSuper_rent(super_rentvalue);
                property.setSqft_rent(sqft_rentvalue);
                property.setRent(rentvalue);
                property.setOther_details_rent(other_details_rentvalue);
                property.setSpinner_category(spinner_categoryvalue);
                property.setSpinner_ptyp(spinner_ptypvalue);
                Toast.makeText(Rental_Property.this, property.toString(), Toast.LENGTH_LONG).show();


                db.insertRent(property);
                Toast.makeText(Rental_Property.this, "Data submitted", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Rental_Property.this,FirstScrren.class);
                startActivity(i);
                ownerName.setText("");
                        location_rent.setText("");
                        sqr_rent.setText("");
                        carpet_rent.setText("");
                        super_rent.setText("");
                        sqft_rent.setText("");
                        rent.setText("");
                        other_details_rent.setText("");

            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
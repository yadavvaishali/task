package com.example.property_database;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {
    ArrayAdapter<String> dataAdapter;
    ArrayAdapter<String> dataAdapter2;
    ArrayAdapter<String> dataAdapter3;
    Spinner spinner,spinner2,spinner3;
    ArrayList<String> categories,categories2,categories3;
    Button submit;
    EditText name,location,plotdimension,sqr,onsite,carpet,superarea,costpersqr,clientds,clientdf,otherdetails;
    String spd,namee,locationd,dimension,sqrd,onsites,carpets,superareas,cost,start,finalcost,other,propery_type;

    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DBHelper(MainActivity.this);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0909D9"));
        actionBar.setBackgroundDrawable(colorDrawable);

        categories = new ArrayList<String>();
        categories2 = new ArrayList<String>();
        categories3 = new ArrayList<String>();
        categories.add("Seller");
        categories.add("Dealer");
        categories.add("Project Name");
        categories2.add("Plot");
        categories2.add("House");
        categories3.add("Duplex");
        categories3.add("Single");


        // Spinner element
         spinner = (Spinner) findViewById(R.id.spinner1);
         spinner2 = (Spinner) findViewById(R.id.spinner2);
         spinner3 = (Spinner) findViewById(R.id.spinner3);

         name=(EditText)findViewById(R.id.txtName);
         location=(EditText)findViewById(R.id.location);
        plotdimension=(EditText)findViewById(R.id.plotdimension);
        sqr=(EditText)findViewById(R.id.sqr);
        otherdetails=(EditText)findViewById(R.id.otherdetails);
        onsite=(EditText)findViewById(R.id.onsite);
        carpet=(EditText)findViewById(R.id.carpet);
        superarea=(EditText)findViewById(R.id.superarea);
        costpersqr=(EditText)findViewById(R.id.cost);
        clientds=(EditText)findViewById(R.id.start);
        clientdf=(EditText)findViewById(R.id.finalcost);




        // Spinner click listener
       spinner.setOnItemSelectedListener(this);
       spinner2.setOnItemSelectedListener(this);
       spinner3.setOnItemSelectedListener(this);






        // Creating adapter for spinner
      dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);
        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3);


        // Drop down layout style - list view with radio button
       dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter2);
        spinner3.setAdapter(dataAdapter3);
        submit=(Button)findViewById(R.id.submit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(name.length()==0 || location.length()==0||plotdimension.length()==0 ||sqr.length()==0)
        {
            Toast.makeText(getApplicationContext(),
                    "Mandatory fields",
                    Toast.LENGTH_LONG).show();
        }
            else{
                    if (spinner2.getSelectedItem().toString().equals("HOUSE")){
                        dimension=spinner3.getSelectedItem().toString();

                    }
else
                    {    dimension=plotdimension.getText().toString();}
                    namee = name.getText().toString();
                locationd=location.getText().toString();
                sqrd=sqr.getText().toString();
                onsites=onsite.getText().toString();
                carpets=carpet.getText().toString();
                superareas=superarea.getText().toString();
                cost=costpersqr.getText().toString();
                start=clientds.getText().toString();
                finalcost=clientdf.getText().toString();
                other=otherdetails.getText().toString();
//MODEL CLASS  CALL
                Property property=new Property();
                property.setName(namee);
                property.setLocation(locationd);
                property.setSpd(spd);
                property.setDimension(dimension);
                property.setSqrd(sqrd);
                property.setOnsites(onsites);
                property.setCarpets(carpets);
                property.setSuperareas(superareas);
                property.setCost(cost);
                property.setStart(start);
                property.setFinalcost(finalcost);
                property.setOther(other);
                property.setProperty_type(propery_type);

//                Toast.makeText(MainActivity.this, property.toString(), Toast.LENGTH_SHORT).show();
               db.insertContact(property);
                Toast.makeText(MainActivity.this, "Data submitted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), FirstScrren.class);
                startActivity(intent);
                name.setText("");
                location.setText("");
                sqr.setText("");
                onsite.setText("");
                carpet.setText("");
                superarea.setText("");
                costpersqr.setText("");
                clientds.setText("");
                clientdf.setText("");
                otherdetails.setText("");
                plotdimension.setText("");
                }


            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
       spd=spinner.getSelectedItem().toString();
       propery_type=spinner2.getSelectedItem().toString();


            final boolean house;
        if (spinner2.getSelectedItem().toString().equals("HOUSE")){
            house = true;
           plotdimension.setVisibility(View.GONE);
           plotdimension.setText("0");
           spinner3.setVisibility(View.VISIBLE);




        }

        else { house = false;
            spinner3.setVisibility(View.GONE);
            spinner3.setAdapter(dataAdapter3);
            plotdimension.setVisibility(View.VISIBLE);



        }


    }




    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



}



















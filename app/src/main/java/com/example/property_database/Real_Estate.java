package com.example.property_database;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Real_Estate extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText real_Name,location_real,sqr_real,build,carpet_real,super_area_real,cost_real,discounted,bsp_real,finalcost_real,phn_real,other_details_real;
    Spinner ptyp,type;
    ArrayList<String> pjtype,typesp;
    ArrayAdapter<String> dataAdapterpt,dataAdaptert;
    Button submit_real;
    String ptypvalue,typevalue,real_Namevalue,location_realvalue,sqr_realvalue,buildvalue,carpet_realvalue,super_area_realvalue,cost_realvalue,discountedvalue,bsp_realvalue,finalcost_realvalue,phn_realvalue,other_details_realvalue;
    private DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real__estate);
        db=new DBHelper(Real_Estate.this);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0909D9"));
        actionBar.setBackgroundDrawable(colorDrawable);
                 ptyp=(Spinner)findViewById(R.id.spinner_ptype);
                 type=(Spinner)findViewById(R.id.spinner_type);
                real_Name=(EditText)findViewById(R.id.real_Name);
                location_real=(EditText)findViewById(R.id.location_real);
                sqr_real=(EditText)findViewById(R.id.sqr_real);
                build=(EditText)findViewById(R.id.build);
                carpet_real=(EditText)findViewById(R.id.carpet_real);
                super_area_real=(EditText)findViewById(R.id.superarea_real);
                cost_real=(EditText)findViewById(R.id.cost_real);
                discounted=(EditText)findViewById(R.id.discounted);
                bsp_real=(EditText)findViewById(R.id.bsp_real);
                finalcost_real=(EditText)findViewById(R.id.finalcost_real);
                phn_real=(EditText)findViewById(R.id.phn_real);
                other_details_real=(EditText)findViewById(R.id.otherdetails_real);
                submit_real=(Button)findViewById(R.id.submit_real);

        pjtype   = new ArrayList<String>();
        typesp= new ArrayList<String>();
        pjtype.add("Flats");
        pjtype.add("Villas");
        pjtype.add("Complex");
        pjtype.add("Mall");
        typesp.add("Studio");
        typesp.add("2Bhk");
        typesp.add("3Bhk");
        typesp.add("3Bhk+Servant");

        ptyp.setOnItemSelectedListener(this);
        type.setOnItemSelectedListener(this);
        dataAdapterpt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pjtype);
        dataAdaptert = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, typesp);
        dataAdapterpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdaptert.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ptyp.setAdapter(dataAdapterpt);
        type.setAdapter(dataAdaptert);

                        submit_real.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        ptypvalue=ptyp.getSelectedItem().toString();
                        typevalue=type.getSelectedItem().toString();
                        real_Namevalue=real_Name.getText().toString();
                        location_realvalue=location_real.getText().toString();
                        sqr_realvalue=sqr_real.getText().toString();
                        buildvalue=build.getText().toString();
                        carpet_realvalue=carpet_real.getText().toString();
                        super_area_realvalue=super_area_real.getText().toString();
                        cost_realvalue=cost_real.getText().toString();
                        discountedvalue=discounted.getText().toString();
                        bsp_realvalue=bsp_real.getText().toString();
                        finalcost_realvalue=finalcost_real.getText().toString();
                        phn_realvalue=phn_real.getText().toString();
                        other_details_realvalue=other_details_real.getText().toString();

                        Property property=new Property();
                        property.setPtyp(ptypvalue);
                        property.setType(typevalue);
                        property.setReal_Name(real_Namevalue);
                        property.setLocation_real(location_realvalue);
                        property.setSqr_real(sqr_realvalue);
                        property.setBuild(buildvalue);
                        property.setCarpet_real(carpet_realvalue);
                        property.setSuper_area_real(super_area_realvalue);
                        property.setCost_real(cost_realvalue);
                        property.setDiscounted(discountedvalue);
                        property.setBsp_real(bsp_realvalue);
                        property.setFinalcost(finalcost_realvalue);
                        property.setPhn_real(phn_realvalue);
                        property.setOther_details_real(other_details_realvalue);
                db.insertRealEstate(property);
                Toast.makeText(Real_Estate.this, "Data submitted", Toast.LENGTH_SHORT).show();

                Intent i=new Intent(getApplicationContext(),FirstScrren.class);
                startActivity(i);
                real_Name.setText("");
                        location_real.setText("");
                        sqr_real.setText("");
                        build.setText("");
                        carpet_real.setText("");
                        super_area_real.setText("");
                        cost_real.setText("");
                        discounted.setText("");bsp_real.setText("");
                        finalcost_real.setText("");
                        phn_real.setText("");
                        other_details_real.setText("");
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
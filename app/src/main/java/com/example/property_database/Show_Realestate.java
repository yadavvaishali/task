package com.example.property_database;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Show_Realestate extends AppCompatActivity {
    private DBHelper db;
    List<Property> item;
    TextView real_Name,location_real,sqr_real,build,carpet_real,super_area_real,cost_real,discounted,bsp_real,finalcost_real,phn_real,other_details_real,ptyp,type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__realestate);
        db=new DBHelper(Show_Realestate.this);

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0909D9"));
        actionBar.setBackgroundDrawable(colorDrawable);

        real_Name=(TextView)findViewById(R.id.name_real);
                location_real=(TextView)findViewById(R.id.loca_real_show);
        sqr_real=(TextView)findViewById(R.id.sqr_real_show);
        build=(TextView)findViewById(R.id.built_real);
        carpet_real=(TextView)findViewById(R.id.carpet_show_real);
        super_area_real=(TextView)findViewById(R.id.superarea_real_show);
        cost_real=(TextView)findViewById(R.id.cost_per_real);
        discounted=(TextView)findViewById(R.id.dis_show);
        bsp_real=(TextView)findViewById(R.id.bsp_show);
        finalcost_real=(TextView)findViewById(R.id.total_final_re);
        phn_real=(TextView)findViewById(R.id.contact);
        other_details_real=(TextView)findViewById(R.id.other_show);
        ptyp=(TextView)findViewById(R.id.pt_show);
        type=(TextView)findViewById(R.id.ty_real);
        Intent i= getIntent();
        String id = i.getStringExtra("itemid");
        item= db.detailRealestates(id);
        for (int j=0;j < item.size();j++) {
            real_Name.setText(item.get(j).getReal_Name());
            location_real.setText(item.get(j).getLocation_real());
                    sqr_real.setText(item.get(j).getSqr_real());
                    build.setText(item.get(j).getBuild());
                    carpet_real.setText(item.get(j).getCarpet_real());
                    super_area_real.setText(item.get(j).getSuper_area_real());
                    cost_real.setText(item.get(j).getCost_real());
                    discounted.setText(item.get(j).getDiscounted());
                    bsp_real.setText(item.get(j).getBsp_real());
                    finalcost_real.setText(item.get(j).getFinalcost_real());
                    phn_real.setText(item.get(j).getPhn_real());
                    other_details_real.setText(item.get(j).getOther_details_real());
                    ptyp.setText(item.get(j).getPtyp());
                    type.setText(item.get(j).getType());
        }
    }
}
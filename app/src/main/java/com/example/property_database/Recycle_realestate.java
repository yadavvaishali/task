package com.example.property_database;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

public class Recycle_realestate extends AppCompatActivity {
    Intent intent;
    private RealstaesAdapter realstaesAdapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_realestate);
        DBHelper db = new DBHelper(this);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0909D9"));
        actionBar.setBackgroundDrawable(colorDrawable);
        db.getAllRealestate();
        recyclerView=(RecyclerView)findViewById(R.id.recyclerViewreal);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Recycle_realestate.this);
        recyclerView.setLayoutManager(layoutManager);
        realstaesAdapter=new RealstaesAdapter(Recycle_realestate.this,db.getAllRealestate());
        recyclerView.setAdapter( realstaesAdapter);
        realstaesAdapter.notifyDataSetChanged();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.app_bar_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setQueryHint("find by location");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();


                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                realstaesAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}
package com.rabbitstudio.recycler;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    listAdapter adapter;
    RecyclerView hs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hs = findViewById(R.id.rcview);

        hs.setHasFixedSize(false);
        hs.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.add: addView(v);
        }
    }

    public void addView(View v)
    {
        if(adapter == null) {
            adapter = new listAdapter(this);
            hs.setAdapter(adapter);
        }
        adapter.addView("Name",0.0, 0, "Specs");
    }
}
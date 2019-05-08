package com.example.luckyfinalproject_meixuanlyanyingl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class cat_recyclerview extends AppCompatActivity {

    private List<cats> cats;
    private catsAdapter catsAdapter;
    RecyclerView recyclerView;
    public Button back3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_recyclerview);

        initialData();
        recyclerView = (RecyclerView) findViewById(R.id.cats_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        catsAdapter = new catsAdapter(cats, this);
        recyclerView.setAdapter(catsAdapter);

        back3=(Button)findViewById(R.id.back3);
        back3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(cat_recyclerview.this,NewActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initialData() {
        cats = new ArrayList<>();
        cats.add(new cats(getString(R.string.catTitle1), getString(R.string.catinfo1),R.drawable.meow));
        cats.add(new cats(getString(R.string.catTitle2), getString(R.string.catinfo2), R.drawable.eyelids));
        cats.add(new cats(getString(R.string.catTitle3), getString(R.string.catinfo3),R.drawable.nose));
       cats.add(new cats(getString(R.string.catTitle4), getString(R.string.catinfo4),R.drawable.taste));
    }
    }

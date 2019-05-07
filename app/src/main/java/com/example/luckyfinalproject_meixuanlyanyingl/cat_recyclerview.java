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
        cats.add(new cats("Meow", "Cats don't meow as a way to communicate with each other. It's a method they use for getting attention from human.",R.drawable.meow));
        cats.add(new cats("Eyelids", "Cats have 3 eyelids.", R.drawable.eyelids));
        cats.add(new cats("Nose", "A cat’s nose is as unique as a human’s fingerprint.",R.drawable.nose));
       cats.add(new cats("Taste", "Cats are believed to be the only mammals who don't taste sweetness.",R.drawable.taste));
    }
    }

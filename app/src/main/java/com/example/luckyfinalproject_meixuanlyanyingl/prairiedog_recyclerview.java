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

public class prairiedog_recyclerview extends AppCompatActivity {

    private List<prairiedogs> prairiedogs;
    private prairiedogsAdapter prairiedogsAdapter;
    RecyclerView recyclerView;
    public Button back2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prairiedog_recyclerview);

        initialData();
        recyclerView = (RecyclerView) findViewById(R.id.prairiedog_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        prairiedogsAdapter = new prairiedogsAdapter(prairiedogs, this);
        recyclerView.setAdapter(prairiedogsAdapter);

        back2 = (Button) findViewById(R.id.back2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(prairiedog_recyclerview.this, NewActivity.class);
                startActivity(intent);
            }
        });
    }


    private void initialData() {
        prairiedogs = new ArrayList<>();
        prairiedogs.add(new prairiedogs("White Spots", "Most deer are born with white spots but lose them within a year.", R.drawable.whitespots));
        prairiedogs.add(new prairiedogs("First Step", "Deer take their first steps within half an hour of their birth.", R.drawable.babydeer));
        prairiedogs.add(new prairiedogs("Mating Season", "During the mating season male deer will often use their antlers to fight for the attention of female deer.", R.drawable.deerfight));
        prairiedogs.add(new prairiedogs("Antlers", "Deer are the only group of animals in the world to have antlers. Antlers are the fastest growing living tissue in the world!", R.drawable.alters));
    }
}
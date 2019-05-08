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
        prairiedogs.add(new prairiedogs(getString(R.string.praTitle1), getString(R.string.prainfo1), R.drawable.whitespots));
        prairiedogs.add(new prairiedogs(getString(R.string.praTitle2), getString(R.string.prainfo2), R.drawable.babydeer));
        prairiedogs.add(new prairiedogs(getString(R.string.praTitle3), getString(R.string.prainfo3), R.drawable.deerfight));
        prairiedogs.add(new prairiedogs(getString(R.string.praTitle4), getString(R.string.prainfo4), R.drawable.alters));
    }
}
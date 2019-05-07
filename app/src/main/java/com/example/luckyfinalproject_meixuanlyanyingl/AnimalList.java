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


public class AnimalList extends AppCompatActivity {
    private List<Person> persons;
    private PersonsAdapter personsAdapter;
    RecyclerView recyclerView;
    public Button back1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_list);
        initialData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        personsAdapter = new PersonsAdapter(persons, this);
        recyclerView.setAdapter(personsAdapter);

        back1=(Button)findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(AnimalList.this,NewActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initialData() {
        persons = new ArrayList<>();
        persons.add(new Person("Born", "Rabbits are born with their eyes closed and without fur.",R.drawable.nofur));
        persons.add(new Person("Binky", "A bunny will hop when it's happy and do a twist in mid-air. This adorable action has an equally adorable name: It's called a binky.", R.drawable.bunky));
        persons.add(new Person("360 Degree vision", "Rabbits' vision covers nearly 360 degrees.",R.drawable.rabbit1));
        persons.add(new Person("Stay Cool", " The oversized ears have the added benefit of cooling rabbits down on a hot day.",R.drawable.rabbitear));
    }
}
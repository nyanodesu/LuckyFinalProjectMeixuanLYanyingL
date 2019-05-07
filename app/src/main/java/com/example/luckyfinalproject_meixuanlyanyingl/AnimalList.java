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
        persons.add(new Person("Fingerprints", "The fingerprints of a koala are so indistinguishable from humans that they have on occasion been confused at a crime scene.",R.drawable.koalafingerprints));
        persons.add(new Person("Sleeping", "Koalas Sleep Up to 22 Hours a Day.", R.drawable.koalasleep));
        persons.add(new Person("Eat A Lot", "An adult koala eats about 1/2 - 1 kilogram of leaves each night.",R.drawable.koalaeats));
        persons.add(new Person("Baby(Joey)", "Baby Koalas are known as ‘Joeys'. The Joey stays in its mother’s pouch for about 6 or 7 months, drinking only milk. ",R.drawable.koalababy));
    }
}
package com.example.luckyfinalproject_meixuanlyanyingl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    public Button click;
    public Button clicktoQuiz;
    public Button profile;
    public Button meetAnimals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profile=(Button)findViewById(R.id.profile);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Profile.class);
                startActivity(intent);
            }
        });

        meetAnimals = (Button) findViewById(R.id.meet_animals);

        click=(Button)findViewById(R.id.click);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NewActivity.class);
                startActivity(intent);
            }
        });

        clicktoQuiz=(Button)findViewById(R.id.clicktoquiz);
        clicktoQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,quiz_main_activity.class);
                startActivity(intent);
            }
        });



    }
}

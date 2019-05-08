package com.example.luckyfinalproject_meixuanlyanyingl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.Company.MeetAnimals.UnityPlayerActivity;
import com.google.firebase.auth.FirebaseAuth;

public class Menu extends AppCompatActivity {

    public Button click;
    public Button clicktoQuiz;
    public Button meetAnimals;
    private FirebaseAuth auth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        click=(Button)findViewById(R.id.click);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this,NewActivity.class);
                startActivity(intent);
            }
        });

        clicktoQuiz=(Button)findViewById(R.id.clicktoquiz);
        clicktoQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this,quiz_main_activity.class);
                startActivity(intent);
            }
        });

        meetAnimals = (Button) findViewById(R.id.meet_animals);
        meetAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this, UnityPlayerActivity.class);
                startActivity(intent);
            }
        });
    }

    public void logOut(View view){
        auth.signOut();
        startActivity(new Intent(Menu.this,MainActivity.class));
    }
}

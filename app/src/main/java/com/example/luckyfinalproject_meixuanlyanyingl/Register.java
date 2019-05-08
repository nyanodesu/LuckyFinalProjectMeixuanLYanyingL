package com.example.luckyfinalproject_meixuanlyanyingl;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class Register extends AppCompatActivity {

    private EditText createNameEditText;
    private EditText createEmailEditText;
    private EditText createPasswordEditText;
    public FirebaseAuth mAuth;
    private String email,password;

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    public DatabaseReference myRef = database.getReference("userInfo");





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        createNameEditText = (EditText)findViewById(R.id.create_name);
        createEmailEditText = (EditText) findViewById(R.id.create_email);
        createPasswordEditText = (EditText) findViewById(R.id.create_password);

    }


}

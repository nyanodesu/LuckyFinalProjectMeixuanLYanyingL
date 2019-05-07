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

public class Login extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button logIn;
    private Button signUp;
    private FirebaseAuth mAuth;
    private String username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);
        logIn = (Button) findViewById(R.id.log_in);
        mAuth = FirebaseAuth.getInstance();

    }

    public void login(View view){
        username = usernameEditText.getText().toString();
        password = passwordEditText.getText().toString();

        mAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(Login.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Login.this, task.getResult().getUser().getEmail() + " logged in successful",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login.this,MainActivity.class));
                        }
                    }
                });

    }

    public void signup(View view){
        username = usernameEditText.getText().toString();
        password = passwordEditText.getText().toString();

        mAuth.createUserWithEmailAndPassword(username,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    Toast.makeText(Login.this,task.getException().toString(),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Login.this,task.getResult().getUser().getEmail()+"signed up successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this,MainActivity.class));
                }
            }
        });
    }
}

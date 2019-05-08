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

public class Login extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button logIn;
    private Button signUp;
    private FirebaseAuth mAuth;
    private String username,password;

    private EditText createNameEditText;
    private EditText createEmailEditText;
    private EditText createPasswordEditText;
    public Button signupButton;
    public String email;

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    public DatabaseReference myRef = database.getReference("userInfo");

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

    public void register(View view){
        Intent intent=new Intent(Login.this,Register.class);
        startActivity(intent);
    }

    public void signup(View view){
        email = createEmailEditText.getText().toString();
        password = createPasswordEditText.getText().toString();

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    Toast.makeText(Login.this,task.getException().toString(),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Login.this,task.getResult().getUser().getEmail()+"signed up successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this,Login.class));
                }
            }
        });
    }

    public void clear(View view){
        createNameEditText.setText("");
        createPasswordEditText.setText("");
        createEmailEditText.setText("");
    }
}

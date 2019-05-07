package com.example.luckyfinalproject_meixuanlyanyingl;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {

    private ImageView avatarImage;
    private TextView name;
    private int avatarNum;
    private String nameString;

    private String[] avatar = {"avatar1","avatar2","avatar3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser() ;
        //currentUser.getUid();

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference uidRef = rootRef.child("users").child(uid);
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                nameString = dataSnapshot.child("name").getValue(String.class);
                avatarNum = dataSnapshot.child("avatar").getValue(int.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };

        avatarImage = (ImageView) findViewById(R.id.avatar_image_view);
        String mDrawableName = avatar[avatarNum];
        int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        avatarImage.setImageDrawable(getResources().getDrawable(resID));
        name = (TextView) findViewById(R.id.name_text_view);
        name.setText(nameString);


        }

    }


package com.example.luckyfinalproject_meixuanlyanyingl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class quiz_main_activity extends AppCompatActivity {

    private static final String TAG="QuizActivity";
    private TextView mTextView;
    private Button mFalseButton;
    private Button mTrueButton;
    private Button mNextButton;
    private Button mCheatButton;
    public static final int REQUEST_CODE_CHEAR=0;

    private Question[] sQuestionbank =new Question[]{
            new Question(R.string.question_1,true),
            new Question(R.string.question_2,false),
            new Question(R.string.question_3,true),
            new Question(R.string.question_4,true),
            new Question(R.string.question_5,false),
            new Question(R.string.question_6,true),
    };

    private int mCurrentIndex=0;
    private boolean mIsCheater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCheatButton=(Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    Intent intent=new Intent(MainActivity.this, Main2Activity.class);
                Boolean answerIsTrue=sQuestionbank[mCurrentIndex].ismAnswerTrue();
                Intent intent=quiz_answer_activity.newIntent(quiz_main_activity.this,answerIsTrue);
                startActivityForResult(intent,REQUEST_CODE_CHEAR);
            }
        });

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton=(Button)findViewById(R.id.next_button);
        mTextView=(TextView)findViewById(R.id.text_box);
        updateQuestion();


        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCurrentIndex=(mCurrentIndex+1)%sQuestionbank.length;
                mIsCheater=false;
                updateQuestion();
            }
        });

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });


        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }

        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode!= Activity.RESULT_OK){
            return;
        }
        if(requestCode==REQUEST_CODE_CHEAR){
            if(data==null){
                return;
            }
            mIsCheater=quiz_answer_activity.wasAnswerShown(data);
        }
    }

    public void updateQuestion(){
        int question=sQuestionbank[mCurrentIndex].getmTextResId();
        mTextView.setText(question);
    }

    public void checkAnswer(boolean userPressedTrue) {
        boolean userIsTrue = sQuestionbank[mCurrentIndex].ismAnswerTrue();
        int messageResID = 0;

        if (mIsCheater) {
            messageResID = R.string.judgement_text;
        } else {
            if (userPressedTrue == userIsTrue) {
                messageResID = R.string.correct_toast;
            } else {
                messageResID = R.string.incorrect_toast;
            }
        }
        Toast.makeText(this, messageResID, Toast.LENGTH_SHORT).show();


    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"onStart called");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"onResume called");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"onPause called");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"onStop called");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy called");
    }

}
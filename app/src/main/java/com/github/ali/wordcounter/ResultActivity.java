package com.github.ali.wordcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView mTextView, mTextView2, mTextView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mTextView = findViewById(R.id.textView2);
        mTextView2 = findViewById(R.id.textView3);
        mTextView3 = findViewById(R.id.textView4);


        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String getSentence = extras.getString("sentence");
            int getCharacters = extras.getInt("characters");
            int getWordCount = extras.getInt("words");


            mTextView.setText("Sentence : "+getSentence);
            mTextView2.setText("Number of Characters: "+String.valueOf(getCharacters));
            mTextView3.setText("Number of Words : "+String.valueOf(getWordCount));
        }
    }
}

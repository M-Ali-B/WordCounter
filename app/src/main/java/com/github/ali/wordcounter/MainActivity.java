package com.github.ali.wordcounter;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;
    Button mButton;
    TextView mTextView;
    String sentence;
    String delimiter = " ";
    int words_count;

    String token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mEditText = findViewById(R.id.editText);
        mButton = findViewById(R.id.button);
        mTextView = findViewById(R.id.textView);

        // loca variable to store edit text content


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sentence = mEditText.getText().toString();
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                if (sentence == null || sentence.isEmpty()) {

                    builder1.setTitle("Word Counts");
                    builder1.setMessage("Empty");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                } else {


                    StringTokenizer tokenizer = new StringTokenizer(sentence, delimiter);


                    words_count = tokenizer.countTokens(); // count words in the whole sentence

                    int total_token_length = 0;
                    while (tokenizer.hasMoreTokens()) {     // a boolean value for finding presence of more tokens
                        token = tokenizer.nextToken();            // it gets every next token
                        total_token_length += token.length();    // here we count the next token's length
                    }
                    String result = " Word: " + sentence + "\n Length :" + total_token_length + " \n Words in sentence " + words_count;


                    builder1.setTitle("Word Counts");
                    builder1.setMessage(result);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                }
                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });

    }
}

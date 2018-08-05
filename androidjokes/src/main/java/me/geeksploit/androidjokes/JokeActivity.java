package me.geeksploit.androidjokes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "extra_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra(EXTRA_JOKE)) return;

        String joke = intent.getStringExtra(EXTRA_JOKE);
        TextView jokeBody = findViewById(R.id.joke_body);
        jokeBody.setText(joke);
    }
}

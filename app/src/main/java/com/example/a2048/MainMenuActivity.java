package com.example.a2048;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMenuActivity extends AppCompatActivity {
    private Intent game;
    private SharedPreferences sharedPref;
    private TextView high_score_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        sharedPref = getSharedPreferences(Keys.PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        high_score_txt = findViewById(R.id.high_score_txt);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        super.onResume();
        int high_score = sharedPref.getInt(Keys.HIGH_SCORE_KEY, 0);
        high_score_txt.setText(getResources().getString(R.string.your_high_score) + " " + high_score);
    }

    public void btn_new_game_click(View view) {
        game = new Intent(this, GameActivity.class);
        startActivity(game);
    }

    public void btn_continue_click(View view) {
        game = new Intent(this, GameActivity.class);
        game.putExtra(Keys.SAVE_KEY, true);
        startActivity(game);
    }
}
package com.example.dice_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button randomize_button;
    ImageView[] dices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomize_button = findViewById(R.id.button);
        dices = new ImageView[]{findViewById(R.id.Dice1), findViewById(R.id.Dice2), findViewById(R.id.Dice3), findViewById(R.id.Dice4), findViewById(R.id.Dice5)};
        randomize_button.setOnClickListener(view -> {

        });
    }
}
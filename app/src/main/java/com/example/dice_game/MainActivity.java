package com.example.dice_game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button randomize_button;
    Button reset_button;
    ImageView[] dices = {};
    int[] rolls = {};
    int result = 0;
    int game_result = 0;
    TextView rollResult;
    TextView gameResult;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomize_button = findViewById(R.id.button);
        reset_button = findViewById(R.id.resetButton);
        rollResult = findViewById(R.id.rollResult);
        gameResult = findViewById(R.id.gameResult);
        dices = new ImageView[]{findViewById(R.id.Dice1), findViewById(R.id.Dice2), findViewById(R.id.Dice3), findViewById(R.id.Dice4), findViewById(R.id.Dice5)};
        rolls = new int[5];
        randomize_button.setOnClickListener(view -> {
            for (int i = 0; i < 5; i++) {
                int rnd = new Random().nextInt(6) + 1;
                switch (rnd){
                    case 1:
                        dices[i].setImageResource(R.drawable.dice_1);
                        break;
                    case 2:
                        dices[i].setImageResource(R.drawable.dice_2);
                        break;
                    case 3:
                        dices[i].setImageResource(R.drawable.dice_3);
                        break;
                    case 4:
                        dices[i].setImageResource(R.drawable.dice_4);
                        break;
                    case 5:
                        dices[i].setImageResource(R.drawable.dice_5);
                        break;
                    case 6:
                        dices[i].setImageResource(R.drawable.dice_6);
                        break;
                    default:
                        break;
                }
                rolls[i] = rnd;
            }
            for (int roll:
                 rolls) {
                ArrayList<Integer> duplicates = new ArrayList<Integer>();
                for (int otherRoll:
                     rolls) {
                    if (otherRoll==roll){
                        duplicates.add(otherRoll);
                    }
                }
                if (duplicates.size() > 1) {
                    result += duplicates.get(0);
                }
            }
            game_result += result;
            gameResult.setText("Wynik gry: " + game_result);
            rollResult.setText("Wynik tego losowania: " + result);
            result = 0;
        });

        reset_button.setOnClickListener(view -> {
            game_result = 0;
            gameResult.setText("Wynik gry: " + game_result);
        });
    }
}
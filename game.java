package com.example.gameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;


    private int roundCount;
    private int player1Points;
    private int player2Points;

    private TextView txtplayer1;
    private TextView txtplayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create objects of each player using their id
        txtplayer1 = findViewById(R.id.text_view_p1);
        txtplayer2 = findViewById(R.id.text_view_p2);


        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                String buttonID = "button_"+i+j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (!((Button) view).getText().toString().equals("")) {
            return;
        }

        if (player1Turn) {
            ((Button) view).setText("X");
        } else {
            ((Button) view).setText("O");
        }
        roundCount++;
        if (checkForWin()) {
            if (player1Turn) {
                player1Wins(); //function to define
            } else {
                player2Wins(); // function to define
            }
        } else if (roundCount == 9) {
            draw(); //function to define
        } else {
            player1Turn = !player1Turn;
        }
    }

    private boolean checkForWin(){
        String[][] field = new String[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        for(int i=0;i<3;i++)
        {
            if(field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].equals(""))
            {
                return true;
            }
        }
        for(int i=0;i<3;i++)
        {
            if(field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].equals(""))
            {
                return true;
            }
        }

        if(field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && !field[0][0].equals(""))
        {
            return true;
        }
        if(field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].equals(""))
        {
            return true;
        }

        return false;
    }
        private void player1Wins() {
            player1Points++;
            Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
            resetBoard();
            updatePointsText();
        }
        private void player2Wins() {
            player2Points++;
            Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
            resetBoard();
            updatePointsText();
        }
        private void draw() {
            Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
            resetBoard();
        }

        private void updatePointsText(){
        txtplayer1.setText("Player 1: "+ player1Points);
        txtplayer2.setText("Player 2: "+ player2Points);
        }

        private void resetBoard(){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setText("");
                }
            }

            roundCount = 0;
            player1Turn = true;
        }

        private void resetGame(){
            player1Points = 0;
            player2Points = 0;
            updatePointsText();
            resetBoard();
        }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCount", roundCount);
        outState.putInt("player1Points", player1Points);
        outState.putInt("player2Points", player2Points);
        outState.putBoolean("player1Turn", player1Turn);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        roundCount = savedInstanceState.getInt("roundCount");
        player1Points = savedInstanceState.getInt("player1Points");
        player2Points = savedInstanceState.getInt("player2Points");
        player1Turn = savedInstanceState.getBoolean("player1Turn");
    }
}

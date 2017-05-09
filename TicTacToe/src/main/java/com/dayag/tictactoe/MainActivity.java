package com.dayag.tictactoe;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //define variables for widgets within the app
    private SharedPreferences savedValues;
    private Button square1;
    private Button square2;
    private Button square3;
    private Button square4;
    private Button square5;
    private Button square6;
    private Button square7;
    private Button square8;
    private Button square9;
    private TextView displayText;
    private Button button;
    private int turn;
    private boolean gameOver;
    private Button gameGrid[][];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);

        //get references for the widgets
        square1 = (Button) findViewById(R.id.square1);
        square2 = (Button) findViewById(R.id.square2);
        square3 = (Button) findViewById(R.id.square3);
        square4 = (Button) findViewById(R.id.square4);
        square5 = (Button) findViewById(R.id.square5);
        square6 = (Button) findViewById(R.id.square6);
        square7 = (Button) findViewById(R.id.square7);
        square8 = (Button) findViewById(R.id.square8);
        square9 = (Button) findViewById(R.id.square9);
        button = (Button) findViewById(R.id.button);
        displayText = (TextView) findViewById(R.id.displayText);

        //instance var
        turn = 0;
        gameOver = false;

        //set listeners
        square1.setOnClickListener(this);
        square2.setOnClickListener(this);
        square3.setOnClickListener(this);
        square4.setOnClickListener(this);
        square5.setOnClickListener(this);
        square6.setOnClickListener(this);
        square7.setOnClickListener(this);
        square8.setOnClickListener(this);
        square9.setOnClickListener(this);
        button.setOnClickListener(this);

        //this a 2D array for the gameGrid
        gameGrid = new Button[][]{
                {square1,square2,square3},
                {square4,square5,square6},
                {square7,square8,square9}
        };

        //this is needed for the onpause and onresume
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    @Override
    public void onPause(){
        SharedPreferences.Editor editor = savedValues.edit();

        editor.putString("displayText",displayText.getText().toString());
        editor.putInt("turn", turn);
        editor.putBoolean("gameOver",gameOver);

        editor.putString("1",square1.getText().toString());
        editor.putString("2",square2.getText().toString());
        editor.putString("3",square3.getText().toString());
        editor.putString("4",square4.getText().toString());
        editor.putString("5",square5.getText().toString());
        editor.putString("6",square6.getText().toString());
        editor.putString("7",square7.getText().toString());
        editor.putString("8",square8.getText().toString());
        editor.putString("9",square9.getText().toString());

        editor.commit();
        super.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();

        //this will get the saved state of the app
        //and display it as it is
        displayText.setText(savedValues.getString("displayText",""));
        turn = savedValues.getInt("turn",0);
        gameOver = savedValues.getBoolean("gameOver",false);

        square1.setText(savedValues.getString("1",""));
        square2.setText(savedValues.getString("2",""));
        square3.setText(savedValues.getString("3",""));
        square4.setText(savedValues.getString("4",""));
        square5.setText(savedValues.getString("5",""));
        square6.setText(savedValues.getString("6",""));
        square7.setText(savedValues.getString("7",""));
        square8.setText(savedValues.getString("8",""));
        square9.setText(savedValues.getString("9",""));

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                startNewGame();
                break;
            default:
                if(!gameOver){
                    //checkGame() will return 0 if game is still going,
                    // 1 for X winning, 2 for O winning, 3 for a draw
                    int gameState = 0;
                    Button b = (Button) v;
                    if (turn % 2 == 0 && b.getText().toString().equals("")){
                        b.setText("X");

                        gameState = checkGame();
                        if (gameState == 1 || gameState == 3)
                        {
                            break;
                        }
                        turn ++;
                        displayText.setText("Player O's Turn");
                    }
                    else if (turn % 2 == 1 && b.getText().toString().equals("")){
                        b.setText("O");
                        gameState = checkGame();
                        if (gameState == 2 || gameState == 3)
                        {
                            break;
                        }
                        turn ++;
                        displayText.setText("Player X's Turn");
                    }
                }

                break;
        }

    }

    //check if there's already a winner if not continue until there's a winner
    //1 if X win 2 if O win
    private int checkGame(){

        // if there's an empty square and nobody has won then canPlay is set to true
        boolean canPlay = false;

        //check diagonals
        if ((
                (getSquareState(gameGrid[0][0]) == getSquareState(gameGrid[1][1]) && getSquareState(gameGrid[1][1]) == getSquareState(gameGrid[2][2]))
                        ||
                        (getSquareState(gameGrid[0][2]) == getSquareState(gameGrid[1][1]) && getSquareState(gameGrid[1][1]) == getSquareState(gameGrid[2][0]))
        ) && getSquareState(gameGrid[1][1]) != 0)
        {
            gameOver = true;
            if (getSquareState(gameGrid[1][1]) == 1){
                displayText.setText("Player X Wins!");
                return 1;
            }else {
                displayText.setText("Player O Wins!");
                return 2;
            }
        }

        //check rows and columns
        for(int i = 0; i < 3; i++){

            //check rows
            if (
                    getSquareState(gameGrid[i][0]) == getSquareState(gameGrid[i][1])
                            && getSquareState(gameGrid[i][1]) == getSquareState(gameGrid[i][2])
                            && getSquareState(gameGrid[i][0]) != 0)
            {
                gameOver = true;
                if (getSquareState(gameGrid[i][0]) == 1)
                {
                    displayText.setText("Player X Wins!");
                    return 1;
                }else {
                    displayText.setText("Player O Wins!");
                    return 2;
                }
            }

            //check columns
            if (
                    getSquareState(gameGrid[0][i]) == getSquareState(gameGrid[1][i])
                            && getSquareState(gameGrid[1][i]) == getSquareState(gameGrid[2][i])
                            && getSquareState(gameGrid[0][i]) != 0)
            {
                gameOver = true;
                if (getSquareState(gameGrid[0][i]) == 1){
                    displayText.setText("Player X Wins!");
                    return 1;
                }else {
                    displayText.setText("Player O Wins!");
                    return 2;
                }
            }

            //check boxes state if empty and continue if it is
            for (int j = 0; j < 3; j++){
                if(getSquareState(gameGrid[i][j]) == 0){
                    canPlay = true;
                };
            }
        }
        if(canPlay){
            //if there are still open boxes
            return 0;
        } else{
            //if no one win
            gameOver = true;
            displayText.setText("It's a Draw!");
            return 3;
        }

    }

    private int getSquareState(Button b){
        if (b.getText().toString().equals("X")){
            return 1;
        }
        else if (b.getText().toString().equals("O")){
            return 2;
        }
        else {
            return 0;
        }
    }

    private void startNewGame(){
        turn = 0;
        gameOver = false;
        //X always goes first
        displayText.setText("Player X's Turn");

        //clear the game to start a new one
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                gameGrid[i][j].setText("");
            }
        }
    }

}

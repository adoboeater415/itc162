package com.dayag.tictactoe;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity{

    //define variables for the widgets within the app
    private Button gameGrid[][] = new Button[3][3];
    private Button restartGame;
    private TextView displayText;
    private int turnCount;
    private SharedPreferences savedValues;
    private String a, b, c, d, e, f, g, h, i;
    /*private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private String i = "";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);

        //get the reference fo the widget
        gameGrid[0][0] = (Button) findViewById(R.id.square1);
        gameGrid[0][1] = (Button) findViewById(R.id.square2);
        gameGrid[0][2] = (Button) findViewById(R.id.square3);
        gameGrid[1][0] = (Button) findViewById(R.id.square4);
        gameGrid[1][1] = (Button) findViewById(R.id.square5);
        gameGrid[1][2] = (Button) findViewById(R.id.square6);
        gameGrid[2][0] = (Button) findViewById(R.id.square7);
        gameGrid[2][1] = (Button) findViewById(R.id.square8);
        gameGrid[2][2] = (Button) findViewById(R.id.square9);
        displayText = (TextView) findViewById(R.id.displayText);

        restartGame = (Button) findViewById(R.id.button);

        //this is to determine which player has the turn
        turnCount = 1;

        //this is needed for the onPause and on Resume
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);

    }

    //game method here
    private void setStartingValues(){

        //set the onClickListener when the buttons are clicked repeat this for all the buttons
        gameGrid[0][0].setOnClickListener(new OnClickListener() {

            //as the buttons are pressed set the text to either X or O
            @Override
            public void onClick(View v){

                //first move is always an X
                if(gameGrid[0][0].getText().toString().equals("")){

                    if(turnCount == 1) {

                        turnCount = 2;
                        gameGrid[0][0].setText("X");

                        //set the second move to put O
                    } else {

                        turnCount = 1;
                        gameGrid[0][0].setText("O");

                    }

                }

                //this will check if there is a winner after the button is pressed
                //and will the this function
                checkForWinner();//this needs to be in all of the buttons as well

            }//make sure that this method is repeated in all the buttons

        });//end of button 1

        gameGrid[0][1].setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v){

                if(gameGrid[0][1].getText().toString().equals("")){

                    if(turnCount == 1) {

                        turnCount = 2;
                        gameGrid[0][1].setText("X");

                    } else {

                        turnCount = 1;
                        gameGrid[0][1].setText("O");

                    }

                }

                checkForWinner();

            }

        });//end of button 2

        gameGrid[0][2].setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v){

                if(gameGrid[0][2].getText().toString().equals("")){

                    if(turnCount == 1) {

                        turnCount = 2;
                        gameGrid[0][2].setText("X");

                    } else {

                        turnCount = 1;
                        gameGrid[0][2].setText("O");

                    }

                }

                checkForWinner();

            }

        });//end of button 3

        gameGrid[1][0].setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v){

                if(gameGrid[1][0].getText().toString().equals("")){

                    if(turnCount == 1) {

                        turnCount = 2;
                        gameGrid[1][0].setText("X");

                    } else {

                        turnCount = 1;
                        gameGrid[1][0].setText("O");

                    }

                }

                checkForWinner();

            }

        });//end of button 4

        gameGrid[1][1].setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v){

                if(gameGrid[1][1].getText().toString().equals("")){

                    if(turnCount == 1) {

                        turnCount = 2;
                        gameGrid[1][1].setText("X");

                    } else {

                        turnCount = 1;
                        gameGrid[1][1].setText("O");

                    }

                }

                checkForWinner();

            }

        });//end of button 5

        gameGrid[1][2].setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v){

                if(gameGrid[1][2].getText().toString().equals("")){

                    if(turnCount == 1) {

                        turnCount = 2;
                        gameGrid[1][2].setText("X");

                    } else {

                        turnCount = 1;
                        gameGrid[1][2].setText("O");

                    }

                }

                checkForWinner();

            }

        });//end of button 6

        gameGrid[2][0].setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v){

                if(gameGrid[2][0].getText().toString().equals("")){

                    if(turnCount == 1) {

                        turnCount = 2;
                        gameGrid[2][0].setText("X");

                    } else {

                        turnCount = 1;
                        gameGrid[2][0].setText("O");

                    }

                }

                checkForWinner();

            }

        });//end of button 7

        gameGrid[2][1].setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v){

                if(gameGrid[2][1].getText().toString().equals("")){

                    if(turnCount == 1) {

                        turnCount = 2;
                        gameGrid[2][1].setText("X");

                    } else {

                        turnCount = 1;
                        gameGrid[2][1].setText("O");

                    }

                }

                checkForWinner();

            }

        });//end of button 8

        gameGrid[2][2].setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v){

                if(gameGrid[2][2].getText().toString().equals("")){

                    if(turnCount == 1) {

                        turnCount = 2;
                        gameGrid[2][2].setText("X");

                    } else {

                        turnCount = 1;
                        gameGrid[2][2].setText("O");

                    }

                }

                checkForWinner();

            }

        });//end of button 9

        //this button is to reset the grid and delete the string
        restartGame.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                //this is the method that will delete the button's string
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish ();

            }

        });//end of the reset button

    }//end of startSettingValues

    @Override
    public void onPause() {
        //save the instance variables
        SharedPreferences.Editor editor = savedValues.edit();
        editor.putString("gameGrid[0][0]", a);
        editor.putString("gameGrid[0][1]", b);
        editor.putString("gameGrid[0][2]", c);
        editor.putString("gameGrid[1][0]", d);
        editor.putString("gameGrid[1][1]", e);
        editor.putString("gameGrid[1][2]", f);
        editor.putString("gameGrid[2][0]", g);
        editor.putString("gameGrid[2][1]", h);
        editor.putString("gameGrid[2][2]", i);
        editor.commit();

        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        //get the instance variables
        a = savedValues.getString("a", "");
        b = savedValues.getString("b", "");
        c = savedValues.getString("c", "");
        d = savedValues.getString("d", "");
        e = savedValues.getString("e", "");
        f = savedValues.getString("f", "");
        g = savedValues.getString("g", "");
        h = savedValues.getString("h", "");
        i = savedValues.getString("i", "");

        gameGrid[0][0].setText(a);
        gameGrid[0][1].setText(b);
        gameGrid[0][2].setText(c);
        gameGrid[1][0].setText(d);
        gameGrid[1][1].setText(e);
        gameGrid[1][2].setText(f);
        gameGrid[2][0].setText(g);
        gameGrid[2][1].setText(h);
        gameGrid[2][2].setText(i);

        setStartingValues();
    }

    //this will check if there's a winner and end the game
    private void checkForWinner(){

        //conditional for disabling the buttons to prevent players from trying
        //to make a move once the game is completed
        boolean end = false;

        //set the gameGrid buttons to string
        a = gameGrid[0][0].getText().toString();
        b = gameGrid[0][1].getText().toString();
        c = gameGrid[0][2].getText().toString();
        d = gameGrid[1][0].getText().toString();
        e = gameGrid[1][1].getText().toString();
        f = gameGrid[1][2].getText().toString();
        g = gameGrid[2][0].getText().toString();
        h = gameGrid[2][1].getText().toString();
        i = gameGrid[2][2].getText().toString();

        //check for three horizontal starting with X
        if(a.equals("X") && b.equals("X") && c.equals("X")){

            displayText.setText("Player One Wins!");
            end = true;

        } if(d.equals("X") && e.equals("X") && f.equals("X")){

            displayText.setText("Player One Wins!");
            end = true;

        } if(g.equals("X") && h.equals("X") && i.equals("X")){

            displayText.setText("Player One Wins!");
            end = true;

        }//end of X horizontal

        if(a.equals("O") && b.equals("O") && c.equals("O")){

            displayText.setText("Player Two Wins!");
            end = true;

        } if(d.equals("O") && e.equals("O") && f.equals("O")){

            displayText.setText("Player Two Wins!");
            end = true;

        } if(g.equals("O") && h.equals("O") && i.equals("O")){

            displayText.setText("Player Two Wins!");
            end = true;

        } // end of O horizontal

        //check for three vertical starting with X
        if(a.equals("X") && d.equals("X") && g.equals("X")){

            displayText.setText("Player One Wins!");
            end = true;

        }  if(b.equals("X") && e.equals("X") && h.equals("X")){

            displayText.setText("Player One Wins!");
            end = true;

        } if(c.equals("X") && f.equals("X") && i.equals("X")){

            displayText.setText("Player One Wins!");
            end = true;

        }//end of X vertical

        if(a.equals("O") && d.equals("O") && g.equals("O")){

            displayText.setText("Player Two Wins!");
            end = true;

        } if(b.equals("O") && e.equals("O") && h.equals("O")){

            displayText.setText("Player Two Wins!");
            end = true;

        } if(c.equals("O") && f.equals("O") && i.equals("O")){

            displayText.setText("Player Two Wins!");
            end = true;

        }//end of O vertical


        //check for two diagonal starting with X
        if(a.equals("X") && e.equals("X") && i.equals("X")){

            displayText.setText("Player One Wins!");
            end = true;

        } if(g.equals("X") && e.equals("X") && c.equals("X")){

            displayText.setText("Player One Wins!");
            end = true;

        }//end of X diagonal

        if(a.equals("O") && e.equals("O") && i.equals("O")){

            displayText.setText("Player Two Wins!");
            end = true;

        } if(g.equals("O") && e.equals("O") && c.equals("O")){

            displayText.setText("Player One Wins!");
            end = true;

        }//end of O diagonal

        //if false ned the game
        if(end) {
            gameGrid[0][0].setEnabled(false);
            gameGrid[0][1].setEnabled(false);
            gameGrid[0][2].setEnabled(false);
            gameGrid[1][0].setEnabled(false);
            gameGrid[1][1].setEnabled(false);
            gameGrid[1][2].setEnabled(false);
            gameGrid[2][0].setEnabled(false);
            gameGrid[2][1].setEnabled(false);
            gameGrid[2][2].setEnabled(false);

        }

        /* this is currently not doing what I want it to do,
        if(end != true || false){

            //notify if there is no winner
            displayText.setText("It's a draw!!");

        }
        uncomment this as soon as it is working or delete the whole function before submission
        */

    }

}
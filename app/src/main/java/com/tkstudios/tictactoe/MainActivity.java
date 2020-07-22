package com.tkstudios.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    boolean stop = false;
    int count =0;
    int sum=0;

    // 0-X
    // 1-O
    int CurrentPlayer = 1;
    int[] GameState = {2,2,2,2,2,2,2,2,2};
    int[][] WinningPositions = {{0,1,2} , {3,4,5} , {6,7,8},
                                {0,3,6} , {1,4,7} , {2,5,8},
                                {0,4,8} , {2,4,6}};




    public void PlayerTap (View view) {
        ImageView img = (ImageView) view;
        int Position = Integer.parseInt(img.getTag().toString());
        TextView status = (TextView)findViewById(R.id.status);



        if (stop == false) {

            if (GameState[Position] == 2) {
                GameState[Position] = CurrentPlayer;
                img.setTranslationY(-1000f);
                if (CurrentPlayer == 0) {
                    CurrentPlayer = 1;
                    img.setImageResource(R.drawable.x);
                    status.setText("O's turn to play");



                } else {
                    CurrentPlayer = 0;
                    img.setImageResource(R.drawable.o);
                    status.setText("X's turn to play");

                }
                count++;
                img.animate().translationYBy(1000f).setDuration(300);

            }

            if(count>=5){
            for (int[] winPosition : WinningPositions) {
                if (GameState[winPosition[0]] == GameState[winPosition[1]] &&
                        GameState[winPosition[1]] == GameState[winPosition[2]] &&
                        GameState[winPosition[0]] != 2) {


                    String winnerStr;
                    stop = true;
                    if (GameState[winPosition[0]] == 0) {
                        Toast.makeText(this, "The game has ended", Toast.LENGTH_LONG).show();
                        winnerStr = "X has won";
                    } else {
                        winnerStr = "O has won";
                        Toast.makeText(this, "The game has ended", Toast.LENGTH_LONG).show();
                    }
                    // Update the status bar for winner announcement
                    status.setText(winnerStr);

                }

                else if(count == 9 && sum == 4){
                    status.setText("It's a draw! Play again :)");
                    stop = true;
                }
                sum++;
            }
        }
      }
    }

    public void resetGame(View view){
        stop = false;
        count = 0;
        CurrentPlayer = 0;
        TextView status = (TextView)findViewById(R.id.status);
        status.setText("X's turn to play");
        for(int i=0;i<GameState.length;i++){
            GameState[i]=2;
          }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }


        public void changeName(View view){

        Intent namechanger = new Intent(this,BasicOpening.class);
        startActivity(namechanger);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            TextView displayp1 = (TextView)findViewById(R.id.displayp1);
            TextView displayp2 = (TextView)findViewById(R.id.displayp2);

            Intent intent = getIntent();

            String player1 = intent.getStringExtra("playern1");
            String player2 = intent.getStringExtra("playern2");

            displayp1.setText(player1);
            displayp2.setText(player2);

            TextView status = (TextView)findViewById(R.id.status);
            status.setText("O's turn to play");
        }


    }
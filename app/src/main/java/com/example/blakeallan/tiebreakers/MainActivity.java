package com.example.blakeallan.tiebreakers;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    int wins = 0;
    int losses = 0;
    int ties = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rockButton = (Button) findViewById(R.id.rockButton);
        Button paperButton = (Button) findViewById(R.id.paperButton);
        Button scissorsButton = (Button) findViewById(R.id.scissorsButton);

        final TextView playerChoice = (TextView) findViewById(R.id.playerChoice);
        final ImageView playerChoiceImage = (ImageView) findViewById(R.id.imageViewPLayerChoice);

        final RPSGameRules game = new RPSGameRules();


        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice.setText("You Chose: Rock");
                int cpuChoice = game.cpuChoice();
                showWinner(game.getWinner(cpuChoice, 1));
                setCpuChoiceLabel(cpuChoice);
                playerChoiceImage.setImageResource(R.drawable.rock);


            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice.setText("You Chose: Paper");
                int cpuChoice = game.cpuChoice();
                showWinner(game.getWinner(cpuChoice, 2));
                setCpuChoiceLabel(cpuChoice);
                playerChoiceImage.setImageResource(R.drawable.paper);
            }
        });

        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice.setText("You Chose: Scissors");
                int cpuChoice = game.cpuChoice();
                showWinner(game.getWinner(cpuChoice, 3));
                setCpuChoiceLabel(cpuChoice);
                playerChoiceImage.setImageResource(R.drawable.scissors);
            }
        });
    }

    public void setCpuChoiceLabel(int cpuChoice){

        final ImageView cpuChoiceImage = (ImageView) findViewById(R.id.imageViewCompChoice);
        TextView compChoice = (TextView) findViewById(R.id.compChoice);

        if (cpuChoice == 1){
            compChoice.setText("Computer Chose: Rock");
            cpuChoiceImage.setImageResource(R.drawable.rock);
        }
        if (cpuChoice == 2){
            compChoice.setText("Computer Chose: Paper");
            cpuChoiceImage.setImageResource(R.drawable.paper);
        }
        if (cpuChoice == 3){
            compChoice.setText("Computer Chose: Scissors");
            cpuChoiceImage.setImageResource(R.drawable.scissors);
        }
    }

    public void showWinner(int result) {

        TextView winCount = (TextView) findViewById(R.id.winCount);
        TextView lossCount = (TextView) findViewById(R.id.lossCount);
        TextView tieCount = (TextView) findViewById(R.id.tieCount);



        TextView gameOutcome = (TextView) findViewById(R.id.gameOutcome);

        if (result == 1){
            wins ++;
            gameOutcome.setText("YOU WON!");
            winCount.setText("Wins: " + wins);
        }
        else if (result == 2){
            losses ++;
            gameOutcome.setText("Computer Won");
            lossCount.setText("Losses: " + losses);
        }
        else if(result == 3){
            ties ++;
            gameOutcome.setText("It Was a Tie");
            tieCount.setText("Ties: " + ties);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

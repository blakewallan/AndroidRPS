package com.example.blakeallan.tiebreakers;


/**
 * Created by blakeallan on 5/15/15.
 */

public class RPSGameRules {

    public int getWinner(int computerChoice, int playerChoice) {

        //If statements that return false if computer wins & true if player wins
        if (computerChoice == 1 && playerChoice == 2){
            return 1;
        }
        if (computerChoice == 2 && playerChoice == 3){
            return 1;
        }
        if (computerChoice == 3 && playerChoice == 1){
            return 1;
        }
        if (computerChoice == playerChoice){
            return 3;
        }
        else {
            return 2;
        }
    }

    public int cpuChoice() {
        return (int) (Math.random() * (4 - 1) + 1);
    }

}


package edu.ithaca.dragon.pathfinding;

import java.util.Scanner;

import edu.ithaca.dragon.pathfinding.areagrid.AreaGrid;
import edu.ithaca.dragon.pathfinding.areagrid.AreaGridFactory;
import edu.ithaca.dragon.pathfinding.challenge.FindItemChallenge;
import edu.ithaca.dragon.pathfinding.pathfinder.NextStepChooser;
import edu.ithaca.dragon.pathfinding.pathfinder.RandomNextStepChooser;

public class FindItemChallengeMain {

    public static void runInteractiveChallenge(AreaGrid grid, NextStepChooser nextStepChooser){
        Scanner keyboard = new Scanner(System.in);
        FindItemChallenge challenge = new FindItemChallenge(nextStepChooser, grid);
        while(!challenge.challengeCompleted()){
            challenge.challengeStep();
            System.out.println(challenge.getSteps());
            System.out.println(challenge.createDisplayString());
            System.out.print("Enter to continue:");
            keyboard.nextLine();
        }
        keyboard.close();
    }
    
    public static void main(String[] args){
        AreaGrid tinyGrid = AreaGridFactory.createPerfectMaze(11, 11);
        // AreaGrid smallGrid = AreaGridFactory.createPerfectMaze(21, 21);
        // AreaGrid openSmallGrid = AreaGridFactory.createLoopyMaze(21, 21, 0.5);
        runInteractiveChallenge(tinyGrid, new RandomNextStepChooser());
    }
}

package edu.ithaca.dragon.pathfinding.challenge;

import java.util.List;

import edu.ithaca.dragon.pathfinding.areagrid.AreaGrid;
import edu.ithaca.dragon.pathfinding.areagrid.AreaGridFactory;
import edu.ithaca.dragon.pathfinding.areagrid.Location;
import edu.ithaca.dragon.pathfinding.pathfinder.NextStepChooser;

public class FindItemChallenge {

    private AreaGrid grid;
    private Location itemLocation;
    private FindItemParticipant participant;
    private long steps;

    public FindItemChallenge(NextStepChooser pathFinder){
        this(pathFinder, AreaGridFactory.createPerfectMaze(21, 21));
    }

    public FindItemChallenge(NextStepChooser pathFinder, AreaGrid grid){
        this(pathFinder, grid, grid.pickRandomOpenLocation(), grid.pickRandomOpenLocation());
    } 
    
    public FindItemChallenge(NextStepChooser pathFinder, AreaGrid grid, Location startLocation, Location itemLocation){
        this.grid = new AreaGrid(grid.gridCopy());
        this.itemLocation = itemLocation;
        participant = new FindItemParticipant(startLocation, pathFinder);
        steps=0;
    }
    
    public void challengeStep(){
        Location chosenMove = participant.chooseNextStep(grid.createLocalGridView(participant.getLocation()));
        if (!chosenMove.isWall()){
            participant.setLocation(chosenMove);
        }
        steps++;
    }

    public void completeChallenge(boolean displaySteps){
        while(!challengeCompleted()){
            challengeStep();
            if (displaySteps){
                System.out.println(steps);
                System.out.println(createDisplayString());
            }
        }
    }

    public boolean challengeCompleted(){
        return participant.getLocation().equals(itemLocation);
    }

    public String createDisplayString() {
        String gridDisplay = "";
        for (List<Location> row: grid.gridCopy()){
            for (Location location : row) {
                if (location.equals(participant.getLocation())){
                    gridDisplay += "*";
                }
                else if (location.equals(itemLocation)){
                    gridDisplay += "x";
                }
                else {
                    gridDisplay += location.buildDisplayString();
                }
            }
            gridDisplay += "\n";
        }
        return gridDisplay;
    }

    public long getSteps(){
        return steps;
    }
    
}

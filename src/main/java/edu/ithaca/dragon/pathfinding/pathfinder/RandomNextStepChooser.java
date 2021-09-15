package edu.ithaca.dragon.pathfinding.pathfinder;

import java.util.Random;

import edu.ithaca.dragon.pathfinding.areagrid.LocalGridView;
import edu.ithaca.dragon.pathfinding.areagrid.Location;

public class RandomNextStepChooser implements NextStepChooser {
    Random random = new Random();

    @Override
    public Location chooseNextStep(LocalGridView localGridView) {
        return localGridView.surroundingLocations().get(random.nextInt(localGridView.surroundingLocations().size()));
    }
}

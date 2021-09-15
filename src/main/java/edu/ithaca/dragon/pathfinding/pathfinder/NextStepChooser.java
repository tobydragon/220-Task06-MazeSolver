package edu.ithaca.dragon.pathfinding.pathfinder;

import edu.ithaca.dragon.pathfinding.areagrid.LocalGridView;
import edu.ithaca.dragon.pathfinding.areagrid.Location;

public interface NextStepChooser {

    Location chooseNextStep(LocalGridView localGridView);
}

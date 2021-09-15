package edu.ithaca.dragon.pathfinding.challenge;

import edu.ithaca.dragon.pathfinding.areagrid.LocalGridView;
import edu.ithaca.dragon.pathfinding.areagrid.Location;
import edu.ithaca.dragon.pathfinding.pathfinder.NextStepChooser;

public class FindItemParticipant {
    private Location location;
    private NextStepChooser nextStepChooser;
	
	public FindItemParticipant(Location location, NextStepChooser pathChooser) {
		this.location = location;
		this.nextStepChooser = pathChooser;
	}

    public Location getLocation() {
		return location;
	}
    
	public void setLocation(Location location) {
		this.location = location;
	}

    public Location chooseNextStep(LocalGridView localGridView){
        return nextStepChooser.chooseNextStep(localGridView);
    }

}

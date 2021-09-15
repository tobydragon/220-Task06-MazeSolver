package edu.ithaca.dragon.pathfinding.areagrid;

import java.util.List;

public class LocalGridView {
    
    private Location currentLocation;
    private List<Location> surroundingLocations;

    public LocalGridView(Location currentLocation, List<Location> surroundingLocations) {
        this.currentLocation = currentLocation;
        this.surroundingLocations = surroundingLocations;
    }

    public Location currentLocation() {
        return currentLocation;
    }

    public List<Location> surroundingLocations() {
        return surroundingLocations;
    }
}

package main.action;


import main.model.DIRECTION;
import main.model.Vehicle;

import java.util.Map;
import java.util.Properties;

import static java.util.Map.entry;

/**
 * Uses the map to decide which direction is RIGHT
 */
public class TurnRight implements Command {
    Map<String, String> rightMap = Map.ofEntries(
            entry(DIRECTION.EAST.name(), DIRECTION.SOUTH.name()),
            entry(DIRECTION.WEST.name(), DIRECTION.NORTH.name()),
            entry(DIRECTION.SOUTH.name(), DIRECTION.WEST.name()),
            entry(DIRECTION.NORTH.name(), DIRECTION.EAST.name())
    );

    @Override
    public void act(Vehicle bike, Properties prop) {
        bike.setDirection(rightMap.get(bike.getDirection()));
    }
}
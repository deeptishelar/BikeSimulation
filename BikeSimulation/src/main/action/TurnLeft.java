package main.action;

import main.model.DIRECTION;
import main.model.Vehicle;

import java.util.Map;
import java.util.Properties;

import static java.util.Map.entry;

/**
 * Uses the map to decide which direction is LEFT
 */
public class TurnLeft implements Command {
    Map<String, String> leftMap = Map.ofEntries(
            entry(DIRECTION.EAST.name(), DIRECTION.NORTH.name()),
            entry(DIRECTION.WEST.name(), DIRECTION.SOUTH.name()),
            entry(DIRECTION.SOUTH.name(), DIRECTION.EAST.name()),
            entry(DIRECTION.NORTH.name(), DIRECTION.WEST.name())
    );

    @Override
    public void act(Vehicle bike, Properties prop) {
        bike.setDirection(leftMap.get(bike.getDirection()));
    }
}
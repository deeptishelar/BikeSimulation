package main.action;


import main.model.Bike;
import main.model.DIRECTION;

import java.util.Map;
import java.util.Properties;

import static java.util.Map.entry;

public class TurnRight implements Command{
    Map<String, String> rightMap = Map.ofEntries(
            entry(DIRECTION.EAST.name(), DIRECTION.SOUTH.name()),
            entry(DIRECTION.WEST.name(), DIRECTION.NORTH.name()),
            entry(DIRECTION.SOUTH.name(), DIRECTION.WEST.name()),
            entry(DIRECTION.NORTH.name(), DIRECTION.EAST.name())
    );
    @Override
    public void act(Bike bike, Properties prop) {
        if(bike.isInitiated())
        {
            bike.setDirection(rightMap.get(bike.getDirection()));
        }
    }
}
package main.action;


import main.model.Bike;
import main.model.DIRECTION;

import java.util.Properties;

public class Forward implements Command{

    @Override
    public void act(Bike bike, Properties prop) {

        int maxLimit = Integer.parseInt(prop.getProperty("GRID_MAX"));
        int minLimit = Integer.parseInt(prop.getProperty("GRID_MIN"));
        if (bike.isInitiated()) {
            if (bike.getX() < maxLimit-1 && DIRECTION.EAST.name().equals(bike.getDirection())) {
                bike.setX(bike.getX() + 1);
            } else if (bike.getX() > minLimit && DIRECTION.WEST.name().equals(bike.getDirection())) {
                bike.setX(bike.getX() - 1);
            } else if (bike.getY() > minLimit && DIRECTION.SOUTH.name().equals(bike.getDirection())) {
                bike.setY(bike.getY() - 1);
            } else if (bike.getY() < maxLimit-1 && DIRECTION.NORTH.name().equals(bike.getDirection())) {
                bike.setY(bike.getY() + 1);
            }
        }

    }

}
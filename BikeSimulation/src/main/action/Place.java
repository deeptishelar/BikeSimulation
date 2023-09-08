package main.action;


import main.model.Vehicle;

import java.util.Properties;

/**
 * Default placing is already taken place, can be added here is any specifics
 */
public class Place implements Command{

    @Override
    public void act(Vehicle bike, Properties prop) {

//        System.out.println("Place : " + bike);
    }

}

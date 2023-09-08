package main.action;


import main.model.Vehicle;

import java.util.Properties;

/**
 * Prints the GSP report
 */
public class GpsReport implements Command{
    @Override
    public void act(Vehicle bike, Properties prop) {

        System.out.println("\n\nOUTPUT : \n"+  bike);
    }
}

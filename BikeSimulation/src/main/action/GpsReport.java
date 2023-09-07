package main.action;


import main.model.Bike;

import java.util.Properties;

public class GpsReport implements Command{
    @Override
    public void act(Bike bike, Properties prop) {

        System.out.println("\n\nOUTPUT : \n"+  bike);
    }
}

package main.action;


import main.model.Bike;

import java.util.Properties;

public interface Command {
    public void act(Bike bike, Properties prop);
}

package main.action;


import main.model.Vehicle;

import java.util.Properties;

/**
 * Enables loose coupling of the actions and the controller
 * If a new command is introduced, provide the implementation and add an entry in properties file
 */
public interface Command {
    void act(Vehicle bike, Properties prop);
}

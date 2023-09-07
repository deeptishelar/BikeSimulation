package main.model;


import main.action.Command;

import java.util.Properties;

public class Bike {

    int x;
    int y;
    String direction;
    String command;

    public boolean isInitiated() {
        return initiated;
    }

    boolean initiated;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }


    public void setValues(String input) {
        String[] args = input.split(",");
        this.setX(Integer.parseInt(args[0]));
        this.setY(Integer.parseInt(args[1]));
        this.setDirection(args[2]);
    }


    public void move(Properties prop) {
        try {
            if (this.initiated) {
                Command command = (Command) Class.forName(this.command)
                        .getConstructor()
                        .newInstance();
                command.act(this, prop);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void setInitiated(boolean b) {
        initiated = b;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ") " + direction;
    }
}

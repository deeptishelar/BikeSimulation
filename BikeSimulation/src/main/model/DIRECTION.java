package main.model;

public enum DIRECTION {
    EAST, WEST, SOUTH, NORTH;

    public String toString(){
        switch(this){
            case EAST :
                return "EAST";
            case WEST :
                return "WEST";
            case SOUTH :
                return "SOUTH";
            case NORTH :
                return "NORTH";
        }
        return null;
    }
}

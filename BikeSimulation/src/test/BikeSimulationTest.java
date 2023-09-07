package test;

import main.BikeSimulationController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BikeSimulationTest {
    BikeSimulationController bikeSimulationController = new BikeSimulationController();

    @Test
    public void test() {
        bikeSimulationController.executeCommandFile("src/resources/commands.txt");
        assertEquals("(3,3) NORTH",bikeSimulationController.gpsReport());
    }
    @Test
    public void test1() {
        bikeSimulationController.executeCommandFile("src/resources/commands1.txt");
        assertEquals("(4,4) NORTH",bikeSimulationController.gpsReport());
    }
    @Test
    public void test2() {
        bikeSimulationController.executeCommandFile("src/resources/commands2.txt");
        assertEquals("(0,0) WEST",bikeSimulationController.gpsReport());
    }
    @Test
    public void test3() {
        bikeSimulationController.executeCommandFile("src/resources/commands3.txt");
        assertEquals("(0,6) NORTH",bikeSimulationController.gpsReport());
    }
    @Test
    public void test4() {
        bikeSimulationController.executeCommandFile("src/resources/commands4.txt");
        assertEquals("(3,3) NORTH",bikeSimulationController.gpsReport());
    }
    @Test
    public void test5() {
        bikeSimulationController.executeCommandFile("");
//        assertEquals("(3,3) NORTH",bikeSimulationController.gpsReport());
    }
}

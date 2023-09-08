package test;

import main.SimulationController;
import main.model.Bike;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BikeSimulationTest {
    SimulationController bikeSimulationController = new SimulationController(new Bike());

    @Test
    public void test() {
        bikeSimulationController.executeCommandFile("./BikeSimulation/src/resources/commands.txt");
        assertEquals("(3,3) NORTH",bikeSimulationController.gpsReport());
    }
    @Test
    public void test1() {
        bikeSimulationController.executeCommandFile("./BikeSimulation/src/resources/commands1.txt");
        assertEquals("(0,0) null",bikeSimulationController.gpsReport());
    }
    @Test
    public void test2() {
        bikeSimulationController.executeCommandFile("./BikeSimulation/src/resources/commands2.txt");
        assertEquals("(0,0) WEST",bikeSimulationController.gpsReport());
    }
    @Test
    public void test3() {
        bikeSimulationController.executeCommandFile("./BikeSimulation/src/resources/commands3.txt");
        assertEquals("(0,6) NORTH",bikeSimulationController.gpsReport());
    }
    @Test
    public void test4() {
        bikeSimulationController.executeCommandFile("./BikeSimulation/src/resources/commands4.txt");
        assertEquals("(3,3) NORTH",bikeSimulationController.gpsReport());
    }
    @Test
    public void test5() {
        bikeSimulationController.executeCommandFile("");
        assertEquals("(0,0) null",bikeSimulationController.gpsReport());
    }
}

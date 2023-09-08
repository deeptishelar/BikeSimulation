package main;

import main.model.Bike;

import java.util.Scanner;

/**
 * Client App to ignite the simulator.
 * Accepts the filename as a command line input, parses the commands and simulates the actions
 */
public class SimulationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file name with path: ");
        String filename = scanner.nextLine();
        if (!filename.isEmpty()) {
            SimulationController controller = new SimulationController(new Bike());
            controller.executeCommandFile(filename);
        } else {
            System.out.println("Please supply an input file");
        }
    }
}

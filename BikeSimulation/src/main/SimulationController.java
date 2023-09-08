package main;


import main.model.Vehicle;

import java.io.*;
import java.util.Properties;

/**
 * represents IoC - Inversion of control.
 * Vehicle can be any vehicle (eg Car) in the future.
 * The consumer will pass the instance and the controller will place the calls appropriately
 */
public class SimulationController {
    /**
     * instance variable enables us to inject dependency
     */
    Vehicle vehicle;

    /**
     * Dependency injection via constructor.
     *
     * @param vehicle eg bike
     */
    public SimulationController(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    private static final String propFile = "resources/application.properties";


    /**
     * Parses the input file and executes the commands listed if valid else ignored
     *
     * @param inputFile file name
     */
    public void executeCommandFile(String inputFile) {
        if (inputFile == null || inputFile.isEmpty()) {
            System.out.println("Please supply an input file");
            return;
        }
        BufferedReader br;
        try {
            Properties prop = getProperties();
            br = new BufferedReader(new FileReader(inputFile));
            String line = br.readLine();
            System.out.println("INPUT:");

            while (line != null) {
                System.out.println(line);
                if (CommandValidator.isValidCommand(line, prop)) {
                    String[] inputs = line.split(" ");
                    String inputCommand = inputs[0];
                    vehicle.setCommand(prop.getProperty(inputCommand));
                    if (inputCommand.equals(prop.getProperty("FIRST_VALID_MOVE")))
                        vehicle.setInitiated(true);
                    if (inputs.length == 2)
                        vehicle.setValues(inputs[1]);
                    if (vehicle.isInitiated())
                        vehicle.move(prop);
                } else {
                    System.out.println("Command " + line + " is ignored");
                }
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("File not found : " + inputFile);
        }
    }

    /**
     * Used in test cases to use the output in assert checks
     *
     * @return String output
     */

    public String gpsReport() {
        return vehicle.toString();
    }

    /**
     * Load the application.properties file
     *
     * @return Properties
     */
    private static Properties getProperties() throws IOException {
        InputStream input = getFileFromResourceAsStream();
        Properties prop = new Properties();
        prop.load(input);
        return prop;
    }

    /**
     * reads the properties
     * @return stream to prop file
     */
    private static InputStream getFileFromResourceAsStream() {

        // The class loader that loaded the class
        ClassLoader classLoader = SimulationController.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(SimulationController.propFile);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + SimulationController.propFile);
        } else {
            return inputStream;
        }
    }
}



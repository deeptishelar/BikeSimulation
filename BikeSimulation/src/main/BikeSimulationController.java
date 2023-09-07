package main;


import main.model.Bike;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class BikeSimulationController {
    static Bike bike;
    private static final String propFile = "resources/application.properties";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file name with path: ");
        String filename = scanner.nextLine();
        if (!filename.isEmpty()) {
            executeCommandFile(filename);
        } else {
            System.out.println("Please supply an input file");
        }
    }

    public static void executeCommandFile(String inputFile) {
        if (inputFile == null || inputFile.isEmpty()) {
            System.out.println("Please supply an input file");
            return;
        }
        BufferedReader br;
        try {
            Properties prop = getProperties();
            br = new BufferedReader(new FileReader(inputFile));
            String line = br.readLine();
            bike = new Bike();
            System.out.println("INPUT:");

            while (line != null) {
                System.out.println(line);
                if (CommandValidator.isValidCommand(line, prop)) {
                    String[] inputs = line.split(" ");
                    String inputCommand = inputs[0];
                    bike.setCommand(prop.getProperty(inputCommand));
                    if (inputCommand.equals(prop.getProperty("FIRST_VALID_MOVE")))
                        bike.setInitiated(true);
                    if (inputs.length == 2)
                        bike.setValues(inputs[1]);
                    if (bike.isInitiated())
                        bike.move(prop);
                } else {
                    System.out.println("Command " + line + " is ignored");
                }
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("File not found : " + inputFile);
        }
    }

    public String gpsReport() {
        return bike.toString();
    }

    private static Properties getProperties() throws IOException {
        InputStream input = getFileFromResourceAsStream();
        Properties prop = new Properties();
        prop.load(input);
        return prop;
    }
    private static InputStream getFileFromResourceAsStream() {

        // The class loader that loaded the class
        ClassLoader classLoader = BikeSimulationController.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(BikeSimulationController.propFile);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + BikeSimulationController.propFile);
        } else {
            return inputStream;
        }

    }
}



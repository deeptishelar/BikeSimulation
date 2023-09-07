package main;

import main.model.COMMANDS;
import main.model.DIRECTION;

import java.util.Arrays;
import java.util.Properties;

public class CommandValidator {
    private static boolean isValidPlace(String input, Properties prop) {
        boolean isValid;
        String[] args = input.split(",");
        if (args.length != 3)
            isValid = false;
        else try {
            int maxLimit = Integer.parseInt(prop.getProperty("GRID_MAX"));
            int minLimit = Integer.parseInt(prop.getProperty("GRID_MIN"));
            int x = Integer.parseInt(args[0]);

            int y = Integer.parseInt(args[1]);
            isValid = x < maxLimit && x >= minLimit && y >= minLimit && y < maxLimit;
            if (isValid)
                isValid = Arrays.stream(DIRECTION.values()).map(DIRECTION::toString)
                        .anyMatch(args[2]::equals);
        } catch (NumberFormatException exc) {
//            System.out.println("Please enter valid coordinates");
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidCommand(String line, Properties prop) {
        boolean isValid = false;
        if (line != null && !line.isEmpty()) {
            String[] inputs = line.split(" ");
            String inputCommand = inputs[0];
            for (COMMANDS cmd : COMMANDS.values()) {
                if (cmd.name().equals(inputCommand)) {
                    switch (cmd) {
                        case PLACE -> {
                            if (inputs.length == 2)
                                isValid = isValidPlace(inputs[1], prop);
                        }
                        default -> isValid = true;
                    }
                }
            }
        }
        return isValid;
    }
}

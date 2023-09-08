package main;

import main.model.COMMANDS;
import main.model.DIRECTION;

import java.util.Arrays;
import java.util.Properties;

/**
 * Validates the following wrt commands
 * -COMMAND name
 * -x and y cordinates
 * -direction
 * -Grid limits
 */
public class CommandValidator {
    /**
     * checks if PLACE command is supplied with valid arguments
     * @param input command
     * @param prop properties
     * @return flag is valid
     */
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
    /**
     * checks if the input command is valid as per the requirements.
     * Enum command holds all the valid commands
     * @param line command
     * @param prop properties
     * @return flag is valid
     */
    public static boolean isValidCommand(String line, Properties prop) {
        boolean isValid = false;
        if (line != null && !line.isEmpty()) {
            String[] inputs = line.split(" ");
            String inputCommand = inputs[0];
            for (COMMANDS cmd : COMMANDS.values()) {
                if (cmd.name().equals(inputCommand)) {
                    if (cmd == COMMANDS.PLACE) {
                        if (inputs.length == 2)
                            isValid = isValidPlace(inputs[1], prop);
                    } else {
                        isValid = true;
                    }
                }
            }
        }
        return isValid;
    }
}

package fr.lacombe.rover;

import java.util.Collections;

import static fr.lacombe.rover.Command.LEFT;
import static fr.lacombe.rover.Command.RIGHT;

class MarsRoverApplication {

    public static void main(final String[] commands) {
        Rover rover = new Rover();

        System.out.println("Initial state: " + rover);

        for (final String command : commands) {
            if (command.equals("L"))
                rover = rover.receive(Collections.singletonList(LEFT));
            else if (command.equals("R"))
                rover = rover.receive(Collections.singletonList(RIGHT));
            else
                System.err.println("Unknown rover command has been ignored: " + command);
        }

        System.out.println("Final state: " + rover);
    }
}

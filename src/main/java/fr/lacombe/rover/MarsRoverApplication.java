package fr.lacombe.rover;

import static fr.lacombe.rover.OrientationCommand.LEFT;
import static fr.lacombe.rover.OrientationCommand.RIGHT;

class MarsRoverApplication {

    public static void main(final String[] commands) {
        Rover rover = new Rover();

        System.out.println("Initial state: " + rover);

        for (final String command : commands) {
            if (command.equals("L"))
                rover = rover.turn(LEFT);
            else if (command.equals("R"))
                rover = rover.turn(RIGHT);
            else
                System.err.println("Unknown rover command has been ignored: " + command);
        }

        System.out.println("Final state: " + rover);
    }
}
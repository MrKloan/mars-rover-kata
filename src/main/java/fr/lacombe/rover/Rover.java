package fr.lacombe.rover;

import static fr.lacombe.rover.Orientation.EAST;
import static fr.lacombe.rover.Orientation.WEST;
import static fr.lacombe.rover.OrientationCommand.LEFT;

class Rover {

    Orientation turn(final OrientationCommand command) {
        if(command == LEFT) return WEST;
        return EAST;
    }
}

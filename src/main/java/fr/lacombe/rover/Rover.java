package fr.lacombe.rover;

import static fr.lacombe.rover.Orientation.NORTH;
import static fr.lacombe.rover.OrientationCommand.LEFT;

class Rover {

    private final Orientation orientation;

    Rover() {
        this(NORTH);
    }

    Rover(final Orientation orientation) {
        this.orientation = orientation;
    }

    Orientation turn(final OrientationCommand command) {
        if (command == LEFT)
            return orientation.left();
        return orientation.right();
    }
}
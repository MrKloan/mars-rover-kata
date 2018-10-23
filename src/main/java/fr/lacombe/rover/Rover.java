package fr.lacombe.rover;

import static fr.lacombe.rover.Orientation.*;
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
        if (command == LEFT) {
            if (orientation == WEST)
                return SOUTH;
            return WEST;
        }
        return orientation.right();
    }
}
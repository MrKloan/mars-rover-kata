package fr.lacombe.rover;

import java.util.Objects;

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

    Rover turn(final OrientationCommand command) {
        if (command == LEFT)
            return new Rover(orientation.left());
        return new Rover(orientation.right());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Rover rover = (Rover) o;
        return orientation == rover.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orientation);
    }
}

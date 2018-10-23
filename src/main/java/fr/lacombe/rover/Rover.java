package fr.lacombe.rover;

import java.util.Objects;

class Rover {

    private Position position;

    Rover() {
        this(Position.of(Orientation.NORTH, Coordinates.of(0, 0)));
    }

    Rover(final Position position) {
        this.position = position;
    }

    Rover turn(final OrientationCommand command) {
        this.position = position.turn(command);
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Rover rover = (Rover) o;
        return Objects.equals(position, rover.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "position=" + position +
                '}';
    }
}

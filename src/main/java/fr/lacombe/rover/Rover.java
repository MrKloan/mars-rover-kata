package fr.lacombe.rover;

import java.util.List;
import java.util.Objects;

import static fr.lacombe.rover.Command.FORWARD;
import static fr.lacombe.rover.Command.RIGHT;

class Rover {

    private Position position;

    Rover() {
        this(Position.of(Orientation.NORTH, Coordinates.of(0, 0)));
    }

    Rover(final Position position) {
        this.position = position;
    }

    Rover turn(final Command command) {
        this.position = position.turn(command);
        return this;
    }

    Rover receive(final List<Command> commands) {
        for (final Command command : commands) {
            if (command == RIGHT)
                this.position = position.turn(RIGHT);
            if (command == FORWARD)
                this.position = position.forward();
        }

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

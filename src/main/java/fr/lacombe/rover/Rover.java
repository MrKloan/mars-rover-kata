package fr.lacombe.rover;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static fr.lacombe.rover.Command.*;

class Rover {

    private Position position;

    Rover() {
        this(Position.of(Orientation.NORTH, Coordinates.of(0, 0)));
    }

    Rover(final Position position) {
        this.position = position;
    }

    Rover receive(final List<Command> commands) {
        commands.forEach(command -> {
            if (command == LEFT)
                this.position = position.left();
            if (command == RIGHT)
                this.position = position.right();
            if (command == FORWARD)
                this.position = position.forward();
            if (command == BACKWARD)
                this.position = position.backward();
        });

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

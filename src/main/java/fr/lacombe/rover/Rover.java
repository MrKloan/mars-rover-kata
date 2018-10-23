package fr.lacombe.rover;

import java.util.List;

import static fr.lacombe.rover.Command.*;

class Rover {

    private Position position;

    private Rover(final Position position) {
        this.position = position;
    }

    static Rover withInitialPosition() {
        return new Rover(Position.of(Orientation.NORTH, Coordinates.of(0, 0)));
    }

    static Rover of(final Position position) {
        return new Rover(position);
    }

    Position receive(final List<Command> commands) {
        commands.forEach(this::move);

        return position;
    }

    private void move(final Command command) {
        if (command == LEFT)
            position = position.left();
        else if (command == RIGHT)
            position = position.right();
        else if (command == FORWARD)
            position = position.forward();
        else if (command == BACKWARD)
            position = position.backward();
    }

    @Override
    public String toString() {
        return position.toString();
    }
}

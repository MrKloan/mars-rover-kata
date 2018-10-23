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
        commands.forEach(command -> {
            if (command == LEFT)
                position = position.left();
            if (command == RIGHT)
                position = position.right();
            if (command == FORWARD)
                position = position.forward();
            if (command == BACKWARD)
                position = position.backward();
        });

        return position;
    }

    @Override
    public String toString() {
        return position.toString();
    }
}

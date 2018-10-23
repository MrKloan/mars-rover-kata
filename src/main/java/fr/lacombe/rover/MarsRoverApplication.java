package fr.lacombe.rover;

import java.util.List;
import java.util.Optional;

import static fr.lacombe.rover.Command.*;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

class MarsRoverApplication {

    public static void main(final String[] args) {
        final List<Command> commands = mapCommands(args);
        Rover rover = new Rover();

        System.out.println("Initial state: " + rover);
        rover = rover.receive(commands);
        System.out.println("Final state: " + rover);
    }

    private static List<Command> mapCommands(final String[] args) {
        return stream(args)
                .map(MarsRoverApplication::mapCommand)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toList());
    }

    private static Optional<Command> mapCommand(final String arg) {
        switch (arg) {
            case "L":
                return Optional.of(LEFT);
            case "R":
                return Optional.of(RIGHT);
            case "F":
                return Optional.of(FORWARD);
        }

        return Optional.empty();
    }
}

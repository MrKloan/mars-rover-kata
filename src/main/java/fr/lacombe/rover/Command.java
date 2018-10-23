package fr.lacombe.rover;

import java.util.function.UnaryOperator;

enum Command {
    LEFT(Position::left),
    RIGHT(Position::right),
    FORWARD(Position::forward),
    BACKWARD(Position::backward);

    private final UnaryOperator<Position> operation;

    Command(final UnaryOperator<Position> operation) {
        this.operation = operation;
    }

    public Position execute(final Position position) {
        return operation.apply(position);
    }
}

package fr.lacombe.rover;

import java.util.Objects;

import static fr.lacombe.rover.Orientation.EAST;
import static fr.lacombe.rover.Orientation.NORTH;

class Position {

    private final Coordinates coordinates;

    private Position(final Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    static Position of(final Coordinates coordinates) {
        return new Position(coordinates);
    }

    Position forward(final Orientation orientation) {
        if (orientation == EAST)
            return new Position(coordinates.addToX(1));
        if (orientation == NORTH)
            return new Position(coordinates.addToY(1));
        return new Position(coordinates.addToY(-1));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position = (Position) o;
        return Objects.equals(coordinates, position.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}

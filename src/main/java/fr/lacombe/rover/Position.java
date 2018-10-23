package fr.lacombe.rover;

import java.util.Objects;

import static fr.lacombe.rover.Orientation.EAST;
import static fr.lacombe.rover.Orientation.NORTH;

class Position {

    private final Coordinates coordinates;
    private final Orientation orientation;

    private Position(final Coordinates coordinates, final Orientation orientation) {
        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    static Position of(final Coordinates coordinates, final Orientation orientation) {
        return new Position(coordinates, orientation);
    }

    Position forward() {
        if (orientation == EAST)
            return of(coordinates.addToX(1), orientation);
        if (orientation == NORTH)
            return of(coordinates.addToY(1), orientation);
        return of(coordinates.addToY(-1), orientation);
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

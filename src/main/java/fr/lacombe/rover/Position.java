package fr.lacombe.rover;

import java.util.Objects;

import static fr.lacombe.rover.Orientation.*;

class Position {

    private final Orientation orientation;
    private final Coordinates coordinates;

    private Position(final Orientation orientation, final Coordinates coordinates) {
        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    static Position of(final Orientation orientation, final Coordinates coordinates) {
        return new Position(orientation, coordinates);
    }

    Position left() {
        return of(orientation.left(), coordinates);
    }

    Position right() {
        return of(orientation.right(), coordinates);
    }

    Position forward() {
        if (orientation == NORTH)
            return of(orientation, coordinates.addToY(1));
        if (orientation == SOUTH)
            return of(orientation, coordinates.addToY(-1));
        if (orientation == EAST)
            return of(orientation, coordinates.addToX(1));
        return of(orientation, coordinates.addToX(-1));
    }

    Position backward() {
        if (orientation == NORTH)
            return of(orientation, coordinates.addToY(-1));
        if (orientation == SOUTH)
            return of(orientation, coordinates.addToY(1));
        if (orientation == EAST)
            return of(orientation, coordinates.addToX(-1));
        return of(orientation, coordinates.addToX(1));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position = (Position) o;
        return orientation == position.orientation &&
                Objects.equals(coordinates, position.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orientation, coordinates);
    }

    @Override
    public String toString() {
        return orientation + " [" + coordinates + "]";
    }
}

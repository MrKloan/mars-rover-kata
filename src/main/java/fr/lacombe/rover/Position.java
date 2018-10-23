package fr.lacombe.rover;

import java.util.Objects;

import static fr.lacombe.rover.Command.RIGHT;
import static fr.lacombe.rover.Orientation.EAST;
import static fr.lacombe.rover.Orientation.NORTH;
import static fr.lacombe.rover.Orientation.WEST;
import static fr.lacombe.rover.Command.LEFT;

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

    Position turn(final Command command) {
        if (command == LEFT)
            return of(orientation.left(), coordinates);
        if(command == RIGHT)
            return of(orientation.right(), coordinates);
        return this;
    }

    Position forward() {
        if(orientation == WEST)
            return of(orientation, coordinates.addToX(-1));
        if (orientation == EAST)
            return of(orientation, coordinates.addToX(1));
        if (orientation == NORTH)
            return of(orientation, coordinates.addToY(1));
        return of(orientation, coordinates.addToY(-1));
    }

    Position backward() {
        if(orientation == EAST)
            return of(orientation, coordinates.addToX(-1));
        return of(orientation, coordinates.addToY(-1));
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
        return "Position{" +
                "orientation=" + orientation +
                ", coordinates=" + coordinates +
                '}';
    }
}

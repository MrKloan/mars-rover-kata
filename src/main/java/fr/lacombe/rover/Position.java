package fr.lacombe.rover;

import java.util.Objects;

import static fr.lacombe.rover.Orientation.EAST;
import static fr.lacombe.rover.Orientation.NORTH;

class Position {

    private final int x;
    private final int y;

    Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    Position forward(final Orientation orientation) {
        if (orientation == EAST)
            return new Position(x + 1, 0);
        if (orientation == NORTH)
            return new Position(0, y + 1);
        return new Position(0, y - 1);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

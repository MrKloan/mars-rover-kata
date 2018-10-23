package fr.lacombe.rover;

import java.util.Objects;

import static fr.lacombe.rover.Orientation.NORTH;

class Position {

    private final int ordinate;

    Position(final int ordinate) {
        this.ordinate = ordinate;
    }

    Position forward(final Orientation orientation) {
        if (orientation == NORTH)
            return new Position(ordinate + 1);
        return new Position(ordinate - 1);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position = (Position) o;
        return ordinate == position.ordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordinate);
    }
}

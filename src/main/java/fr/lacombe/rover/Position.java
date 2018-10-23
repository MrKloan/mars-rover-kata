package fr.lacombe.rover;

import java.util.Objects;

class Position {

    private final int ordinate;

    Position(final int ordinate) {
        this.ordinate = ordinate;
    }

    Position forward() {
        return new Position(ordinate + 1);
    }

    Position forward(final Orientation orientation) {
        return new Position(0);
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

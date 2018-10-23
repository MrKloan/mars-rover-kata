package fr.lacombe.rover;

import java.util.Objects;

class Coordinates {

    private final int x;
    private final int y;

    private Coordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    static Coordinates of(final int x, final int y) {
        return new Coordinates(x, y);
    }

    Coordinates addToX(final int offset) {
        return new Coordinates(x + offset, y);
    }

    Coordinates addToY(final int offset) {
        return new Coordinates(x, y + offset);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

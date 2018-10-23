package fr.lacombe.rover;

enum Orientation {

    NORTH, EAST, SOUTH, WEST;

    Orientation right() {
        if (this == WEST)
            return NORTH;
        return Orientation.values()[this.ordinal() + 1];
    }

    Orientation left() {
        if (this == NORTH)
            return WEST;
        return Orientation.values()[this.ordinal() - 1];
    }
}

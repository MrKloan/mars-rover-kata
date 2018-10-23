package fr.lacombe.rover;

enum Orientation {

    NORTH {
        @Override
        Orientation right() {
            return EAST;
        }
    },
    EAST {
        @Override
        Orientation right() {
            return SOUTH;
        }
    },
    SOUTH {
        @Override
        Orientation right() {
            return WEST;
        }
    },
    WEST {
        @Override
        Orientation right() {
            return NORTH;
        }
    };

    abstract Orientation right();
}

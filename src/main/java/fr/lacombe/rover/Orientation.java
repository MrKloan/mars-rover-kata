package fr.lacombe.rover;

enum Orientation {

    NORTH {
        @Override
        Orientation right() {
            return EAST;
        }

        @Override
        Orientation left() {
            return WEST;
        }
    },
    EAST {
        @Override
        Orientation right() {
            return SOUTH;
        }

        @Override
        Orientation left() {
            return NORTH;
        }
    },
    SOUTH {
        @Override
        Orientation right() {
            return WEST;
        }

        @Override
        Orientation left() {
            return EAST;
        }
    },
    WEST {
        @Override
        Orientation right() {
            return NORTH;
        }

        @Override
        Orientation left() {
            return SOUTH;
        }
    };

    abstract Orientation right();

    abstract Orientation left();
}

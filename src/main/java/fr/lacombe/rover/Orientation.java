package fr.lacombe.rover;

enum Orientation {

    NORTH {
        @Override
        Orientation left() {
            return WEST;
        }
    },
    EAST {
        @Override
        Orientation left() {
            return NORTH;
        }
    },
    SOUTH {
        @Override
        Orientation left() {
            return EAST;
        }
    },
    WEST {
        @Override
        Orientation left() {
            return SOUTH;
        }
    };

    Orientation right() {
        if(this.ordinal() == Orientation.values().length - 1)
            return NORTH;

        return Orientation.values()[this.ordinal() + 1];
    }

    abstract Orientation left();
}

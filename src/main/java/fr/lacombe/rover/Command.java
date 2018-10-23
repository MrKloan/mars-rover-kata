package fr.lacombe.rover;

enum Command {
    LEFT {
        @Override
        Position updatePosition(final Position position) {
            return position.left();
        }
    },
    RIGHT {
        @Override
        Position updatePosition(final Position position) {
            return position.right();
        }
    },
    FORWARD {
        @Override
        Position updatePosition(final Position position) {
            return position.forward();
        }
    },
    BACKWARD {
        @Override
        Position updatePosition(final Position position) {
            return position.backward();
        }
    };

    abstract Position updatePosition(final Position position);
}

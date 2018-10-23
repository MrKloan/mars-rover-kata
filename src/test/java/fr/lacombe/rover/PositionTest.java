package fr.lacombe.rover;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static fr.lacombe.rover.Orientation.EAST;
import static fr.lacombe.rover.Orientation.NORTH;
import static fr.lacombe.rover.Orientation.WEST;
import static fr.lacombe.rover.Command.LEFT;
import static fr.lacombe.rover.Command.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class PositionTest {

    @Test
    @Parameters({
            "0, 0, NORTH, 0, 1",
            "0, 1, SOUTH, 0, 0",
            "0, 0, EAST, 1, 0",
            "1, 0, WEST, 0, 0",
    })
    public void should_calculate_forward_position_with_orientation(
            final int initialX, final int initialY,
            final Orientation orientation,
            final int expectedX, final int expectedY
    ) {
        final Position position = Position.of(orientation, Coordinates.of(initialX, initialY));

        final Position result = position.forward();

        assertThat(result).isEqualTo(Position.of(orientation, Coordinates.of(expectedX, expectedY)));
    }

    @Test
    @Parameters({
            "0, 1, NORTH, 0, 0",
            "1, 0, EAST, 0, 0",
            "0, 0, WEST, 1, 0",
            "0, 0, SOUTH, 0, 1",
    })
    public void should_calculate_backward_position_with_orientation(
            final int initialX, final int initialY,
            final Orientation orientation,
            final int expectedX, final int expectedY
    ) {
        final Position position = Position.of(orientation, Coordinates.of(initialX, initialY));

        final Position result = position.backward();

        assertThat(result).isEqualTo(Position.of(orientation, Coordinates.of(expectedX, expectedY)));
    }

    @Test
    public void should_turn_left() {
        final Position position = Position.of(NORTH, Coordinates.of(0, 0));

        final Position result = position.left();

        assertThat(result).isEqualTo(Position.of(WEST, Coordinates.of(0, 0)));
    }

    @Test
    public void should_turn_right() {
        final Position position = Position.of(NORTH, Coordinates.of(0, 0));

        final Position result = position.right();

        assertThat(result).isEqualTo(Position.of(EAST, Coordinates.of(0, 0)));
    }
}

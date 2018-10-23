package fr.lacombe.rover;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class PositionTest {

    @Test
    @Parameters({
            "0, 0, NORTH, 0, 1",
            "0, 1, NORTH, 0, 2",
            "0, 2, SOUTH, 0, 1",
            "0, 1, SOUTH, 0, 0",
            "0, 0, EAST, 1, 0",
            "1, 0, EAST, 2, 0"
    })
    public void should_calculate_forward_position_with_orientation(
            final int initialX, final int initialY,
            final Orientation orientation,
            final int expectedX, final int expectedY
    ) {
        final Position position = Position.of(Coordinates.of(initialX, initialY));

        final Position result = position.forward(orientation);

        assertThat(result).isEqualTo(Position.of(Coordinates.of(expectedX, expectedY)));
    }
}

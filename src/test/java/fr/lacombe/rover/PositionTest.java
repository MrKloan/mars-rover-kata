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
            "0, NORTH, 1",
            "1, NORTH, 2",
            "2, SOUTH, 1",
            "1, SOUTH, 0"
    })
    public void should_calculate_forward_position_with_orientation(final int initialOrdinate, final Orientation orientation, final int expectedOrdinate) {
        final Position position = new Position(initialOrdinate);

        final Position result = position.forward(orientation);

        assertThat(result).isEqualTo(new Position(expectedOrdinate));
    }
}

package fr.lacombe.rover;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static fr.lacombe.rover.Orientation.SOUTH;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class PositionTest {

    @Test
    @Parameters({
            "0, 1",
            "1, 2",
            "2, 3"
    })
    public void should_calculate_forward_position(final int initialOrdinate, final int expectedOrdinate) {
        final Position position = new Position(initialOrdinate);

        final Position result = position.forward();

        assertThat(result).isEqualTo(new Position(expectedOrdinate));
    }

    @Test
    public void should_calculate_forward_position_with_orientation() {
        final Position position = new Position(1);

        final Position result = position.forward(SOUTH);

        assertThat(result).isEqualTo(new Position(0));
    }
}

package fr.lacombe.rover;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static fr.lacombe.rover.Orientation.*;
import static fr.lacombe.rover.OrientationCommand.LEFT;
import static fr.lacombe.rover.OrientationCommand.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RoverTest {

    @Test
    @Parameters({
            "NORTH, WEST",
            "WEST, SOUTH",
            "SOUTH, EAST",
            "EAST, NORTH"
    })
    public void should_be_oriented_in_correct_orientation_when_turning_left(final Orientation initialOrientation, final Orientation expectedOrientation) {
        final Rover rover = new Rover(initialOrientation);

        final Orientation result = rover.turn(LEFT);

        assertThat(result).isEqualTo(expectedOrientation);
    }

    @Test
    @Parameters({
            "NORTH, EAST",
            "EAST, SOUTH",
            "SOUTH, WEST",
            "WEST, NORTH"
    })
    public void should_be_oriented_in_correct_orientation_when_turning_right(final Orientation initialOrientation, final Orientation expectedOrientation) {
        final Rover rover = new Rover(initialOrientation);

        final Orientation result = rover.turn(RIGHT);

        assertThat(result).isEqualTo(expectedOrientation);
    }
}

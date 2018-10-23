package fr.lacombe.rover;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class OrientationTest {

    @Test
    @Parameters({
            "NORTH, WEST",
            "WEST, SOUTH",
            "SOUTH, EAST",
            "EAST, NORTH"
    })
    public void should_have_the_correct_orientation_when_turning_left(final Orientation initialOrientation, final Orientation expectedOrientation) {
        final Orientation result = initialOrientation.left();

        assertThat(result).isEqualTo(expectedOrientation);
    }

    @Test
    @Parameters({
            "NORTH, EAST",
            "EAST, SOUTH",
            "SOUTH, WEST",
            "WEST, NORTH"
    })
    public void should_have_the_correct_orientation_when_turning_right(final Orientation initialOrientation, final Orientation expectedOrientation) {
        final Orientation result = initialOrientation.right();

        assertThat(result).isEqualTo(expectedOrientation);
    }
}

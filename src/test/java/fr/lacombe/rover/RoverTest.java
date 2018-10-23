package fr.lacombe.rover;

import org.junit.Test;

import static fr.lacombe.rover.Orientation.*;
import static fr.lacombe.rover.OrientationCommand.LEFT;
import static fr.lacombe.rover.OrientationCommand.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {

    @Test
    public void should_be_oriented_west_when_turning_left_from_north() {
        final Rover rover = new Rover();

        final Orientation result = rover.turn(LEFT);

        assertThat(result).isEqualTo(WEST);
    }

    @Test
    public void should_be_oriented_east_when_turning_right_from_north() {
        final Rover rover = new Rover();

        final Orientation result = rover.turn(RIGHT);

        assertThat(result).isEqualTo(EAST);
    }


    @Test
    public void should_be_oriented_south_when_turning_right_from_east() {
        final Rover rover = new Rover(EAST);

        final Orientation result = rover.turn(RIGHT);

        assertThat(result).isEqualTo(SOUTH);
    }

    @Test
    public void should_be_oriented_west_when_turning_right_from_south() {
        final Rover rover = new Rover(SOUTH);

        final Orientation result = rover.turn(RIGHT);

        assertThat(result).isEqualTo(WEST);
    }

    @Test
    public void should_be_oriented_north_when_turning_right_from_west() {
        final Rover rover = new Rover(WEST);

        final Orientation result = rover.turn(RIGHT);

        assertThat(result).isEqualTo(NORTH);
    }
}

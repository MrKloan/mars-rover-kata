package fr.lacombe.rover;

import org.junit.Test;

import static fr.lacombe.rover.Orientation.EAST;
import static fr.lacombe.rover.Orientation.WEST;
import static fr.lacombe.rover.OrientationCommand.LEFT;
import static fr.lacombe.rover.OrientationCommand.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {

    @Test
    public void should_turn_right() {
        final Rover rover = new Rover();

        final Orientation result = rover.turn(RIGHT);

        assertThat(result).isEqualTo(EAST);
    }

    @Test
    public void should_turn_left() {
        final Rover rover = new Rover();

        final Orientation result = rover.turn(LEFT);

        assertThat(result).isEqualTo(WEST);
    }
}

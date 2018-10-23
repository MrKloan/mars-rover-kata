package fr.lacombe.rover;

import org.junit.Test;

import static fr.lacombe.rover.OrientationCommand.LEFT;
import static fr.lacombe.rover.OrientationCommand.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {

    @Test
    public void should_turn_right() {
        final Rover rover = new Rover();

        final Rover result = rover.turn(RIGHT);

        assertThat(result).isEqualTo(new Rover(Position.of(Orientation.EAST, Coordinates.of(0, 0))));
    }

    @Test
    public void should_turn_left() {
        final Rover rover = new Rover();

        final Rover result = rover.turn(LEFT);

        assertThat(result).isEqualTo(new Rover(Position.of(Orientation.WEST, Coordinates.of(0, 0))));
    }
}

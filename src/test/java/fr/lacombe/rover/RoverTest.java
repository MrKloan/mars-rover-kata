package fr.lacombe.rover;

import org.junit.Test;

import static fr.lacombe.rover.Orientation.EAST;
import static fr.lacombe.rover.Orientation.WEST;
import static fr.lacombe.rover.OrientationCommand.LEFT;
import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {

    @Test
    public void should_turn_right() {
        final Rover rover = new Rover();

        final Rover result = rover.turnRight();

        assertThat(result).isEqualTo(new Rover(EAST));
    }

    @Test
    public void should_turn_left() {
        final Rover rover = new Rover();

        final Rover result = rover.turn(LEFT);

        assertThat(result).isEqualTo(new Rover(WEST));
    }
}

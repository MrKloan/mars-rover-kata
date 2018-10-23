package fr.lacombe.rover;

import org.junit.Test;

import static fr.lacombe.rover.Orientation.EAST;
import static fr.lacombe.rover.Orientation.WEST;
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

        final Rover result = rover.turnLeft();

        assertThat(result).isEqualTo(new Rover(WEST));
    }

    @Test
    public void should_turn_left_2() {
        final Rover rover = new Rover();

        final Rover result = rover.turn(OrientationCommand.LEFT);

        assertThat(result).isEqualTo(new Rover(WEST));
    }
}

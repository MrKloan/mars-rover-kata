package fr.lacombe.rover;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {

    @Test
    public void should_turn_right() {
        final Rover rover = new Rover();

        final int result = rover.turnRight();

        assertThat(result).isEqualTo(1);
    }
}

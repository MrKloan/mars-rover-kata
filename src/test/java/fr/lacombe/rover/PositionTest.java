package fr.lacombe.rover;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    public void should_calculate_forward_position() {
        final Position position = new Position(0);

        final Position result = position.forward();

        assertThat(result).isEqualTo(new Position(1));
    }
}

package fr.lacombe.rover;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static fr.lacombe.rover.Command.*;
import static fr.lacombe.rover.Orientation.*;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RoverTest {

    @Test
    @Parameters(method = "parameters")
    public void should_handle_received_commands(
            final Orientation initialOrientation, final List<Command> commands,
            final Orientation expectedOrientation,
            final int expectedX,
            final int expectedY
    ) {
        final Position position = Position.of(initialOrientation, Coordinates.of(0, 0));
        final Rover rover = new Rover(position);

        final Rover result = rover.receive(commands);

        assertThat(result).isEqualTo(new Rover(Position.of(expectedOrientation, Coordinates.of(expectedX, expectedY))));
    }

    static Object[] parameters() {
        return new Object[][] {
                {NORTH, singletonList(FORWARD), NORTH, 0, 1},
                {NORTH,singletonList(LEFT), WEST, 0, 0},
                {NORTH,singletonList(RIGHT), EAST, 0, 0},
                {SOUTH,singletonList(BACKWARD), SOUTH, 0, 1},
                {NORTH, asList(FORWARD, FORWARD, RIGHT, FORWARD), EAST, 1, 2},
                {NORTH, asList(FORWARD, FORWARD, RIGHT, FORWARD, FORWARD, LEFT, BACKWARD, BACKWARD, RIGHT, BACKWARD, LEFT, LEFT, FORWARD, RIGHT), NORTH, 0, 0}
        };
    }
}

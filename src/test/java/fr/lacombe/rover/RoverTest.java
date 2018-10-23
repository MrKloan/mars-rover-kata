package fr.lacombe.rover;

import junitparams.JUnitParamsRunner;
import junitparams.NamedParameters;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static fr.lacombe.rover.Command.FORWARD;
import static fr.lacombe.rover.Command.LEFT;
import static fr.lacombe.rover.Command.RIGHT;
import static fr.lacombe.rover.Orientation.EAST;
import static fr.lacombe.rover.Orientation.NORTH;
import static fr.lacombe.rover.Orientation.WEST;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RoverTest {

    @Test
    @Parameters(method = "parameters")
    public void should_handle_received_commands(
            final List<Command> commands,
            final Orientation expectedOrientation,
            final int expectedX,
            final int expectedY
    ) {
        final Rover rover = new Rover();

        final Rover result = rover.receive(commands);

        assertThat(result).isEqualTo(new Rover(Position.of(expectedOrientation, Coordinates.of(expectedX, expectedY))));
    }

    static Object[] parameters() {
        return new Object[][] {
                {singletonList(FORWARD), NORTH, 0, 1},
                {singletonList(LEFT), WEST, 0, 0},
                {singletonList(RIGHT), EAST, 0, 0},
                {asList(FORWARD, FORWARD, RIGHT, FORWARD), EAST, 1, 2}
        };
    }
}

package fr.lacombe.rover;

import org.junit.Test;

import java.util.List;

import static fr.lacombe.rover.Command.FORWARD;
import static fr.lacombe.rover.Command.LEFT;
import static fr.lacombe.rover.Command.RIGHT;
import static fr.lacombe.rover.Orientation.EAST;
import static fr.lacombe.rover.Orientation.NORTH;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
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

    @Test
    public void should_go_forward() {
        final Rover rover = new Rover();

        final Rover result = rover.receive(singletonList(FORWARD));

        assertThat(result).isEqualTo(new Rover(Position.of(NORTH, Coordinates.of(0, 1))));
    }

    @Test
    public void should_go_forward2() {
        final Rover rover = new Rover();
        final List<Command> commands = singletonList(FORWARD);

        final Rover result = rover.receive(commands);

        assertThat(result).isEqualTo(new Rover(Position.of(NORTH, Coordinates.of(0, 1))));
    }

    @Test
    public void should_go_forward3() {
        final Rover rover = new Rover();
        final List<Command> commands = asList(FORWARD, FORWARD);

        final Rover result = rover.receive(commands);

        assertThat(result).isEqualTo(new Rover(Position.of(NORTH, Coordinates.of(0, 2))));
    }

    @Test
    public void should_turn_right_and_move_forward() {
        final Rover rover = new Rover();
        final List<Command> commands = asList(RIGHT, FORWARD);

        final Rover result = rover.receive(commands);

        assertThat(result).isEqualTo(new Rover(Position.of(EAST, Coordinates.of(1, 0))));
    }
}

package fr.lacombe.rover;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class MarsRoverApplicationTest {

    @Test
    public void should_map_unknown_parameter_to_empty_optional() {
        final String argument = "Z";

        final Optional<Command> result = MarsRoverApplication.mapCommand(argument);

        assertThat(result).isEqualTo(Optional.empty());
    }

    @Test
    @Parameters({
            "L, LEFT",
            "R, RIGHT",
            "F, FORWARD",
            "B, BACKWARD",
    })
    public void should_map_parameters_to_command(final String argument, final Command expectedCommand) {
        final Optional<Command> result = MarsRoverApplication.mapCommand(argument);

        assertThat(result).isEqualTo(Optional.of(expectedCommand));
    }
}
package generator;

import domain.Direction;
import domain.Ladder;
import domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGeneratorTest {
    @Test
    @DisplayName("Ladder를 잘 만드는지 확인한다.")
    void generateTest() {
        Ladder actual = LadderGenerator.generate(5, 3, () -> true);

        Line line = new Line(
                Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT, Direction.NONE)
        );
        Ladder expected = new Ladder(
                Arrays.asList(line, line, line)
        );

        assertThat(actual).isEqualTo(expected);
    }
}
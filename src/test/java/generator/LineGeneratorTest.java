package generator;

import domain.Direction;
import domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineGeneratorTest {
    @Test
    @DisplayName("Line을 잘 만드는지 확인한다.")
    void generateTest() {
        Line actual = LineGenerator.generate(4, () -> true);
        Line expected = new Line(
                Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT)
        );

        assertThat(actual).isEqualTo(expected);

        actual = LineGenerator.generate(4, () -> false);
        expected = new Line(
                Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE, Direction.NONE)
        );

        assertThat(actual).isEqualTo(expected);
    }
}
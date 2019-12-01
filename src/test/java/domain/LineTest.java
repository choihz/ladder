package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    private List<Direction> directions;

    @BeforeEach
    void setUp() {
        directions = Arrays.asList(
                Direction.RIGHT, Direction.LEFT, Direction.NONE, Direction.RIGHT, Direction.LEFT
        );
    }

    @Test
    @DisplayName("Line 객체가 잘 만들어지는지 확인한다.")
    void constructorTest() {
        assertThat(new Line(directions)).isExactlyInstanceOf(Line.class);
    }

    @Test
    @DisplayName("사다리가 뚫린 방향으로만 잘 이동하는지 확인한다.")
    void moveTest_Success() {
        Line line = new Line(directions);

        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(2);
    }

    @Test
    @DisplayName("움직일 수 없는 위치에서는 예외가 발생하는지 확인한다.")
    void moveTest_Fail() {
        Line line = new Line(directions);

        assertThatThrownBy(
                () -> line.move(5)
        ).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("오른쪽으로 움직일 수 있는지 여부를 잘 판단하는지 확인한다.")
    void isMovableToRightTest() {
        Line line = new Line(directions);

        assertThat(line.isMovableToRight(0)).isEqualTo(true);
        assertThat(line.isMovableToRight(1)).isEqualTo(false);
        assertThat(line.isMovableToRight(2)).isEqualTo(false);
    }
}
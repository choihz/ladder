package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {
    @Test
    @DisplayName("맨 왼쪽 Direction이 LEFT가 아닌지 확인한다.")
    void getFirstDirectionTest() {
        assertThat(Direction.getFirstDirection(() -> true)).isEqualTo(Direction.RIGHT);
        assertThat(Direction.getFirstDirection(() -> false)).isEqualTo(Direction.NONE);
    }

    @Test
    @DisplayName("다음 Direction을 잘 리턴하는지 확인한다.")
    void getNextDirectionTest() {
        assertThat(Direction.LEFT.getNextDirection(() -> true)).isEqualTo(Direction.RIGHT);
        assertThat(Direction.LEFT.getNextDirection(() -> false)).isEqualTo(Direction.NONE);

        assertThat(Direction.RIGHT.getNextDirection(() -> true)).isEqualTo(Direction.LEFT);
        assertThat(Direction.RIGHT.getNextDirection(() -> false)).isEqualTo(Direction.LEFT);

        assertThat(Direction.NONE.getNextDirection(() -> true)).isEqualTo(Direction.RIGHT);
        assertThat(Direction.NONE.getNextDirection(() -> false)).isEqualTo(Direction.NONE);
    }

    @Test
    @DisplayName("맨 오른쪽 Direction이 RIGHT가 아닌지 확인한다.")
    void getLastDirectionTest() {
        assertThat(Direction.RIGHT.getLastDirection()).isEqualTo(Direction.LEFT);
        assertThat(Direction.LEFT.getLastDirection()).isEqualTo(Direction.NONE);
        assertThat(Direction.NONE.getLastDirection()).isEqualTo(Direction.NONE);
    }

    @Test
    @DisplayName("사다리가 뚫린 방향으로만 잘 이동하는지 확인한다.")
    void moveTest() {
        int position = 3;

        assertThat(Direction.LEFT.move(position)).isEqualTo(2);
        assertThat(Direction.RIGHT.move(position)).isEqualTo(4);

        assertThat(Direction.NONE.move(position)).isEqualTo(3);
        assertThat(Direction.NONE.move(position)).isEqualTo(3);
    }
}
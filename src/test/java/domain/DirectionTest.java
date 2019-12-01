package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {
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
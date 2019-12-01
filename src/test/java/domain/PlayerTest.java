package domain;

import exception.InvalidNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    @Test
    @DisplayName("Player 객체가 잘 만들어지는지 확인한다.")
    void constructorTest_Success() {
        assertThat(new Player("cony")).isExactlyInstanceOf(Player.class);
    }

    @Test
    @DisplayName("5자 초과하는 이름에 예외가 발생하는지 확인한다.")
    void constructorTest_Fail() {
        assertThatThrownBy(
                () -> new Player("conycony")
        ).isExactlyInstanceOf(InvalidNameException.class);
    }
}
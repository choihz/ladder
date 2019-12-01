package domain;

import exception.InvalidItemException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ItemTest {
    @Test
    @DisplayName("Item 객체가 잘 만들어지는지 확인한다.")
    void constructorTest_Success() {
        assertThat(new Item("1등")).isExactlyInstanceOf(Item.class);
    }

    @Test
    @DisplayName("5자 초과하는 결과에 예외가 발생하는지 확인한다.")
    void constructorTest_Fail() {
        assertThatThrownBy(
                () -> new Item("꽝꽝꽝꽝꽝꽝")
        ).isExactlyInstanceOf(InvalidItemException.class);
    }
}
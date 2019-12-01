package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemsTest {
    @Test
    @DisplayName("Items 객체가 잘 만들어지는지 확인한다.")
    void constructorTest() {
        assertThat(new Items("1등,2등,3등,4등,꽝")).isExactlyInstanceOf(Items.class);
    }

    @Test
    @DisplayName("index를 이용하여 Item을 잘 찾는지 확인한다.")
    void getPlayersTest() {
        Items items = new Items("1등,2등,3등");

        assertThat(items.getItem(0)).isEqualTo(new Item("1등"));
    }
}
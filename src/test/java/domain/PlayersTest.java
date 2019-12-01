package domain;

import exception.InvalidNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {
    @Test
    @DisplayName("Players 객체가 잘 만들어지는지 확인한다.")
    void constructorTest_Success() {
        assertThat(new Players("코니,미르,희봉,아이크,철시")).isExactlyInstanceOf(Players.class);
    }

    @Test
    @DisplayName("중복 이름이 있을 때 예외가 발생하는지 확인한다.")
    void constructorTest_Fail() {
        assertThatThrownBy(
                () -> new Players("코니,미르,희봉,아이크,철시,미르")
        ).isExactlyInstanceOf(InvalidNameException.class);
    }

    @Test
    @DisplayName("index를 이용하여 Player를 잘 찾는지 확인한다.")
    void getPlayersTest() {
        Players players = new Players("코니,희봉");

        assertThat(players.getPlayer(0)).isEqualTo(new Player("코니"));
    }

    @Test
    @DisplayName("Player의 숫자를 잘 리턴하는지 확인한다.")
    void getNumberOfPlayersTest() {
        Players players = new Players("코니,희봉,철시");

        assertThat(players.getNumberOfPlayers()).isEqualTo(3);
    }

    @Test
    @DisplayName("Player의 존재 여부를 잘 리턴하는지 확인한다.")
    void containsTest() {
        Players players = new Players("코니,아이크");

        assertThat(players.contains(new Player("코니"))).isTrue();
        assertThat(players.contains(new Player("미르"))).isFalse();
    }
}
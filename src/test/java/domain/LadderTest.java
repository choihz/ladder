package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    private Line line1;
    private Line line2;

    @BeforeEach
    void setUp() {
        line1 = new Line(
                Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.NONE, Direction.RIGHT, Direction.LEFT)
        );
        line2 = new Line(
                Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT, Direction.NONE, Direction.NONE)
        );
    }

    @Test
    @DisplayName("Ladder 객체가 잘 만들어지는지 확인한다.")
    void constructorTest() {
        assertThat(new Ladder(Arrays.asList(line1, line2, line1, line2))).isExactlyInstanceOf(Ladder.class);
    }

    @Test
    @DisplayName("Ladder 높이를 잘 리턴하는지 확인한다.")
    void getHeightTest() {
        Ladder ladder = new Ladder(Arrays.asList(line1, line2, line1, line2));

        assertThat(ladder.getHeight()).isEqualTo(4);
    }

    @Test
    @DisplayName("index를 이용하여 Line을 잘 찾는지 확인한다.")
    void getLineTest() {
        Ladder ladder = new Ladder(Arrays.asList(line1, line2, line1, line2));

        assertThat(ladder.getLine(1)).isEqualTo(line2);
    }

    @Test
    @DisplayName("index를 이용하여 Line을 잘 찾는지 확인한다.")
    void playTest() {
        Players players = new Players("코니,미르,희봉,아이크,철시");
        Items items = new Items("1등,2등,3등,4등,5등");
        Ladder ladder = new Ladder(Arrays.asList(line1, line2, line1, line2));
        LadderResult ladderResult = ladder.play(players, items);

        assertThat(ladderResult.getItemByPlayer(players.getPlayer(0))).isEqualTo(items.getItem(1));
        assertThat(ladderResult.getItemByPlayer(players.getPlayer(1))).isEqualTo(items.getItem(2));
        assertThat(ladderResult.getItemByPlayer(players.getPlayer(2))).isEqualTo(items.getItem(0));
        assertThat(ladderResult.getItemByPlayer(players.getPlayer(3))).isEqualTo(items.getItem(3));
        assertThat(ladderResult.getItemByPlayer(players.getPlayer(4))).isEqualTo(items.getItem(4));
    }
}
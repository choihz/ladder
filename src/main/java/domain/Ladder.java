package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int getHeight() {
        return lines.size();
    }

    public Line getLine(int index) {
        return lines.get(index);
    }

    public LadderResult play(Players players, Items items) {
        Map<Player, Item> result = new HashMap<>();
        int numberOfPlayers = players.getNumberOfPlayers();
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = players.getPlayer(i);
            int index = getItemIndex(i);
            result.put(player, items.getItem(index));
        }
        return new LadderResult(result);
    }

    private int getItemIndex(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}

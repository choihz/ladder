package generator;

import domain.Ladder;
import domain.Line;
import utils.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    public static Ladder generate(int numberOfPlayers, int height, BooleanGenerator booleanGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(LineGenerator.generate(numberOfPlayers, booleanGenerator));
        }
        return new Ladder(lines);
    }
}

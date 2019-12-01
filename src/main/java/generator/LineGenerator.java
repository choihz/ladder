package generator;

import domain.Direction;
import domain.Line;
import utils.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    public static Line generate(int numberOfPlayers, BooleanGenerator booleanGenerator) {
        List<Direction> directions = new ArrayList<>();

        Direction current = Direction.getFirstDirection(booleanGenerator);
        directions.add(current);
        for (int i = 0; i < numberOfPlayers - 2; i++) {
            current = current.getNextDirection(booleanGenerator);
            directions.add(current);
        }
        directions.add(current.getLastDirection());

        return new Line(directions);
    }
}

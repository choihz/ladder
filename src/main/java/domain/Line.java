package domain;

import java.util.List;

public class Line {
    private static final int MIN_POSITION = 0;

    private final List<Direction> directions;

    public Line(List<Direction> directions) {
        this.directions = directions;
    }

    public int move(int position) {
        validatePosition(position);
        Direction currentDirection = directions.get(position);
        return currentDirection.move(position);
    }

    private void validatePosition(int position) {
        if (position < MIN_POSITION || position >= directions.size()) {
            throw new IllegalArgumentException("존재할 수 없는 위치입니다.");
        }
    }
}

package domain;

import java.util.List;
import java.util.Objects;

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

    public boolean isMovableToRight(int index) {
        return Direction.RIGHT.equals(directions.get(index));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(directions, line.directions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directions);
    }
}

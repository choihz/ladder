package domain;

import utils.BooleanGenerator;

public enum Direction {
    LEFT(true, false),
    RIGHT(false, true),
    NONE(false, false);

    private final boolean left;
    private final boolean right;

    Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction getFirstDirection(BooleanGenerator booleanGenerator) {
        if (booleanGenerator.generate()) {
            return RIGHT;
        }
        return NONE;
    }

    public Direction getNextDirection(BooleanGenerator booleanGenerator) {
        if (this.right) {
            return LEFT;
        }
        return getFirstDirection(booleanGenerator);
    }

    public Direction getLastDirection() {
        if (this.right) {
            return LEFT;
        }
        return NONE;
    }

    public int move(int position) {
        if (left) {
            return position - 1;
        }
        if (right) {
            return position + 1;
        }
        return position;
    }
}

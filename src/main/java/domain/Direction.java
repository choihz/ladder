package domain;

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

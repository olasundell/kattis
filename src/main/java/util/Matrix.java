package util;

/**
 * TODO write documentation
 */
public class Matrix {
    public static Direction findDirection(int i) {
        switch (i) {
            case 0:
                return Direction.LEFT;
            case 1:
                return Direction.UP;
            case 2:
                return Direction.RIGHT;
            case 3:
                return Direction.DOWN;
            default:
                throw new IllegalArgumentException("Expected a number between 0-3 but got " + i);
        }
    }

    public static int translateX(int i, int j, int size,
                                 Matrix.Direction direction) {
        switch (direction) {
            case LEFT:
            case RIGHT:
                return i;
            case UP:
                return j;
            case DOWN:
                return (size -1) - j;
        }

        return -1;
    }

   public static int translateY(int i, int j, int size,
                                Matrix.Direction direction) {
        switch (direction) {
            case LEFT:
                return j;
            case RIGHT:
                return (size - 1) - j;
            case UP:
                return i;
            case DOWN:
                return (size - 1) - i;

        }

        return -1;
    }


    public enum Direction {
        LEFT,
        UP,
        RIGHT,
        DOWN;

        Direction opposite() {
            switch (this) {
                case LEFT:
                    return RIGHT;
                case RIGHT:
                    return LEFT;
                case UP:
                    return DOWN;
                case DOWN:
                    return UP;
            }

            return null;
        }
    }
}

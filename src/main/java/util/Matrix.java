package util;

import java.awt.*;

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

    public static class Move {
	    private final Direction direction;
    	private final int amount;

	    public Move(Direction direction, int amount) {
		    this.direction = direction;
		    this.amount = amount;
	    }

	    public Point getDelta() {
		    switch (direction) {
			    case UP:
				    return new Point(0, -amount);
			    case DOWN:
				    return new Point(0, +amount);
			    case LEFT:
				    return new Point(-amount, 0);
			    case RIGHT:
				    return new Point(+amount, 0);
		    }

		    return null;
	    }


	    @Override
	    public String toString() {
		    return "Move{" +
				    "direction=" + direction +
				    ", amount=" + amount +
				    '}';
	    }
    }

    public enum CardinalDirection {
        EAST,
        WEST,
        NORTH,
        SOUTH;

        public CardinalDirection turn(Direction direction) {
            switch (direction) {
                case RIGHT:
                    switch (this) {
                        case EAST:
                            return SOUTH;
                        case WEST:
                            return NORTH;
                        case SOUTH:
                            return WEST;
                        case NORTH:
                            return EAST;
                    }
                case LEFT:
                    switch (this) {
                        case EAST:
                            return NORTH;
                        case WEST:
                            return SOUTH;
                        case SOUTH:
                            return EAST;
                        case NORTH:
                            return WEST;
                    }
            }
            return this;
        }
    }

    public enum Direction {
        LEFT,
        UP,
        RIGHT,
        DOWN;

        public static Direction of(String str) {
        	switch (str) {
		        case "u":
		        	return UP;
		        case "d":
		        	return DOWN;
		        case "l":
		        	return LEFT;
		        case "r":
		        	return RIGHT;
	        }

	        return null;
        }

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

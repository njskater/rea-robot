package demo.jerry.rea.robot.model;

/**
 * A enumeration of four directions.
 * @author jzhang
 *
 */
public enum Direction {
    N("North"), E("East"), S("South"), W("West");

    private String desc;

    private Direction(final String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    /**
     * Turn left from current direction.
     * @return Direction left of current direction.
     */
    public Direction left() {
        final int leftOrdinal = this.ordinal() == 0 ? values().length - 1 : this.ordinal() - 1;
        return values()[leftOrdinal];
    }

    /**
     * Turn right from current direction.
     * @return Direction right of current direction.
     */
    public Direction right() {
        final int rightOrdinal = this.ordinal() == values().length - 1 ? 0 : this.ordinal() + 1;
        return values()[rightOrdinal];
    }

    /**
     * Parse enum from string value.
     * @param directionString
     */
    public static Direction parse(final String directionString) {
        for (final Direction direction : Direction.values()) {
            if (direction.desc.equalsIgnoreCase(directionString)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("Invalid direction string");
    }
}


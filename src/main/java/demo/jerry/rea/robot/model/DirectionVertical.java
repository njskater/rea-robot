package demo.jerry.rea.robot.model;


public enum DirectionVertical {
    UP, MID, DOWN;

    /**
     * Parse enum from string value.
     * @param directionString
     */
    public static DirectionVertical parse(final String directionString) {
        for (final DirectionVertical direction : DirectionVertical.values()) {
            if (direction.toString().equalsIgnoreCase(directionString)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("Invalid direction string");
    }
}

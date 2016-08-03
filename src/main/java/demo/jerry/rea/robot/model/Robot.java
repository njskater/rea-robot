package demo.jerry.rea.robot.model;


/**
 * Class to represent a robot.
 * @author jzhang
 *
 */
public class Robot {
    /**
     * Current position of the robot.
     */
    private Point position;

    /**
     * Current direction of the robot.
     */
    private Direction direction;

    public void setPosition(final Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public void setDirection(final Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getStatus() {
        return new StringBuilder()
        .append("Position: ").append(position == null ? "Unknown" : position)
        .append(" Direction:").append(direction == null ? "Unknown" : direction.getDesc())
        .toString();
    }

}


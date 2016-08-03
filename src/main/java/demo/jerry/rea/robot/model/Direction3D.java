package demo.jerry.rea.robot.model;


public class Direction3D {
    private final Direction direction;
    private final DirectionVertical directionVertical;

    public Direction3D(final Direction direction, final DirectionVertical directionVertical) {
        this.direction = direction;
        this.directionVertical = directionVertical;
    }

    public Direction getDirection() {
        return direction;
    }

    public DirectionVertical getDirectionVertical() {
        return directionVertical;
    }

}

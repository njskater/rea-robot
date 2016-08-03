package demo.jerry.rea.robot.model.command;

import demo.jerry.rea.robot.model.Direction;
import demo.jerry.rea.robot.model.Point;
import demo.jerry.rea.robot.model.Robot;
import demo.jerry.rea.robot.model.Table;

/**
 * This command move robot 1 step forward on current direction.
 * @author jzhang
 */
public class MoveCommand implements RobotCommand {

    private final Robot robot;
    private final Table table;

    public MoveCommand(final Robot robot, final Table table) {
        if (robot == null || table == null) {
            throw new IllegalArgumentException("robot and table must be provided.");
        }

        this.robot = robot;
        this.table = table;
    }

    @Override
    public void execute() {
        robot.setPosition(getNextPosition());
    }

    private Point getNextPosition() {
        final Point currentPosition = this.robot.getPosition();
        if (currentPosition == null) {
            throw new IllegalStateException("The robot has no current position yet.");
        }

        final Direction currentDirection = this.robot.getDirection();
        if (currentDirection == null) {
            throw new IllegalStateException("The robot has no current direction yet.");
        }

        int x = currentPosition.getPosX();
        int y = currentPosition.getPosY();

        switch (currentDirection) {
            case N:
                y++;
                break;
            case E:
                x++;
                break;
            case S:
                y--;
                break;
            case W:
                x--;
                break;
        }

        final Point nextPosition = new Point(x, y);
        if (!table.onTable(nextPosition)) {
            throw new IllegalStateException("Can not move beyond boundary of table.");
        }
        return nextPosition;
    }

}

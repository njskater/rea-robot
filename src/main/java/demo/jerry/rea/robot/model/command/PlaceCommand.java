package demo.jerry.rea.robot.model.command;

import demo.jerry.rea.robot.model.Direction;
import demo.jerry.rea.robot.model.Point;
import demo.jerry.rea.robot.model.Robot;
import demo.jerry.rea.robot.model.Table;

/**
 * This command places robot in specified point and facing to specified direction.
 * @author jzhang
 */
public class PlaceCommand implements RobotCommand {

    private final Robot robot;
    private final Table table;
    private final Point point;
    private final Direction direction;

    public PlaceCommand(final Robot robot, final Table table, final Point point, final Direction direction) {
        if (robot == null || table == null || point == null || direction == null) {
            throw new IllegalArgumentException("robot, table, point and direction must be provided.");
        }

        this.robot = robot;
        this.table = table;
        this.point = point;
        this.direction = direction;
    }

    @Override
    public void execute() {
        if (!table.onTable(point)) {
            throw new IllegalStateException("Point not on table");
        }

        robot.setPosition(point);
        robot.setDirection(direction);
    }

}

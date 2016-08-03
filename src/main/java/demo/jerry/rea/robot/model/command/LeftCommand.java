package demo.jerry.rea.robot.model.command;

import demo.jerry.rea.robot.model.Robot;

/**
 * This command let robot face left from current direction.
 * @author jzhang
 */
public class LeftCommand implements RobotCommand {

    private final Robot robot;

    public LeftCommand(final Robot robot) {
        if (robot == null) {
            throw new IllegalArgumentException("robot must be provided.");
        }
        this.robot = robot;
    }

    @Override
    public void execute() {
        if (robot.getDirection() == null) {
            throw new IllegalStateException("robot has no direction information");
        }
        robot.setDirection(robot.getDirection().left());
    }

}

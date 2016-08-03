package demo.jerry.rea.robot.model.command;

import demo.jerry.rea.robot.model.Robot;

/**
 * This command reports robot's status.
 * @author jzhang
 *
 */
public class ReportCommand implements RobotCommand {
    private final Robot robot;

    public ReportCommand(final Robot robot) {
        if (robot == null) {
            throw new IllegalArgumentException("robot must be provided.");
        }
        this.robot = robot;
    }

    @Override
    public void execute() {
        System.out.println(this.robot.getStatus());
    }

}

package demo.jerry.rea.robot.model.command;

/**
 * Command interface, class that implements this interface should provide concrete command execution steps.
 * @author jzhang
 */
public interface RobotCommand {

    /**
     * Execute this command.
     */
    void execute();
}

package demo.jerry.rea.robot.input;

import java.util.List;

import demo.jerry.rea.robot.exception.InvalidInputCommandException;
import demo.jerry.rea.robot.model.Direction;
import demo.jerry.rea.robot.model.Point;
import demo.jerry.rea.robot.model.Robot;
import demo.jerry.rea.robot.model.Table;
import demo.jerry.rea.robot.model.command.LeftCommand;
import demo.jerry.rea.robot.model.command.MoveCommand;
import demo.jerry.rea.robot.model.command.PlaceCommand;
import demo.jerry.rea.robot.model.command.ReportCommand;
import demo.jerry.rea.robot.model.command.RightCommand;
import demo.jerry.rea.robot.model.command.RobotCommand;
import static java.lang.Integer.parseInt;

/**
 * A factory class that reads the String command and creates {@link RobotCommand}.
 * @author jzhang
 *
 */
public class RobotCommandFactory {

    private final InputCommandParser parser;
    private final Robot robot;
    private final Table table;


    /**
     * Construct {@link RobotCommandFactory} by given parameters, which are all mandatory.
     * @param parser
     * @param robot
     * @param table
     */
    public RobotCommandFactory(final InputCommandParser parser, final Robot robot, final Table table) {
        if (parser == null || robot == null || table == null) {
            throw new IllegalArgumentException("parser, robot and table must be provided.");
        }
        this.parser = parser;
        this.robot = robot;
        this.table = table;
    }

    /**
     * Creates {@link RobotCommand} from String command.
     * @param command
     * @return
     */
    public RobotCommand createRobotCommand(final String command) {

        final InputCommand inputCommand = parser.parseCommand(command);

        if (inputCommand == null) {
            throw new InvalidInputCommandException("Command is not valid");
        }

        return createCommand(inputCommand);
    }


    protected Robot getRobot() {
        return robot;
    }


    protected Table getTable() {
        return table;
    }

    protected RobotCommand createCommand(final InputCommand inputCommand) {
        final List<String> params = inputCommand.getParameters();
        switch (inputCommand.getCommandKeyword()) {
            case PLACE:
                return new PlaceCommand(robot, table,
                        new Point(parseInt(params.get(0)), parseInt(params.get(1))),
                        Direction.parse(params.get(2)));
            case MOVE:
                return new MoveCommand(robot, table);
            case LEFT:
                return new LeftCommand(robot);
            case RIGHT:
                return new RightCommand(robot);
            case REPORT:
                return new ReportCommand(robot);
            default:
                throw new IllegalStateException("InputCommand Keyword is not valid");
        }
    }

}

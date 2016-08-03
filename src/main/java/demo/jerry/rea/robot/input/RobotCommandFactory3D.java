package demo.jerry.rea.robot.input;

import java.util.List;

import demo.jerry.rea.robot.model.Direction;
import demo.jerry.rea.robot.model.Direction3D;
import demo.jerry.rea.robot.model.DirectionVertical;
import demo.jerry.rea.robot.model.Point3D;
import demo.jerry.rea.robot.model.Robot3D;
import demo.jerry.rea.robot.model.Table3D;
import demo.jerry.rea.robot.model.command.PlaceCommand3D;
import demo.jerry.rea.robot.model.command.RobotCommand;
import static java.lang.Integer.parseInt;


public class RobotCommandFactory3D extends RobotCommandFactory {

    public RobotCommandFactory3D(final InputCommandParser parser, final Robot3D robot, final Table3D table) {
        super(parser, robot, table);
    }

    @Override
    protected RobotCommand createCommand(final InputCommand inputCommand) {
        final List<String> params = inputCommand.getParameters();

        switch (inputCommand.getCommandKeyword()) {
            case PLACE:
                return new PlaceCommand3D((Table3D) getTable(), (Robot3D) getRobot(),
                        new Point3D(parseInt(params.get(0)), parseInt(params.get(1)), parseInt(params.get(2))),
                        new Direction3D(Direction.parse(params.get(3)), DirectionVertical.parse(params.get(4))));
            default:
                break;
        }
        return super.createCommand(inputCommand);
    }

}

package demo.jerry.rea.robot;

import demo.jerry.rea.robot.input.CommandReader;
import demo.jerry.rea.robot.input.InputCommandParser;
import demo.jerry.rea.robot.input.RobotCommandFactory;
import demo.jerry.rea.robot.input.RobotCommandFactory3D;
import demo.jerry.rea.robot.input.RobotCommandReader;
import demo.jerry.rea.robot.model.Robot3D;
import demo.jerry.rea.robot.model.Table3D;

/**
 * Main entry class for demo robot program.
 * @author jzhang
 */
public class Main {

    private static final int DEFAULT_DIMENSION = 5;
    private static final String WELCOME_MSG = "Welcome to REA robot program!";
    private static final String COMMANDS_TIP = "Please use following command to control robot:\n "
            + "PLACE x,y,[NORTH|EAST|SOUTH|WEST], MOVE, LEFT, RIGHT, REPORT, EXIT\n";

    /**
     * Main entry method.
     * @param args java execution arguments (Not required for this Program).
     */
    public static void main(final String[] args) {

        System.out.println(WELCOME_MSG);
        System.out.println(COMMANDS_TIP);

        final RobotCommandFactory commandFactory = new RobotCommandFactory3D(
                new InputCommandParser(), new Robot3D(), new Table3D(DEFAULT_DIMENSION, DEFAULT_DIMENSION, DEFAULT_DIMENSION));

        final CommandReader reader = new RobotCommandReader(commandFactory);

        reader.readCommand(System.in);

    }
}

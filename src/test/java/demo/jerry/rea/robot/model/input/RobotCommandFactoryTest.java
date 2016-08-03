package demo.jerry.rea.robot.model.input;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import demo.jerry.rea.robot.input.InputCommand;
import demo.jerry.rea.robot.input.InputCommand.CommandKeyword;
import demo.jerry.rea.robot.input.InputCommandParser;
import demo.jerry.rea.robot.input.RobotCommandFactory;
import demo.jerry.rea.robot.model.Robot;
import demo.jerry.rea.robot.model.Table;
import demo.jerry.rea.robot.model.command.LeftCommand;
import demo.jerry.rea.robot.model.command.MoveCommand;
import demo.jerry.rea.robot.model.command.ReportCommand;
import demo.jerry.rea.robot.model.command.RightCommand;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.when;

/**
 * Unit test for {@link RobotCommandFactory}.
 * @author jzhang
 */
@RunWith(MockitoJUnitRunner.class)
public class RobotCommandFactoryTest {

    @Mock
    private Robot robot;

    @Mock
    private Table table;

    @Mock
    private InputCommandParser parser;

    private RobotCommandFactory factory;

    @Before
    public void setup() {
        factory = new RobotCommandFactory(parser, robot, table);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructMissingParser() {
        new RobotCommandFactory(null, robot, table);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructMissingRobot() {
        new RobotCommandFactory(parser, null, table);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructMissingTable() {
        new RobotCommandFactory(parser, robot, null);
    }

    @Test
    public void testCreateLeftCommand() {
        when(parser.parseCommand("LEFT")).thenReturn(new InputCommand(CommandKeyword.LEFT, null));
        assertTrue(factory.createRobotCommand("LEFT") instanceof LeftCommand);
    }

    @Test
    public void testCreateRightCommand() {
        when(parser.parseCommand("RIGHT")).thenReturn(new InputCommand(CommandKeyword.RIGHT, null));
        assertTrue(factory.createRobotCommand("RIGHT") instanceof RightCommand);
    }

    @Test
    public void testCreateMoveCommand() {
        when(parser.parseCommand("MOVE")).thenReturn(new InputCommand(CommandKeyword.MOVE, null));
        assertTrue(factory.createRobotCommand("MOVE") instanceof MoveCommand);
    }

    @Test
    public void testCreateReportCommand() {
        when(parser.parseCommand("REPORT")).thenReturn(new InputCommand(CommandKeyword.REPORT, null));
        assertTrue(factory.createRobotCommand("REPORT") instanceof ReportCommand);
    }

    /*@Test(expected = InvalidInputCommandException.class)
    public void testCreatePlaceCommandMissingParameters() {
        when(parser.parseCommand("PLACE")).thenReturn(new InputCommand(CommandKeyword.PLACE, null));
        factory.createRobotCommand("PLACE");
    }

    @Test(expected = InvalidInputCommandException.class)
    public void testCreatePlaceCommandTooManyParameters() {
        when(parser.parseCommand("PLACE 1,2,3,4")).thenReturn(new InputCommand(CommandKeyword.PLACE, asList("1", "2", "3", "4")));
        factory.createRobotCommand("PLACE 1,2,3,4");
    }

    @Test(expected = InvalidInputCommandException.class)
    public void testCreatePlaceCommandInvalidParameters1() {
        when(parser.parseCommand("PLACE A,2,NORTH")).thenReturn(new InputCommand(CommandKeyword.PLACE, asList("A", "2", "NORTH")));
        factory.createRobotCommand("PLACE A,2,NORTH");
    }

    @Test(expected = InvalidInputCommandException.class)
    public void testCreatePlaceCommandInvalidParameters2() {
        when(parser.parseCommand("PLACE 1,B,NORTH")).thenReturn(new InputCommand(CommandKeyword.PLACE, asList("1", "B", "NORTH")));
        factory.createRobotCommand("PLACE 1,B,NORTH");
    }

    @Test(expected = InvalidInputCommandException.class)
    public void testCreatePlaceCommandInvalidParameters3() {
        when(parser.parseCommand("PLACE 1,2,ABC")).thenReturn(new InputCommand(CommandKeyword.PLACE, asList("1", "2", "ABC")));
        assertTrue(factory.createRobotCommand("PLACE 1,2,ABC") instanceof PlaceCommand);
    }
     */
    @Test
    public void testCreateValidPlaceCommand() {
        when(parser.parseCommand("PLACE 1,2,NORTH")).thenReturn(new InputCommand(CommandKeyword.PLACE, asList("1", "2", "NORTH")));
        factory.createRobotCommand("PLACE 1,2,NORTH");
    }
}

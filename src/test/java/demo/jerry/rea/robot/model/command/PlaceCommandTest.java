package demo.jerry.rea.robot.model.command;


import org.junit.Before;
import org.junit.Test;

import demo.jerry.rea.robot.model.Direction;
import demo.jerry.rea.robot.model.Point;
import demo.jerry.rea.robot.model.Robot;
import demo.jerry.rea.robot.model.Table;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for {@link PlaceCommand} class.
 * @author jzhang
 *
 */
public class PlaceCommandTest {
    private Robot testRobot;
    private Table testTable;

    @Before
    public void setup() {
        testRobot = new Robot();
        testTable = new Table(5, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructorMissingRobot() {
        new PlaceCommand(null, testTable, new Point(3, 3), Direction.E);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructorMissingTable() {
        new PlaceCommand(testRobot, null, new Point(3, 3), Direction.E);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructorMissingPoint() {
        new PlaceCommand(testRobot, testTable, null, Direction.E);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructorMissingDirection() {
        new PlaceCommand(testRobot, testTable, new Point(3, 3), null);
    }

    @Test(expected = IllegalStateException.class)
    public void testPlaceByondTable() {
        new PlaceCommand(testRobot, testTable, new Point(5, 3), Direction.E).execute();
    }

    @Test
    public void testPlaceOnTableSuccess() {
        new PlaceCommand(testRobot, testTable, new Point(3, 3), Direction.E).execute();
        assertEquals(new Point(3, 3), testRobot.getPosition());
        assertEquals(Direction.E, testRobot.getDirection());
    }
}

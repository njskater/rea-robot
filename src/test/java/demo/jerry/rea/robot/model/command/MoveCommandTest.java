package demo.jerry.rea.robot.model.command;


import org.junit.Test;

import demo.jerry.rea.robot.model.Direction;
import demo.jerry.rea.robot.model.Point;
import demo.jerry.rea.robot.model.Robot;
import demo.jerry.rea.robot.model.Table;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for {@link MoveCommand} class.
 * @author jzhang
 *
 */
public class MoveCommandTest {

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstruction() {
        new MoveCommand(new Robot(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstruction2() {
        new MoveCommand(null, new Table(4, 4));
    }

    @Test(expected = IllegalStateException.class)
    public void testMoveWithoutCurrentPosition() {
        final Robot testRobot = new Robot();
        testRobot.setDirection(Direction.E);
        new MoveCommand(testRobot, new Table(5, 5)).execute();
    }

    @Test(expected = IllegalStateException.class)
    public void testMoveWithoutCurrentDirection() {
        final Robot testRobot = new Robot();
        testRobot.setPosition(new Point(3, 3));
        new MoveCommand(testRobot, new Table(5, 5)).execute();
    }

    @Test(expected = IllegalStateException.class)
    public void testMoveBeyondBoundary() {
        final Robot testRobot = new Robot();
        testRobot.setDirection(Direction.E);
        testRobot.setPosition(new Point(4, 4));
        new MoveCommand(testRobot, new Table(5, 5)).execute();
    }

    @Test
    public void testValidMoveWest() {
        final Robot testRobot = new Robot();
        testRobot.setDirection(Direction.W);
        testRobot.setPosition(new Point(4, 3));
        new MoveCommand(testRobot, new Table(5, 5)).execute();
        assertEquals(new Point(3, 3), testRobot.getPosition());
        assertEquals(Direction.W, testRobot.getDirection());
    }

    @Test
    public void testValidMoveEast() {
        final Robot testRobot = new Robot();
        testRobot.setDirection(Direction.E);
        testRobot.setPosition(new Point(3, 3));
        new MoveCommand(testRobot, new Table(5, 5)).execute();
        assertEquals(new Point(4, 3), testRobot.getPosition());
        assertEquals(Direction.E, testRobot.getDirection());
    }

    @Test
    public void testValidMoveSouth() {
        final Robot testRobot = new Robot();
        testRobot.setDirection(Direction.S);
        testRobot.setPosition(new Point(3, 3));
        new MoveCommand(testRobot, new Table(5, 5)).execute();
        assertEquals(new Point(3, 2), testRobot.getPosition());
        assertEquals(Direction.S, testRobot.getDirection());
    }

    @Test
    public void testValidMoveNorth() {
        final Robot testRobot = new Robot();
        testRobot.setDirection(Direction.N);
        testRobot.setPosition(new Point(3, 3));
        new MoveCommand(testRobot, new Table(5, 5)).execute();
        assertEquals(new Point(3, 4), testRobot.getPosition());
        assertEquals(Direction.N, testRobot.getDirection());
    }
}

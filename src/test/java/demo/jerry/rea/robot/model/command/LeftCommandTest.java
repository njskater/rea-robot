package demo.jerry.rea.robot.model.command;

import org.junit.Test;

import demo.jerry.rea.robot.model.Direction;
import demo.jerry.rea.robot.model.Robot;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for {@link LeftCommand} class.
 * @author jzhang
 */
public class LeftCommandTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructWithIllegalArgument() {
        new LeftCommand(null);
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidCommand() {
        final LeftCommand c = new LeftCommand(new Robot());
        c.execute();
    }

    @Test
    public void testSuccessfulCommand() {
        final Robot testRobot = new Robot();
        testRobot.setDirection(Direction.E);
        new LeftCommand(testRobot).execute();;

        assertEquals(Direction.N, testRobot.getDirection());
    }
}

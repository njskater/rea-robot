package demo.jerry.rea.robot.model.command;

import org.junit.Test;

import demo.jerry.rea.robot.model.Direction;
import demo.jerry.rea.robot.model.Robot;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for {@link RightCommand} class.
 * @author jzhang
 *
 */
public class RightCommandTest {
    @Test(expected = IllegalArgumentException.class)
    public void testConstructWithIllegalArgument() {
        new RightCommand(null);
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidCommand() {
        final RightCommand c = new RightCommand(new Robot());
        c.execute();
    }

    @Test
    public void testSuccessfulCommand() {
        final Robot testRobot = new Robot();
        testRobot.setDirection(Direction.E);
        new RightCommand(testRobot).execute();;

        assertEquals(Direction.S, testRobot.getDirection());
    }
}

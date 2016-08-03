package demo.jerry.rea.robot.model.command;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import demo.jerry.rea.robot.model.Direction;
import demo.jerry.rea.robot.model.Point;
import demo.jerry.rea.robot.model.Robot;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for {@link ReportCommand} class
 * @author jzhang
 *
 */
public class ReportCommandTest {
    private OutputStream os;
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    @Before
    public void setup() {
        os = System.out;
        System.setOut(new PrintStream(bos));
    }

    @After
    public void teardown() {
        System.setOut(new PrintStream(os));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalConstructor() {
        new ReportCommand(null);
    }

    @Test
    public void testReportCommandForUnknownState() {
        new ReportCommand(new Robot()).execute();
        assertEquals("Position: Unknown Direction:Unknown\n", bos.toString());
    }

    @Test
    public void testReportCommandForKnownState() {
        final Robot testRobot = new Robot();
        testRobot.setDirection(Direction.E);
        testRobot.setPosition(new Point(3, 3));
        new ReportCommand(testRobot).execute();
        assertEquals("Position: [3, 3] Direction:East\n", bos.toString());
    }

}

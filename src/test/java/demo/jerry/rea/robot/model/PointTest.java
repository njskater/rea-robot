package demo.jerry.rea.robot.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for {@link Point} class.
 * @author jzhang
 */
public class PointTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructWithIllegalValue() {
        new Point(-50, -23);
    }

    @Test
    public void testConstuctSuccess() {
        final int testX = 3;
        final int testY = 5;
        final Point testPoint = new Point(testX, testY);

        assertEquals(testX, testPoint.getPosX());
        assertEquals(testY, testPoint.getPosY());
    }

    @Test
    public void testToString() {
        final Point testPoint = new Point(11, 22);
        assertEquals("[11, 22]", testPoint.toString());
    }
}


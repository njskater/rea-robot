package demo.jerry.rea.robot.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for {@link Table} class.
 * @author jzhang
 *
 */
public class TableTest {

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalConstructor() {
        new Table(0, 0);
    }

    @Test
    public void testOnTable() {
        final Table testTable = new Table(5, 5);

        assertTrue(testTable.onTable(new Point(0, 0)));
        assertTrue(testTable.onTable(new Point(2, 3)));
        assertTrue(testTable.onTable(new Point(4, 4)));
        assertTrue(testTable.onTable(new Point(4, 0)));
        assertTrue(testTable.onTable(new Point(0, 4)));
    }

    @Test
    public void testNotOnTable() {
        final Table testTable = new Table(5, 5);

        assertFalse(testTable.onTable(new Point(5, 0)));
        assertFalse(testTable.onTable(new Point(0, 5)));
        assertFalse(testTable.onTable(new Point(5, 5)));
        assertFalse(testTable.onTable(new Point(10, 7)));
    }
}


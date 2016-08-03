package demo.jerry.rea.robot.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for {@link Direction} class.
 * @author jzhang
 */
public class DirectionTest {

    @Test
    public void testLeft() {
        assertEquals(Direction.N, Direction.E.left());
        assertEquals(Direction.S, Direction.W.left());
        assertEquals(Direction.W, Direction.N.left());
        assertEquals(Direction.E, Direction.S.left());
    }

    @Test
    public void testRight() {
        assertEquals(Direction.S, Direction.E.right());
        assertEquals(Direction.N, Direction.W.right());
        assertEquals(Direction.E, Direction.N.right());
        assertEquals(Direction.W, Direction.S.right());
    }

    @Test
    public void testParseSuccess() {
        assertEquals(Direction.E, Direction.parse("EAST"));
        assertEquals(Direction.E, Direction.parse("east"));
        assertEquals(Direction.S, Direction.parse("SOUTH"));
        assertEquals(Direction.S, Direction.parse("south"));
        assertEquals(Direction.W, Direction.parse("WEST"));
        assertEquals(Direction.W, Direction.parse("west"));
        assertEquals(Direction.N, Direction.parse("North"));
        assertEquals(Direction.N, Direction.parse("north"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseEmptyString() {
        Direction.parse("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseNull() {
        Direction.parse(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseInvalidString() {
        Direction.parse("abc");
    }

}


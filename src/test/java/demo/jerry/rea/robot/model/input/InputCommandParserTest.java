package demo.jerry.rea.robot.model.input;

import org.junit.Before;
import org.junit.Test;

import demo.jerry.rea.robot.exception.InvalidInputCommandException;
import demo.jerry.rea.robot.input.InputCommand;
import demo.jerry.rea.robot.input.InputCommandParser;
import static demo.jerry.rea.robot.input.InputCommand.CommandKeyword.LEFT;
import static demo.jerry.rea.robot.input.InputCommand.CommandKeyword.MOVE;
import static demo.jerry.rea.robot.input.InputCommand.CommandKeyword.PLACE;
import static demo.jerry.rea.robot.input.InputCommand.CommandKeyword.REPORT;
import static demo.jerry.rea.robot.input.InputCommand.CommandKeyword.RIGHT;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for {@link InputCommand}.
 * @author jzhang
 */
public class InputCommandParserTest {

    private InputCommandParser parser;

    @Before
    public void setup() {
        parser = new InputCommandParser();
    }

    @Test(expected = InvalidInputCommandException.class)
    public void testParseNull() {
        parser.parseCommand(null);
    }

    @Test(expected = InvalidInputCommandException.class)
    public void testParseEmpty() {
        parser.parseCommand("");
    }

    @Test(expected = InvalidInputCommandException.class)
    public void testParseBlank() {
        parser.parseCommand(" ");
    }

    @Test(expected = InvalidInputCommandException.class)
    public void testParseInvalidKeyword() {
        parser.parseCommand("ABC");
    }

    @Test(expected = InvalidInputCommandException.class)
    public void testParseInvalidKeywordWithParameters() {
        parser.parseCommand("ABC 1,2");
    }

    @Test
    public void testParseValidKeywordOnly() {
        assertEquals(MOVE, parser.parseCommand("MOVE").getCommandKeyword());
        assertEquals(LEFT, parser.parseCommand("LEFT").getCommandKeyword());
        assertEquals(RIGHT, parser.parseCommand("RIGHT").getCommandKeyword());
        assertEquals(REPORT, parser.parseCommand("REPORT").getCommandKeyword());
        assertEquals(PLACE, parser.parseCommand("PLACE 1,2,NORTH").getCommandKeyword());
    }

    public void testParseValidKeywordAndParameters() {
        final InputCommand parsedCommand = parser.parseCommand("PLACE 0,1,NORTH");
        assertEquals(PLACE, parsedCommand.getCommandKeyword());
        assertEquals(3, parsedCommand.getParameters().size());
        assertEquals("0", parsedCommand.getParameters().get(0));
        assertEquals("1", parsedCommand.getParameters().get(1));
        assertEquals("2", parsedCommand.getParameters().get(2));
    }
}

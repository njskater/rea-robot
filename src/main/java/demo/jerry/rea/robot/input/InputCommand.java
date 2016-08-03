package demo.jerry.rea.robot.input;

import java.util.Collections;
import java.util.List;

/**
 * Represents Normalised Command that consists of one keyword and zero to many parameters.
 * @author jzhang
 *
 */
public class InputCommand {
    public enum CommandKeyword { PLACE, MOVE, LEFT, RIGHT, REPORT, EXIT }

    private final CommandKeyword commandKeyword;
    private final List<String> parameters;

    /**
     * Construct an InputCommand by given command key word and parameter list.
     * @param commandKeyword Keyword of this InputComand.
     * @param parameters Optional parameter list, null represents no parameter.
     */
    public InputCommand(final CommandKeyword commandKeyword, final List<String> parameters) {
        this.commandKeyword = commandKeyword;
        this.parameters = parameters == null ? null : Collections.unmodifiableList(parameters);
    }

    public CommandKeyword getCommandKeyword() {
        return commandKeyword;
    }

    public List<String> getParameters() {
        return parameters;
    }
}
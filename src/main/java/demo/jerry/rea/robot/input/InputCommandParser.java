package demo.jerry.rea.robot.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.jerry.rea.robot.exception.InvalidInputCommandException;
import demo.jerry.rea.robot.input.InputCommand.CommandKeyword;
import demo.jerry.rea.robot.model.Direction;
import static java.lang.Integer.parseInt;

/**
 * This class parses String command and convert it to {@link InputCommand}.
 * @author jzhang
 *
 */
public class InputCommandParser {
    private static final String PARSER_INSTRUCTION = "Please use following command to control robot:\n "
            + "PLACE x,y,[NORTH|EAST|SOUTH|WEST], MOVE, LEFT, RIGHT, REPORT, EXIT\n";
    private static final String PLACE_CMD_ERROR_STRING = "PLACE command parameters cannot be recognised, valid example is: PLACE 0,1,NORTH";


    /**
     * Parse provided String command. Assuming command is case insensitive. Expected
     * format is KeyWord Param1,Param2,Param3, no space between parameter is allowed.
     * @param command String command that contains keyword and optional parameters.
     * @return parsed {@link InputCommand}.
     */
    public InputCommand parseCommand(final String command) {
        if (command == null) {
            throw new InvalidInputCommandException(PARSER_INSTRUCTION);
        }

        try (final Scanner scanner = new Scanner(command)) {
            List<String> parameters = null;
            CommandKeyword commandKeyword = null;
            while (scanner.hasNext()) {
                if (commandKeyword == null) {
                    commandKeyword = parseCommandKeyword(scanner);
                    continue;
                }

                parameters = parseParameter(scanner.next());

                break;
            }

            if (commandKeyword != null) {
                final InputCommand inputCommand = new InputCommand(commandKeyword, parameters);
                validateInputCommand(inputCommand);
                return inputCommand;
            }
            throw new InvalidInputCommandException(PARSER_INSTRUCTION);
        }
    }

    private void validateInputCommand(final InputCommand command) {
        if (command.getCommandKeyword() == CommandKeyword.PLACE) {
            final List<String> params = command.getParameters();
            if (params == null || params.size() < 3) {
                throw new InvalidInputCommandException(PLACE_CMD_ERROR_STRING);
            }

            try {
                parseInt(params.get(0));
                parseInt(params.get(1));
                Direction.parse(params.get(2));
            } catch (final NumberFormatException e) {
                throw new InvalidInputCommandException(PLACE_CMD_ERROR_STRING, e);
            } catch (final IllegalArgumentException e) {
                throw new InvalidInputCommandException(PLACE_CMD_ERROR_STRING, e);
            }
        }
    }

    private CommandKeyword parseCommandKeyword(final Scanner scanner) {
        final String commandText = scanner.next();
        if (commandText == null || commandText.trim().isEmpty()) {
            throw new InvalidInputCommandException(PARSER_INSTRUCTION);
        }

        try {
            final CommandKeyword currentCommand = CommandKeyword.valueOf(commandText.toUpperCase());
            return currentCommand;
        } catch (final IllegalArgumentException e) {
            throw new InvalidInputCommandException(PARSER_INSTRUCTION);
        }
    }

    private List<String> parseParameter(final String parameters) {
        final List<String> paramList = new ArrayList<>();
        try (final Scanner scanner = new Scanner(parameters)) {
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                paramList.add(scanner.next().trim());
            }
        }
        return paramList;
    }

}

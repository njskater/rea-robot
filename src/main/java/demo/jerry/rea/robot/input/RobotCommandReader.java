package demo.jerry.rea.robot.input;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import demo.jerry.rea.robot.exception.InvalidInputCommandException;
import demo.jerry.rea.robot.model.command.RobotCommand;

/**
 * A {@link CommandReader} that reads command and convert to {@link RobotCommand} to execute.
 * @author jzhang
 */
public class RobotCommandReader implements CommandReader {

    private static final String LINE_SEPARATOR = "line.separator";

    private static final Log LOG = LogFactory.getLog(RobotCommandReader.class);

    private final RobotCommandFactory commandFactory;

    public RobotCommandReader(final RobotCommandFactory commandFactory) {
        if (commandFactory == null) {
            throw new IllegalArgumentException("commandFactory must be provided.");
        }
        this.commandFactory = commandFactory;
    }

    @Override
    public void readCommand(final InputStream in) {
        try (final Scanner scanner = new Scanner(in)) {
            scanner.useDelimiter(System.getProperty(LINE_SEPARATOR));

            while (scanner.hasNextLine()) {

                try {
                    final String nextToken = scanner.nextLine();
                    if ("EXIT".equalsIgnoreCase(nextToken)) {
                        System.exit(0);
                    }
                    this.commandFactory.createRobotCommand(nextToken).execute();
                } catch (final InvalidInputCommandException e) {
                    System.out.println(e.getMessage());
                } catch (final IllegalArgumentException e) {
                    LOG.warn(e.getMessage());
                } catch (final IllegalStateException e) {
                    LOG.warn(e.getMessage());
                } catch (final Exception e) {
                    LOG.error("Error encountered: ", e);
                }
            }
        }
    }

}

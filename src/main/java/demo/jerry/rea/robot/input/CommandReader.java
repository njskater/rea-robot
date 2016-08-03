package demo.jerry.rea.robot.input;

import java.io.InputStream;

/**
 * Classes that implement this interface shold provide a
 * concrete away of read command from {@link InputStream}.
 * @author jzhang
 *
 */
public interface CommandReader {

    /**
     * Read command from {@link InputStream}.
     * @param in
     */
    void readCommand(InputStream in);
}

package demo.jerry.rea.robot.model.input;

import java.io.ByteArrayInputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import demo.jerry.rea.robot.input.RobotCommandFactory;
import demo.jerry.rea.robot.input.RobotCommandReader;
import demo.jerry.rea.robot.model.command.RobotCommand;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Unit test for {@link RobotCommandReader}.
 * @author jzhang
 */
@RunWith(MockitoJUnitRunner.class)
public class RobotCommandReaderTest {

    @Mock
    private RobotCommandFactory robotCommandFactory;

    @Mock
    private RobotCommand robotCommand;

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorMissingCommandFactory() {
        new RobotCommandReader(null);
    }

    @Test
    public void testRead() {
        Mockito.when(robotCommandFactory.createRobotCommand("TEST")).thenReturn(robotCommand);

        new RobotCommandReader(robotCommandFactory).readCommand(new ByteArrayInputStream("TEST\nTEST\n".getBytes()));
        verify(robotCommandFactory, times(2)).createRobotCommand("TEST");
    }
}

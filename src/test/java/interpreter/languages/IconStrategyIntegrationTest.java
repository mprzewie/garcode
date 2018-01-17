package interpreter.languages;

import exerciseCreator.databaseProvider.entity.TestCase;
import interpreter.ExitValue;
import interpreter.Interpreter;
import interpreter.Result;
import interpreter.processing.exceptions.ProcessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("IntegrationTest")
public class IconStrategyIntegrationTest {
    private Interpreter interpreter;
    private String testCodes = "src/test/resources/testCodes/Icon/";
    private TestCase testCaseMock = new TestCase("2", "2", 1);
    private List<TestCase> caseMocks = Collections.singletonList(testCaseMock);

    private String example = "icon_example.icn";
    private String syntaxErr = "icon_syntaxerr.icn";
    private String infinite = "icon_infinite.icn";
    private String cmd = "icon_cmd.icn";
    private String runtimeErr = "icon_runtimeerr.icn";

    @BeforeEach
    void setUp() {
        this.interpreter = new Interpreter(new IconStrategy());
    }

    @Test
    void interpretationsResultsCountTest() {
        List<Result> results = interpreter.executeSolution(new File(testCodes + example), caseMocks);
        assertEquals(caseMocks.size(), results.size());
    }

    @Test
    void interpretationResultStdOutTest() throws ProcessException {
        List<Result> results = interpreter.executeSolution(new File(testCodes + example), caseMocks);
        assertTrue(results.get(0).getStdOut().orElse("").contains("garcode"));
    }

    @Test
    void interpretationResultStdErrTest() throws ProcessException {
        List<Result> results = interpreter.executeSolution(new File(testCodes + runtimeErr), caseMocks);
        System.out.println(results.get(0).getStdErr().orElse("nostdErr"));
        System.out.println(results.get(0).getStdOut().orElse("nostdOut"));
        System.out.println(results.get(0).getExitValue());
        assertTrue(results.get(0).getStdErr().orElse("").contains("error"));
    }

    @Test
    void interpretationExecutionTimeTest() throws ProcessException {
        List<Result> results = interpreter.executeSolution(new File(testCodes + example), caseMocks);
        assertTrue(results.get(0).getExecutionTime().toMillis()/1000 < testCaseMock.getTimeLimit());
    }

    @Test
    void interpretationResultErrnoNormalExecutionTest() {
        List<Result> results = interpreter.executeSolution(new File(testCodes + example), caseMocks);
        assertEquals(ExitValue.NORMAL_EXECUTION, results.get(0).getExitValue());
    }

    @Test
    void interpretationResultErrnoCompilationErrorTest() {
        List<Result> results = interpreter.executeSolution(new File(testCodes + syntaxErr), caseMocks);
        assertEquals(ExitValue.COMPILATION_ERR, results.get(0).getExitValue());
    }
    @Test
    void timeoutErrnoTest() {
        List<Result> results = interpreter.executeSolution(new File(testCodes + infinite), caseMocks);
        assertEquals(ExitValue.TERMINATED, results.get(0).getExitValue());
    }

    @Test
    void timeoutTest() {
        List<Result> results = interpreter.executeSolution(new File(testCodes + infinite), caseMocks);
        assertFalse(results.get(0).getStdOut().isPresent());
    }

    @Test
    void cmdTest() throws ProcessException {
        List<Result> results = interpreter.executeSolution(new File(testCodes + cmd), caseMocks);
        assertEquals(testCaseMock.getResultOutputWithNewLine(), results.get(0).getStdOut().get());
    }
}





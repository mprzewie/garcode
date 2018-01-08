package interpreter.languages;

import exerciseCreator.databaseProvider.entity.TestCase;
import interpreter.ExitValue;
import interpreter.Interpreter;
import interpreter.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PythonInterpreterIntegrationTest {

    private Interpreter interpreter;
    private String testCodes = "src/test/resources/testCodes/python/";
    private TestCase testCaseMock = new TestCase("", "", 1, 0);
    private List<TestCase> caseMocks = Collections.singletonList(testCaseMock);

    private String example = "python_example.py";
    private String syntaxErr = "python_syntaxerr.py";
    private String infinite = "python_infinite.py";
    private String badPackage = "python_package_err.py";

    @BeforeEach
    void setUp() {
        this.interpreter = new PythonInterpreter();
    }


    @Test
    void interpretationsResultsCount(){
        List<Result> results = interpreter.executeSolution(new File(testCodes + example), caseMocks);
        assertTrue(results.size() == caseMocks.size());
    }

    @Test
    void interpretationResultStdOut() {
        List<Result> results = interpreter.executeSolution(new File(testCodes + example), caseMocks);
        assertTrue(results.get(0).getStdOut().orElse("").contains("python_example"));

    }

    @Test
    void interpretationResultStdErr() {
        List<Result> results = interpreter.executeSolution(new File(testCodes + syntaxErr), caseMocks);
        assertTrue(results.get(0).getStdErr().orElse("").contains("SyntaxError"));
    }

    @Test
    void interpretationResultErrno1() {
        List<Result> results = interpreter.executeSolution(new File(testCodes + example), caseMocks);
        assertTrue(results.get(0).getExitValue() == ExitValue.NORMAL_EXECUTION);
    }

    @Test
    void interpretationResultErrno2() {
        List<Result> results = interpreter.executeSolution(new File(testCodes + syntaxErr), caseMocks);
        assertTrue(results.get(0).getExitValue() == ExitValue.UNKNOWN);
    }

    @Test
    void timeoutTest(){
        List<Result> results = interpreter.executeSolution(new File(testCodes + infinite), caseMocks);
        assertFalse(results.get(0).getStdOut().isPresent());
    }

    @Test
    void timeoutTestErrno(){
        List<Result> results = interpreter.executeSolution(new File(testCodes + infinite), caseMocks);
        assertTrue(results.get(0).getExitValue() == ExitValue.TERMINATED);
    }

    @Test
    void badPackageTest(){
        List<Result> results = interpreter.executeSolution(new File(testCodes + badPackage), caseMocks);
        assertTrue(results.get(0).getExitValue() == ExitValue.IMPORT_ERR);
    }

    @Test
    void noPackageTest(){
        List<Result> results = interpreter.executeSolution(new File(testCodes + example), caseMocks);
        assertFalse(results.get(0).getExitValue() == ExitValue.IMPORT_ERR);
    }


}
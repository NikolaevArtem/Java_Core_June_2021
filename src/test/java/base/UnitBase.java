package base;

import homework_2.pyramid_printer.PyramidPrinter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class UnitBase {

    protected final PrintStream originalOut = System.out;
    protected final InputStream originalIn = System.in;
    protected ByteArrayOutputStream mockedOut = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(mockedOut));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    // mock input as if you wrote it to console by hand
    protected void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    // returns whole output as string, will all line separators and etc
    protected String getOutput() {
        return mockedOut.toString().trim();
    }

    // output as array, separated by lines. First line - getOutputLines()[0], and so on
    protected String[] getOutputLines() {
        return getOutput().split("\\r?\\n");
    }

    // can be used to remove some strings from output (ex. remove "Please input number"). Put after run()
    protected void removeFromOutput(String s) {
        try {
            String output = mockedOut.toString();
            mockedOut.reset();
            mockedOut.write(output.replace(s, "").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // can be used to print output to testing console. Useful for debugging. Put after run();
    protected void printOut() {
        System.setOut(originalOut);
        System.out.println(mockedOut);
        System.setOut(new PrintStream(mockedOut));
    }
/*
    @Test
    void example() throws IOException {
        setInput("2");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please input number");

        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
    }*/

}

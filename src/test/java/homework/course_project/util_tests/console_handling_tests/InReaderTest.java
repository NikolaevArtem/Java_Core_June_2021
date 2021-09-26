package homework.course_project.util_tests.console_handling_tests;

import course_project.Utils.ConsoleHandling.InReader;
import course_project.components.Coordinates;
import homework.unit_base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class InReaderTest extends UnitBase {
    final String ERR_MSG = "Something is wrong with input, try again";
    final String WRONG_DESTINATION = "Wrong destination input, try again!";
    @Test
    void givenString_whenStringA1_thenCoordinateReturned() {
        String input = "A1";
        Coordinates result;
        setInput(input);
        result = new InReader().readCoordinates();

        assertNotNull(result);
    }

    @Test
    void givenBadString_whenStringSTR_thenErrorPrinted() {
        String input = "String\n" + "a1";

        setInput(input);
        new InReader().readCoordinates();   //recursively called, need second argument in case of mistaken input

        assertEquals(ERR_MSG, getOutputLines()[0]);
    }

    @Test
    void givenNothing_whenStringIsEmpty_thenErrorPrinted() {
        String input = "\n" + "a1";

        setInput(input);
        new InReader().readCoordinates();   //recursively called, need second argument in case of mistaken input

        assertEquals(ERR_MSG, getOutputLines()[0]);
    }

    @Test
    void givenArguments_whenGetCoordinatesByDestinationCalled_thenCoordinatesListReturned(){
        Coordinates start = new Coordinates(1,1);
        int size = 4;
        String destination = "right";

        List<Coordinates> expected = new ArrayList<>();
        expected.add(start);
        Coordinates c1 = new Coordinates(2,1);
        expected.add(c1);
        Coordinates c2 = new Coordinates(3,1);
        expected.add(c2);
        Coordinates c3 = new Coordinates(4,1);
        expected.add(c3);

        List<Coordinates> result = new InReader().getCoordinatesByDestination(start, size, destination);

        assertEquals(expected, result);
    }

    @Test
    void givenBadString_whenGetDestinationCalled_thenErrorPrinted() {
        String input = "String\n" + "left";

        setInput(input);
        new InReader().getDestination();   //recursively called, need second argument in case of mistaken input

        assertEquals(WRONG_DESTINATION, getOutputLines()[0]);
    }

    @Test
    void givenEmptyString_whenGetDestinationCalled_thenErrorPrinted() {
        String input = "\n" + "left";

        setInput(input);
        new InReader().getDestination();   //recursively called, need second argument in case of mistaken input

        assertEquals(WRONG_DESTINATION, getOutputLines()[0]);
    }

    @Test
    void givenCorrectInput_whenGetDestinationCalled_thenStringReturned() {
        String input = "LefT";
        String expected = "left";
        setInput(input);
        String result = new InReader().getDestination();

        assertEquals(expected, result);
    }

    @Test
    void givenSomeInput_whenGetModeCalled_thenFalseReturned() {
        String input = "anything";
        setInput(input);

        assertFalse(new InReader().getMode());
    }

    @Test
    void givenNoInput_whenGetModeCalled_thenTrueReturned() {
        String input = "";
        setInput(input);

        assertTrue(new InReader().getMode());
    }


}

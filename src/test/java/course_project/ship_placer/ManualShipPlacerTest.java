package course_project.ship_placer;

import base.UnitBase;
import course_project.input_readers.InputReader;
import course_project.players.Human;
import course_project.players.Player;
import course_project.ship_placers.ManualShipPlacer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManualShipPlacerTest extends UnitBase {

    @Test
    void givenShipPlacer_whenShipsPlace_thenNewShipPlacerPlaceShips() {
        List<String> input = Arrays.asList(
                " ", "A1", "A5", "A3", "A7",
                "J1 I1", "C7 C6", "C1 C2",
                "J10 H10", "H7 J7", "F1 F4");
        Iterator<String> iterator = input.iterator();
        InputReader reader = (iterator::next);
        Player human = new Human(reader);
        new ManualShipPlacer(human, reader).placeShips();
        getOutput();
        assertEquals("   A B C D E F G H I J", getOutputLines()[getOutputLines().length - 11]);
        assertEquals(" 1 O ~ O ~ ~ O ~ ~ O O", getOutputLines()[getOutputLines().length - 10]);
        assertEquals(" 2 ~ ~ O ~ ~ O ~ ~ ~ ~", getOutputLines()[getOutputLines().length - 9]);
        assertEquals(" 3 O ~ ~ ~ ~ O ~ ~ ~ ~", getOutputLines()[getOutputLines().length - 8]);
        assertEquals(" 4 ~ ~ ~ ~ ~ O ~ ~ ~ ~", getOutputLines()[getOutputLines().length - 7]);
        assertEquals(" 5 O ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[getOutputLines().length - 6]);
        assertEquals(" 6 ~ ~ O ~ ~ ~ ~ ~ ~ ~", getOutputLines()[getOutputLines().length - 5]);
        assertEquals(" 7 O ~ O ~ ~ ~ ~ O O O", getOutputLines()[getOutputLines().length - 4]);
        assertEquals(" 8 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[getOutputLines().length - 3]);
        assertEquals(" 9 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[getOutputLines().length - 2]);
        assertEquals("10 ~ ~ ~ ~ ~ ~ ~ O O O", getOutputLines()[getOutputLines().length - 1]);
    }

    @Test
    void givenShipPlacerAndSomeWrongInput_whenShipsPlace_thenPrintWarnings() {
        List<String> input = Arrays.asList(
                " ", "A1", "A5", "A3", "A7",
                "J1 I1", "C7 C6", "C1 C2",
                "J10 H10", "H7 J7",
                "H1 H4", "A7 A10", "DF",  //wrong Input is here
                "F1 F4");
        Iterator<String> iterator = input.iterator();
        InputReader reader = (iterator::next);
        Player human = new Human(reader);
        new ManualShipPlacer(human, reader).placeShips();
        String requestInput = "Input two coordinates for Four deck ship: ";
        String invalidInputWarning = requestInput + "Invalid format or count of coordinates." +
                " A ship must be placed in a line. " +
                "Try again. Examples: A7 A10 or B1";
        String tooCloseWarning = requestInput + "Too close to another ship. Choose another place.";
        String unavailableCellsWarning = requestInput + "Chosen cells are unavailable. Please, choose other.";
        getOutput();
        assertEquals(tooCloseWarning, getOutputLines()[getOutputLines().length - 15]);
        assertEquals(unavailableCellsWarning, getOutputLines()[getOutputLines().length - 14]);
        assertEquals(invalidInputWarning, getOutputLines()[getOutputLines().length - 13]);
        assertEquals("   A B C D E F G H I J", getOutputLines()[getOutputLines().length - 11]);
        assertEquals(" 1 O ~ O ~ ~ O ~ ~ O O", getOutputLines()[getOutputLines().length - 10]);
        assertEquals(" 2 ~ ~ O ~ ~ O ~ ~ ~ ~", getOutputLines()[getOutputLines().length - 9]);
        assertEquals(" 3 O ~ ~ ~ ~ O ~ ~ ~ ~", getOutputLines()[getOutputLines().length - 8]);
        assertEquals(" 4 ~ ~ ~ ~ ~ O ~ ~ ~ ~", getOutputLines()[getOutputLines().length - 7]);
        assertEquals(" 5 O ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[getOutputLines().length - 6]);
        assertEquals(" 6 ~ ~ O ~ ~ ~ ~ ~ ~ ~", getOutputLines()[getOutputLines().length - 5]);
        assertEquals(" 7 O ~ O ~ ~ ~ ~ O O O", getOutputLines()[getOutputLines().length - 4]);
        assertEquals(" 8 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[getOutputLines().length - 3]);
        assertEquals(" 9 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[getOutputLines().length - 2]);
        assertEquals("10 ~ ~ ~ ~ ~ ~ ~ O O O", getOutputLines()[getOutputLines().length - 1]);
    }


}

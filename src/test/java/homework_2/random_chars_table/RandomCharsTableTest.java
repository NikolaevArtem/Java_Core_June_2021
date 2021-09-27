package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;


public class RandomCharsTableTest extends UnitBase {
    protected final String GREET = "Enter the dimensions of matrix and required strategy : two integers and required strategy - even|odd, delimiter - space character))";
    protected final String HINT = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";
    protected HashSet<Character> validLetters;
    protected HashSet<Character> evenLetters;
    protected HashSet<Character> oddLetters;
    protected RandomCharsTable randomCharsTable = new RandomCharsTable();

    @BeforeEach
    protected void initializeForTests (){
        validLetters = new HashSet<>();
        evenLetters = new HashSet<>();
        oddLetters = new HashSet<>();
        for (int i = 65; i <= 90; i++){
            validLetters.add((char) i);
            if (i % 2 == 0) {
                evenLetters.add((char) i);
            }
            else {
                oddLetters.add((char) i);
            }
        }

    }
    private boolean isValidCharTableDelimiters(String str, Character delimiterChar){
        for (int i = 0; i < str.length(); i = i + 2) {
            if (str.charAt(i) != delimiterChar) {
                return false;
            }
        }
        return true;

    }

    private boolean isValidCharTable(String[] strings, int rows, int cols){
        if (strings.length -1 != rows){
            return false;
        }
        for (int i = 0; i < strings.length - 1; i++) {
            String currStr  = strings[i];
            if (!isValidCharTableDelimiters(currStr,'|')){
                return false;
            }
            currStr = currStr.replaceAll( "\\|+","");
            if ( (cols  != currStr.length())){
                return false;
            }
            for (char c : currStr.toCharArray()) {
                if (!validLetters.contains(c)){
                    return false;
                }
            }
        }
        return true;

    }
    private boolean isValidLastStringForEven(String str){
        str = str.replaceAll("(Even letters -)|(\\s+)|(,+)", "");
        for (char c : str.toCharArray()) {
            if (oddLetters.contains(c)){
                return false;
            }
        }
        return true;

    }
    private boolean isValidLastStringForOdd(String str){
        str = str.replaceAll("(Odd letters -)|(\\s+)|(,+)", "");
        for (char c : str.toCharArray()) {
            if (evenLetters.contains(c)){
                return false;
            }
        }
        return true;

    }

    @Test
    void given2_2_even_whenOk_thenOk (){
        setInput("2 2 even");
        randomCharsTable.run();
        printOut();
        removeFromOutput(GREET);
        assertTrue(isValidCharTable(getOutputLines(), 2, 2));
        assertTrue(isValidLastStringForEven(getOutputLines()[getOutputLines().length-1]));

    }

    @Test
    void given2_3_odd_whenOk_thenOk (){
        setInput("2 3 odd");
        randomCharsTable.run();
        printOut();
        removeFromOutput(GREET);
        assertTrue(isValidCharTable(getOutputLines(), 2, 3));
        assertTrue(isValidLastStringForOdd(getOutputLines()[getOutputLines().length-1]));

    }

    @Test
    void given15_10_odd_whenOk_thenOk (){
        setInput("15 10 odd");
        randomCharsTable.run();
        printOut();
        removeFromOutput(GREET);
        assertTrue(isValidCharTable(getOutputLines(),15, 10));
        assertTrue(isValidLastStringForOdd(getOutputLines()[getOutputLines().length-1]));

    }

    @Test
    void given0_1_odd_whenBad_thenHint (){
        setInput("0 1 odd");
        randomCharsTable.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals(HINT, getOutputLines()[0]);

    }

    @Test
    void given0_1_even_whenBad_thenHint (){
        setInput("0 1 even");
        randomCharsTable.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals(HINT, getOutputLines()[0]);

    }

    @Test
    void given5_5_event_whenBad_thenHint (){
        setInput("5 5 event");
        randomCharsTable.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals(HINT, getOutputLines()[0]);

    }

    @Test
    void given3_5_add_whenBad_thenHint (){
        setInput("3 5 add");
        randomCharsTable.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals(HINT, getOutputLines()[0]);

    }

    @Test
    void givenNegative_5_odd_whenBad_thenHint (){
        setInput("-3 5 odd");
        randomCharsTable.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals(HINT, getOutputLines()[0]);

    }

    @Test
    void given5_Negative_even_whenBad_thenHint (){
        setInput("5 -5 even");
        randomCharsTable.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals(HINT, getOutputLines()[0]);

    }

}

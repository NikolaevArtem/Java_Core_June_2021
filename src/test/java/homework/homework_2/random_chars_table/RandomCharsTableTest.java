package homework.homework_2.random_chars_table;

import base.UnitBase;
import homework_2.random_chars_table.RandomCharsTable;
import org.junit.jupiter.api.Test;

class RandomCharsTableTest extends UnitBase {
    char[] allChars = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
        'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};


    @Test
    public void givenCorrectInput_whenTwoIntAndCorrectString_thenAllGood() {
        setInput("4 4 odd");

        new RandomCharsTable().run();
        removeFromOutput("Enter two Integers and sorting method, even or odd, e.g.  12 12 odd");
        removeFromOutput("There is an unsorted table:");
        boolean inRange = false;



    }

}
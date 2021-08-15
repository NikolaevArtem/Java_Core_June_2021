package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(value = Parameterized.class)
public class RandomCharsTableParametrizedTest_IT_DOES_NOT_WORK extends UnitBase {
    protected final String GREET = "Enter the dimensions of matrix and required strategy : two integers and required strategy - even|odd, delimiter - space character))";
    protected final String HINT = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";
    private String input;
    protected RandomCharsTable randomCharsTable = new RandomCharsTable();
    public RandomCharsTableParametrizedTest_IT_DOES_NOT_WORK(String input) {
        this.input = input;
    }

    @Parameterized.Parameters()
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][] {
                {"0 1 odd"},
                {"0 1 even"},
                {"5 5 evenn"},
                {"3 5 add"},
        });
    }

    @Test
    void givenBadValues_whenBad_thenHint (){
        setInput(input);
        randomCharsTable.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals(HINT, getOutputLines()[0]);

    }

}

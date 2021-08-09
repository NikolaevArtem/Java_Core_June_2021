package homework_1;

import base.UnitBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HomeworkTest extends UnitBase {

    @Test
    public void ErrorArgumentTest() {
        String[] strings = new String[]{"word", "another word", "error"};
        String[] stringsExpected = new String[]{"word : 4 letters", "another word : 12 letters", "\u001B[41m" + "Alarm!" + "\u001B[0m"};
        Main.main(strings);
        printOut();
        Assertions.assertArrayEquals(stringsExpected, getOutputLines());
    }
}
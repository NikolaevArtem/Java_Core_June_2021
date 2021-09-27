package homework.course_project.util_tests.console_handling_tests;
import course_project.Utils.ConsoleHandling.Printer;
import course_project.components.Field;
import homework.unit_base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class PrinterTest extends UnitBase{

    @Test
    void givenNewField_whenPrintAnyway_thenPrinted(){
        Field testFieldEmpty = new Field();
        String expected = "    A  B  C  D  E  F  G  H  I  J \n" +
                "1   ~  ~  ~  ~  ~  ~  ~  ~  ~  ~ \n" +
                "2   ~  ~  ~  ~  ~  ~  ~  ~  ~  ~ \n" +
                "3   ~  ~  ~  ~  ~  ~  ~  ~  ~  ~ \n" +
                "4   ~  ~  ~  ~  ~  ~  ~  ~  ~  ~ \n" +
                "5   ~  ~  ~  ~  ~  ~  ~  ~  ~  ~ \n" +
                "6   ~  ~  ~  ~  ~  ~  ~  ~  ~  ~ \n" +
                "7   ~  ~  ~  ~  ~  ~  ~  ~  ~  ~ \n" +
                "8   ~  ~  ~  ~  ~  ~  ~  ~  ~  ~ \n" +
                "9   ~  ~  ~  ~  ~  ~  ~  ~  ~  ~ \n" +
                "10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~";
        new Printer().printOpenField(testFieldEmpty);
        assertEquals(expected, "    "  + getOutput());



        new Printer().printHiddenField(testFieldEmpty);











    }

}

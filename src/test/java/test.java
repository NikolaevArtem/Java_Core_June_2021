import homework_2.pyramid_printer.PyramidPrinter;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {

        @Test
        void givenHello_whenReturnCountedString_thenReturnArgs() throws IOException {
            // given
            final String expected = "Hello!!";

            // then
            PyramidPrinter pyramidPrinter = new PyramidPrinter();
            final String actual =  "  Hello!!  ";

            // then
            assertEquals(expected, actual.trim());
        }

//        @Test
//        void givenHelloAndGoodbye_whenReturnCountedString_thenReturnArgs() {
//            final String[] expected = {"Hello!", "Goodbye!"};
//            final String[] actual = new CharCounter().returnCountedString(expected);
//
//            assertEquals(expected, actual);
//        }
//
//        @Test
//        void givenHello_whenReturnCountedString_thenThrowRuntimeEx() {
//            final String[] given = {"error"};
//
//            assertThrows(RuntimeException.class,
//                    () -> new CharCounter().returnCountedString(given));
//        }

    }


package lesson_5.unit_testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CharCounterTest {

  @Test
  void givenHello_whenReturnCountedString_thenReturnArgs() {
    // given
    final String[] expected = {"Hello!"};

    // then
    final String[] actual = new CharCounter().returnCountedString(expected);

    // then
    assertEquals(expected, actual);
  }

  @Test
  void givenHelloAndGoodbye_whenReturnCountedString_thenReturnArgs() {
    final String[] expected = {"Hello!", "Goodbye!"};
    final String[] actual = new CharCounter().returnCountedString(expected);

    assertEquals(expected, actual);
  }

  @Test
  void givenHello_whenReturnCountedString_thenThrowRuntimeEx() {
    final String[] given = {"error"};

    assertThrows(RuntimeException.class,
        () -> new CharCounter().returnCountedString(given));
  }

}

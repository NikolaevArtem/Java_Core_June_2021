package homework_2;

import base.UnitBase;
import homework_2.random_chars_table.RandomCharsTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RandomCharsTableTest extends UnitBase {
   @Test
    public void testOnZeroArg() {
       setInput("0 0 even");
       new RandomCharsTable().run();
       printOut();
       assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutputLines()[0]);
   }
   @Test
   public void testOnEvenOrOddArg() {
      setInput("3 2 notEven");
      new RandomCharsTable().run();
      printOut();
      assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutputLines()[0]);
   }
   @Test
   public void testOnEmptyArg() {
      setInput("");
      new RandomCharsTable().run();

      assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutputLines()[0]);
   }
   @Test
   public void testOnNegativeArg() {
      setInput("-10 -6 even");
      new RandomCharsTable().run();
      printOut();
      assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutputLines()[0]);
   }

}

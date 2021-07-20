package lesson_5.unit_testing;

public class CharCounter {

  public String[] returnCountedString(String[] args) {
    if (args[0].equalsIgnoreCase("error")) {
      throw new RuntimeException("message");
    }
    return args;
  }

}

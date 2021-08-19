package lesson_10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

  public static void main(String[] args) {

    String regex = "((\\|[A-Z]){0,}\\|){0,}";


    String validInput = "|A|";
    String validInput2 = "|F|D|S|";
    String validInput3 = "|BC|";
    String invalidInput = "5";
    System.out.println(Pattern.matches(regex, validInput));

    String input = "artem_nikolaev@epam.com";
    final Pattern compile = Pattern.compile("(\\w*)@(\\w*)\\.(\\w*)");
    final Matcher matcher = compile.matcher(input);
    if (matcher.find()) {
      System.out.println(matcher.group(0));
      System.out.println(matcher.group(1));
      System.out.println(matcher.group(2));
      System.out.println(matcher.group(3));
    }
  }

}

package lesson_10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Strings {

  private static final String JAVA_THE_BEST = "JAVA THE BEST";

  public static void main(String[] args) {
    stringBufferAndStringBuilderMethods();
  }

  private static void stringsSymbolsReading() {
    JAVA_THE_BEST.chars().forEach(l -> System.out.print((char)l));
    System.out.println("");
    JAVA_THE_BEST.length();
    JAVA_THE_BEST.isEmpty();
    System.out.println("JAVA_THE_BEST.charAt(3) = " + JAVA_THE_BEST.charAt(3));
    System.out.println("JAVA_THE_BEST.codePointAt(3) = " + JAVA_THE_BEST.codePointAt(3));
  }

  private static void stringsComparing() {
    String compareS = "java THE best";
    JAVA_THE_BEST.equals(compareS);
    System.out.println("JAVA_THE_BEST.equalsIgnoreCase(compareS) = " + JAVA_THE_BEST.equalsIgnoreCase(compareS));
    JAVA_THE_BEST.compareTo(compareS);
    System.out.println("JAVA_THE_BEST.compareToIgnoreCase(compareS) = " + JAVA_THE_BEST.compareToIgnoreCase(compareS));
    JAVA_THE_BEST.contentEquals(compareS);
  }

  private static void stringsIntern() {
    String s = new String("abcd");
    s = s.intern();
    final String sCopy = "abcd";
    System.out.println(s == sCopy);

    final String sAnotherCopy = new StringBuffer().append("abcd").toString();
    System.out.println(sCopy == sAnotherCopy);
  }

  private static void stringSearching() {
    JAVA_THE_BEST.indexOf("THE");
    JAVA_THE_BEST.contains("JA");
    JAVA_THE_BEST.startsWith("JAVA");
    JAVA_THE_BEST.endsWith("BEST");
    final CharSequence charSequence = JAVA_THE_BEST.subSequence(5, 8);
    final String substring = JAVA_THE_BEST.substring(5, 8);
    System.out.println(substring.contentEquals(charSequence));
  }

  private static void stringsChanging() {
    JAVA_THE_BEST.trim();
    JAVA_THE_BEST.substring(3, 5);
    JAVA_THE_BEST.subSequence(3, 5);
    JAVA_THE_BEST.toString();
    String.valueOf(5);
    int newint = 5;
    System.out.printf("1st param = %1$s, 2nd param= %1$s",
        "1st value",
        "2nd value");
  }

  private static void stringsSplit() {
    final String[] s = JAVA_THE_BEST.split(" ");
    System.out.println(s[1]);
  }

  private static void stringBufferAndStringBuilderMethods() {
    final StringBuilder stringBuilder = new StringBuilder(); // faster
    final StringBuffer stringBuffer = new StringBuffer(); // thread-safe
    stringBuilder.append("JAVA  BEST");
    stringBuilder.trimToSize();
    stringBuilder.insert(5, "THE");
    System.out.println("stringBuilder.toString() = " + stringBuilder);
  }

  private static void simpleDateFormat() {
    GregorianCalendar cannes = new GregorianCalendar(216, Calendar.AUGUST, 2);
    cannes.set(Calendar.ERA, GregorianCalendar.BC);

    DateFormat df = new SimpleDateFormat("dd MMM yyy GG");
    System.out.println(df.format(cannes.getTime()));
  }

  private static void charVsCodePoint() {
    String s1 = "\uD834\uDD1E";
    String s2 = "𝄞"; // last real character is "𝄞", that takes 2 code unit,

    System.out.println(s1.equals(s2));

    System.out.println("------ as code point (aka. real character) ------");
    // code point,
    s1.codePoints()
        .forEach(cp -> System.out.println(Character.toChars(cp)));
    System.out.println("s1.codePointCount(0, 2) = " + s1.codePointCount(0, 2));

    System.out.println("\n------ as char (aka. code unit) ------");
    // chars (aka. code unit),
    s1.chars()
        .forEach(c -> System.out.println(Character.toChars(c)));
    System.out.println("s1.length() = " + s1.length());
  }

}

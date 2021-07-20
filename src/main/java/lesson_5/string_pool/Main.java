package lesson_5.string_pool;

public class Main {

  public static void main(String[] args) {

    String s1 = "Hello!";
    String s2 = "Hello!"; // checks in String pool, so s2 has the link to the same object as s1
    System.out.println(s1.equals(s2));
    System.out.println(s1 == s2);

    String s3 = "Hello!";
    String s4 = new String("Hello!"); // new object is created
    System.out.println(s3.equals(s4));
    System.out.println(s3 == s4);

  }

}

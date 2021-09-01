package lesson_14.memory;

public class Cat {

  // how many objects will be utilized after 7th line?
  public static void main(String [] args) {
    Object a = new Integer(100);  // Line1
    Object b = new Long(100);     // Line2
    Object c = new String("100"); // Line3
    a = null;                     // Line4

    a = c;                        // Line5
    c = b;                        // Line6
    b = a;                        // Line7
//    A. 0
//    B. 1
//    C. 2
//    D. 3
  }

}

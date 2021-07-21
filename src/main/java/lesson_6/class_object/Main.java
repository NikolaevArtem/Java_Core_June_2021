package lesson_6.class_object;

public class Main {

  //    Методы Object (11, 6 - native, 6 - final)
//    - public String toString() (defauld: return getClass().getName() + "@" + Integer.toHexString(hashCode());)
//    - public boolean equals(Object o)
//    - public native int hashCode()
//    - protected void finalize() (вызывается на обьекте перед уборкой GC. Deprecated с Java 9, ненадежен.)
//    - protected native Object clone() (создает и возвращает копию объекта. Для этого должен имплементировать Cloneable)
//    - public final native Class<?> getClass() (выдает класс объекта в Runtime)
//    - public final native void notify()
//    - public final native void notifyAll()
//    - public final void wait(long timeoutMillis, int nanos)
//    - public final native void wait(long timeoutMillis)
//    - public final void wait()

  public static void main(String[] args) {

    final Cat cat = new Cat("hello");
    final Cat cat1 = new Cat("hello");
    final Object o = new Object();

//    System.out.println(cat.equals(cat1));
//    System.out.println(cat.getClass().getSimpleName());
    System.out.println(cat.toString());
//    System.out.println(cat.hashCode());
//    System.out.println(cat1.hashCode());
//    final Object clone = cat.clone();

  }

}

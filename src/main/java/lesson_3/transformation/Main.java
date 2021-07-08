package lesson_3.transformation;

public class Main {

  public static void transformationUp() {
    int i1 = 1000;
    long l1 = i1;
    System.out.println("Повышающее (неявное) преобразование: " + l1);

    int i2 = 1234567891;
    double d = i2;
    System.out.println("Повышающее (неявное) преобразование c потерей точности: " + d);
  }

  public static void transformationDown() {
    long l3 = 1000;
    int i3 = (int) l3;
    System.out.println("Понижающее (явное) преобразование: " + i3);

    long l4 = 1000100010001000100L;
    int i4 = (int) l4;
    System.out.println("Понижающее (явное) преобразование с потерей точности: " + i4);
  }

  public static void main(String[] args) {
    transformationUp();
    transformationDown();

    // при операциях над byte и short они автоматически преобразуются в int
    byte b1 = 2;
    byte b2 = 3;
    byte b3 = (byte) (b1 + b2); // без (byte) не скомпилируется

    // при понижающей трансформации типа с плавающей точкой и переполнении
    double db1 = Double.MAX_VALUE;
    float f1 = (float) db1;
    System.out.println(f1); // Infinity

    // при понижающей трансформации числа с плавающей точкой в целочисленный и переполнении
    double db2 = Double.MAX_VALUE;
    int i1 = (int) db2;
    System.out.println(i1); // Integer.MAX_VALUE

    // при понижающей трансформации целочисленных типов и переполнении
    long l = 4_294_967_296L; // 0000 0000 0000 0000 _ 0000 0000 0000 0001 _ 0000 0000 0000 0000 _ 0000 0000 0000 0000
    int i2 = (int) l;
    System.out.println(i2); // 0, старшие биты отбрасываются при приведении
  }

}

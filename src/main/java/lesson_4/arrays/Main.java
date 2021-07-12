package lesson_4.arrays;

public class Main {

  public static void main(String[] args) {
    array2D();
  }

  private static void array() {
    int[] arr = new int[10];
    arr[0] = 5;

    int da = arr[1] + arr[2];

//    Object[] obj = new Object[10];
//    System.out.println(obj[0]);

    Integer[] arrInt = new Integer[10];
    arrInt[2] = 7;

    int[] arr2 = {1, 2, 3, 4};
    Object[] objects = {new Object(), new Object(), new Object()};

    System.out.println(arr[5]); // 0
    System.out.println(arrInt[5]); // null
    System.out.println("arr2 length is " + arr2.length);
    System.out.println(arr2[5]); //IndexOutOfBounds exception
  }

  private static void array2D() {
//    int[][] arrD = new int[3][];
//    System.out.println("error: " + arrD[3][0]);

    int[][] arrD2 = {
        {1, 2},
        {3, 4},
        {5, 6}
    };

    int i = arrD2[1][1];
    System.out.println(i);

    int[][] arrD3 = {
        {1, 2},
        {3, 4, 5},
        {6, 7, 8, 9}
    };
  }

  private static void arraysLiveInHeap() {
    int[] arr = {1, 2, 3};

    int[][] arrD = {arr, null};
    int[][] arrD2 = arrD.clone(); // {arr, null};

    System.out.println(arrD == arrD2); // Arrays are objects and live in heap

    System.out.println(arrD[0] == arrD2[0]);
  }

}

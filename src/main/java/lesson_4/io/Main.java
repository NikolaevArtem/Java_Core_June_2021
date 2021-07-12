package lesson_4.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws Exception {
    bufferedReaderReadConsole();
  }

  private static void bufferedReaderFull() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    try {
      while (true) {
        int i = Integer.parseInt(reader.readLine());
        System.out.println("BufferedReader: parsed int - " + i);
      }
    } catch (NumberFormatException e) {
      throw new RuntimeException(e);
    }
    finally {
      reader.close();
    }
  }

  private static void bufferedReaderReadConsole() throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int i = Integer.parseInt(reader.readLine());
      System.out.println("BufferedReader: parsed int - " + i);
    }
  }

  private static void scannerReadConsole() {
    try(Scanner scanner = new Scanner(System.in)) {
      int scannedInt = scanner.nextInt();
      System.out.println("Scanner: parsed int - " + scannedInt);
    }
  }

}

package lesson_9.ex_handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

public class Main {

  public static void main(String[] args) {
  }

  static void throwEx() {
    new RuntimeException("Message", new RuntimeException("message2")).printStackTrace();
  }

  private void try_catch() {
    try {
      throw new RuntimeException();
    } catch (RuntimeException ex) {
      ex.printStackTrace();
    }

    try {
      throw new RuntimeException();
    } finally {
      System.out.println("Ignore all");
    }

//    try {
//      throw new RuntimeException();
//    }
  }

  private static void try_catch_with_resources() throws IOException {
    try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.println("here!");
    }

    try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      throw new RuntimeException();
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      throw new RuntimeException();
    } finally {
      System.out.println("Ignore all");
    }

  }

}

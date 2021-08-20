package homework_2.random_chars_table.utils;

import homework_2.random_chars_table.exception.RandomCharsTableException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static homework_2.random_chars_table.utils.RandomCharsTableConstants.INFO_MESSAGE;


public final class RandomCharsTableUtils {
    public static void printMessage(String text) {
        System.out.print(text);
    }

    public static String getData() {
        printMessage(INFO_MESSAGE);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch (IOException e) {
            throw new RandomCharsTableException();
        }
    }
}

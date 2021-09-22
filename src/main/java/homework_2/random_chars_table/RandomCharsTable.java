package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class RandomCharsTable {


    public void run() {
        System.out.println("RandomCharTable App.");
        System.out.println("Enter table length, width and strategy separated by a space:");

        new InputParser().input();
    }
}

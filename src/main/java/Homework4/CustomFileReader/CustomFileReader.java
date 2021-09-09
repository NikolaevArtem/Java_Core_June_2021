package Homework4.CustomFileReader;
/*
реализовать приложение, которое считывает данные из файла, и печатает в консоль, но уже без запятых и точек.
Файл положить в main/resources/custom_file_reader

в классе должно быть реализовано минимум три рабочих способа (один с помощью NIO) считывания данных из файла.
Соответственно публичные методы run1(), run2(), run3(), ...
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomFileReader {
    String separator = File.separator;
    String path = "C:"+ separator + "Users" + separator + "Daisy" + separator + "Documents" + separator +
        "Epam training"+ separator + "Java_Core_June_2021" + separator +"src" + separator + "main" + separator
        + "resources" + separator + "custom_file_reader" + separator + "text.txt";
    String text = "";

    File file = new File(path);

    public void run1() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {

            String text = scanner.nextLine();
        }
        scanner.close();
        System.out.println(text);
    }


}

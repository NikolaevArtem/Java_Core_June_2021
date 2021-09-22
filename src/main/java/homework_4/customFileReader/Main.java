package homework_4.customFileReader;

public class Main {

    public static void main(String[] args) {
        String path = "src/main/resources/custom_file_reader.txt";
        CustomFileReader fileRiders = new CustomFileReader(path);
        fileRiders.run1();
        fileRiders.run2();
        fileRiders.run3();
    }
}

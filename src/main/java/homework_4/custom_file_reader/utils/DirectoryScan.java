package homework_4.custom_file_reader.utils;

import java.io.File;


public class DirectoryScan {

    private DirectoryScan() { }

    public static void scanDir(String dirPath) {
        File[] filesList = new File(dirPath).listFiles();
        if (filesList != null && filesList.length >= 1) {
            System.out.println(dirPath + " contains:" + "\n--- --- ---");
            for (File file : filesList) {
                System.out.println(file.getName() + "\tat: " + file.getAbsolutePath());
                System.out.println("---");
            }
            System.out.println("--- --- ---");
        } else System.out.println(dirPath + " is empty!");
    }

    // additional method for extra usage
    public static boolean isInDir(String dirPath, String fileName) {
        File[] filesList = new File(dirPath).listFiles();
        if (filesList == null) {
            System.out.println(dirPath + " is empty!");
            return false;
        }
        for (File file : filesList) {
            if (file.getName().equalsIgnoreCase(fileName)) {
                return true;
            }
        }
        return false;
    }

}

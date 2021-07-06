package hometask_1;

public class Main {
    public static void main(String[] args) throws Exception {

        try {
            for (String str : args) {

                if (str.equalsIgnoreCase("error")) {
                    System.out.println("\u001B[31m" + "Alarm!" + "\u001B[0m");
                    throw new RuntimeException();
                }
                System.out.println(str + " " + str.length() + " letters");
            }
        } catch (Exception e) {
        }
    }
}

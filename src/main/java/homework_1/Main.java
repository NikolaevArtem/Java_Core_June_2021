package homework_1;

public class Main {
  public static final String redColorOutString = "\u001B[31m";
  public static final String closeColorOutString = "\u001B[0m";
    public static void main(String... args) {
        for (String arg :
                args) {
            if (arg. equals("ошибка")) {
                System.out.println(redColorOutString + "Тревога!" + closeColorOutString);
                return;
            } else {
                System.out.println(createStringResult(arg));
            }
        }
    }

    private static String createStringResult(String str) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder
                .append(str)
                .append(": ")
                .append(str.length())
                .append(" букв");
        switch (str.length()%10) {
            case 1:
                strBuilder.append("а");
                break;
            case 2:
            case 3:
            case 4:
                strBuilder.append("ы");
                break;
            default:
                break;
        }
        return strBuilder.toString();
    }
}

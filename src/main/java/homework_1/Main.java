package homework_1;

public class Main {
    public static void main(String... args) {
        if (args.length == 0) return;
        StringBuilder strBuilder = new StringBuilder();
        for (String arg :
                args) {
            if (arg.equalsIgnoreCase("ошибка")) {
                System.err.println("Тревога!");
                return;
            } else {
                strBuilder
                        .append(arg)
                        .append(": ")
                        .append(arg.length())
                        .append(" букв");
                switch (arg.length()%10) {
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
                System.out.println(strBuilder);
                strBuilder.setLength(0);
            }
        }
    }
}

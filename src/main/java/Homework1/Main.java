package Homework1;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) return;
        for (String arg : args) {
            if (arg.equals("������")) {
                System.err.println("�������!");
                return;
            } else {
                String result = arg + ": " + arg.length() + " ";
                switch (arg.length() % 10) {
                    case 1: {
                        if (arg.length() != 11) {
                            result += "�����";
                            break;
                        } else {
                            result += "����";
                            break;
                        }
                    }
                    case 2:
                    case 3:
                    case 4: {
                        if (arg.length() != 12 && arg.length() != 13 && arg.length() != 14) {
                            result += "�����";
                            break;
                        } else {
                            result += "����";
                            break;
                        }
                    }
                    default: {
                        result += "����";
                        break;
                    }
                }
                System.out.println(result);
            }
        }
    }
}

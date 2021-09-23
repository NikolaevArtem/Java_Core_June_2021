package homework_5.custom_regex_matcher;

import java.util.Scanner;

public class CustomRegexMatcher {

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your password: ");

        String str = sc.nextLine();
        if (str.isEmpty()) System.out.println("The entered string is empty, password must be at least 8 characters long.");
        boolean perfectPassword = str.matches("^(?=.*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*)(?=.*[!$%#^].*)[0-9a-zA-Z!$%#^]{8,}$");

        if (perfectPassword)
            System.out.println("Password security: " + true);
        else
            printReasonOfFail(str);
    }

    public void printReasonOfFail(String str) {
        if (str.matches("^(?=.*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*)(?=.*[!$%#^].*)[0-9a-zA-Z!$%#^]")) {
            System.out.println("Password must be at least 8 characters long.");
            return;
        }

        if (str.matches("^(?=.*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*)[0-9a-zA-Z]{8,}$")) {
            System.out.println("Password must contain special characters: !, $, %, #, ^");
            return;
        }

        if (str.matches("^(?=.*[a-z].*)(?=.*[A-Z].*)(?=.*[!$%#^].*)[a-zA-Z!$%#^]{8,}$")) {
            System.out.println("Password must contain digits: 0-9");
            return;
        }

        if (str.matches("^(?=.*[0-9].*)(?=.*[!$%#^].*)[0-9!$%#^]{8,}$")) {
            System.out.println("Password must contain lowercase and uppercase letters.");
            return;
        }

        if (str.matches("^(?=.*[0-9].*)(?=.*[a-z].*)(?=.*[!$%#^].*)[0-9a-z!$%#^]{8,}$")) {
            System.out.println("Password must contain uppercase letters.");
            return;
        }

        if (str.contains(" ")) {
            System.out.println("Password must not contain a space.");
            return;
        }

        System.out.println("Password at least 8 characters long must contain lowercase and uppercase letters, digits and special characters: !, $, %, #, ^.");
    }
}

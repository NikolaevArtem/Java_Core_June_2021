package course_project.utils;

public class FontColors {


    // Colours for background
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String RED_BACKGROUND = "\033[41m";

    // Reset colour
    public static final String ANSI_RESET = "\u001B[0m";

    // Colours for String
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK


    public FontColors() {
        //menuLogo();
    }


    // Method prints a colorful logo

    public void menuLogo() {

        System.out.println(
                RED_BACKGROUND + BLACK_BOLD + "         WELCOME TO SEA BATTLE!        " + ANSI_RESET +
                        "\n" + "\n" +


                        " " + ANSI_BLUE_BACKGROUND + "                                    " + ANSI_RESET + "\n"
        );
    }
}
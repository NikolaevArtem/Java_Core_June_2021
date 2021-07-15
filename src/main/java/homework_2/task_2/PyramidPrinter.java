package homework_2.task_2;

/**
 * todo Document type Pyramid
 */
public class PyramidPrinter {

    private PyramidPrinter() {
        throw new IllegalStateException("Utility class");
    }

    public static void printPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}

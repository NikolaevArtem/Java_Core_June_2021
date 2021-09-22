package homework_3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ImmutableClass imut = new ImmutableClass(2, "string", 'G', new String[]{"one", "two"});
        String[] b = imut.getNames();
        System.out.println(Arrays.toString(b));
        b[0] = "changes";
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(imut.getNames()));


    }
}

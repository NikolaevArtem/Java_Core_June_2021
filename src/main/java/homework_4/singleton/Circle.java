package homework_4.singleton;

import lombok.Data;

//Example of using Singleton

@Data
public class Circle {

    private static Circle uniqueCircle;
    private String color;

    private Circle() {
    }

    public static Circle getInstance() {
        if (uniqueCircle == null) {
            uniqueCircle = new Circle();
        }
        return uniqueCircle;
    }
}

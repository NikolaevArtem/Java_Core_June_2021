package homework_4.custom_annotation;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class InfoProcessor {

    public void printInfo(Object o) {
        if (o != null) {
            Class<?> processingClass = o.getClass();
            for (Field f : processingClass.getFields()) {
                try {
                    if (f.isAnnotationPresent(Info.class) && f.get(o) != null) {
                        if (f.getType().isArray()) {
                            System.out.println(f.getName() + " = {" + arrayToString(f.get(o)) + "} ");
                        } else {
                            System.out.println(f.getName() + " = " + f.get(o) + " ");
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Object is null");
        }
    }

    private String arrayToString(Object arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Array.getLength(arr); i++) {
            sb.append(Array.get(arr, i));
            if (i < Array.getLength(arr) - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}

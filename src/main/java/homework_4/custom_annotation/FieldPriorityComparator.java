package homework_4.custom_annotation;

import java.lang.reflect.Field;
import java.util.Comparator;

public class FieldPriorityComparator implements Comparator<Field> {

    @Override
    public int compare(Field f1, Field f2) {
        int priority1 = f1.getDeclaredAnnotation(ImportantField.class).priority();
        int priority2 = f2.getDeclaredAnnotation(ImportantField.class).priority();
        return priority1 - priority2;
    }

}

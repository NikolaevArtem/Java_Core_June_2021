package homework_4.custom_annotation;

import lombok.Data;

import java.lang.reflect.Field;
import java.util.ArrayList;

@Data
public class Book {

    @ImportantField(priority = 1)
    private String title;
    @ImportantField(priority = 3)
    private String genre = "not specified";
    private String description = "";
    @ImportantField(priority = 2)
    private String author = "not specified";
    private int year;
    private String publisher = "not specified";
    @ImportantField(priority = 4)
    private double cost = 0.00;

    public Book(String title) {
        this.title = title;
    }

    public void printImportant() throws IllegalAccessException {
        ArrayList<Field> importantFields = new ArrayList<>();
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ImportantField.class)) {
                importantFields.add(field);
            }
        }
        FieldPriorityComparator comparator = new FieldPriorityComparator();
        importantFields.sort(comparator);
        for (Field field : importantFields) {
            System.out.println(field.getName() + ": " + field.get(this) + ";");
        }
    }

}

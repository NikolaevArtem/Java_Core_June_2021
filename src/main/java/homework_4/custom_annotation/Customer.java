package homework_4.custom_annotation;

import java.lang.reflect.Field;

public class Customer {

    @ChangeOutputName("Наименование")
    private String name;
    @ChangeOutputName("Полное имя")
    private String fullName;
    private String address;
    @ChangeOutputName("Номер телефона")
    private String phoneNumber;

    public Customer() {
    }

    public Customer(String name, String fullName) {
        this.name = name;
        this.fullName = fullName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {

        String result = "Customer{" +
                "%s='" + name + '\'' +
                ", %s='" + fullName + '\'' +
                ", %s='" + address + '\'' +
                ", %s='" + phoneNumber + '\'' +
                '}';

        return getMappedString(result);
    }

    private String getMappedString(String s) {

        Class<ChangeOutputName> customAnnotationClass = ChangeOutputName.class;

        Field[] declaredFields = this.getClass().getDeclaredFields();

        String[] fieldNames = new String[declaredFields.length];

        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            field.setAccessible(true);
            if (field.isAnnotationPresent(customAnnotationClass)) {
                fieldNames[i] = field.getAnnotation(customAnnotationClass).value();
            } else {
                fieldNames[i] = field.getName();
            }
        }

        return String.format(s, (Object[]) fieldNames);

    }
}

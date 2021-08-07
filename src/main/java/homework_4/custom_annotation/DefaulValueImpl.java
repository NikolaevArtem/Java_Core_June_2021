package homework_4.custom_annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaulValueImpl {

    public void insetDefaultValue(Object object) throws IllegalAccessException, InvocationTargetException {
        setDefaultValueToFields(object, object.getClass());
        setDefaultValueToMethods(object, object.getClass());


    }

    private void setDefaultValueToMethods(Object object, Class<?> clazz) throws InvocationTargetException, IllegalAccessException {
        List<Method> collectPrivateMethods = Arrays.stream(clazz.getDeclaredMethods())
                .filter((o) -> o.isAnnotationPresent(DefaultValue.class))
                .collect(Collectors.toList());
        setDefaultValueMethods(collectPrivateMethods, clazz, object);
    }

    private void setDefaultValueToFields(Object object, Class<?> clazz) throws IllegalAccessException {
        List<Field> collectPublic = Arrays.stream(clazz.getFields())
                .filter((o) -> o.isAnnotationPresent(DefaultValue.class))
                .collect(Collectors.toList());
        getDefaultFields(collectPublic, clazz, object);

        List<Field> collectPrivate = Arrays.stream(clazz.getDeclaredFields())
                .filter((o) -> o.isAnnotationPresent(DefaultValue.class))
                .collect(Collectors.toList());
        getDefaultFields(collectPrivate, clazz, object);

    }

    private void setDefaultValueMethods(List<Method> collectMethods, Class<?> clazz, Object object) throws InvocationTargetException, IllegalAccessException {
        for (Method method : collectMethods) {
            DefaultValue annotation = method.getAnnotation(DefaultValue.class);
            String value = annotation.value();
            Class<?> type = method.getParameterTypes()[0];
            method.setAccessible(true);
            if (type == Integer.class || type == int.class) {
                method.invoke(object, Integer.parseInt(value));
            } else if (type == Double.class || type == double.class) {
                method.invoke(object, Double.parseDouble(value));
            } else {
                method.invoke(object, value);
            }
        }
    }

    private void getDefaultFields(List<Field> collect, Class<?> clazz, Object object) throws IllegalAccessException {
        for (Field field : collect) {
            DefaultValue annotation = field.getAnnotation(DefaultValue.class);
            String value = annotation.value();
            Class<?> type = field.getType();
            field.setAccessible(true);
            if (type == Integer.class || type == int.class) {
                if (field.get(object) == null || field.get(object).equals(0))
                    field.set(object, Integer.parseInt(value));
            } else if (type == Double.class || type == double.class) {
                if (field.get(object) == null || field.get(object).equals(0.0))
                    field.set(object, Double.parseDouble(value));
            } else {
                if (field.get(object) == null || field.get(object).equals("")) field.set(object, value);
            }
        }
    }
}

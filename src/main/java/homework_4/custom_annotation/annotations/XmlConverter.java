package homework_4.custom_annotation.annotations;

import homework_4.custom_annotation.custom_exception.XmlSerializationException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class XmlConverter {

    public String convertToXml(Object object) throws XmlSerializationException {
        try {
            validObjectToSerializable(object);
            return getXmlString(object);
        } catch (Exception e) {
            throw new XmlSerializationException(e.getMessage());
        }
    }

    private void validObjectToSerializable(Object object) {
        if (Objects.isNull(object)) {
            throw new XmlSerializationException("The object is null");
        }

        Class<?> serializableClass = object.getClass();
        if (!serializableClass.isAnnotationPresent(XmlSerializable.class)) {
            throw new XmlSerializationException("The object " + serializableClass.getSimpleName() + " should be annotated with " + XmlSerializable.class.getSimpleName());
        }
    }

    private String getXmlString(Object object) throws Exception {
        Class<?> serializableClass = object.getClass();
        Map<String, String> xmlElementsMap = new HashMap<>();
        for (Field field : serializableClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(XmlElement.class)) {
                xmlElementsMap.put(getKey(field), (String) field.get(object));
            }
        }

        String xmlString = xmlElementsMap.entrySet()
                .stream()
                .map(entry -> "<" + entry.getKey().toLowerCase(Locale.ROOT) + ">"
                        + entry.getValue().toLowerCase(Locale.ROOT)
                        + "</" + entry.getKey().toLowerCase(Locale.ROOT) + ">")
                .collect(Collectors.joining(""));
        return "<" + serializableClass.getSimpleName().toLowerCase(Locale.ROOT) + "s" + ">" +
                "<" + serializableClass.getSimpleName().toLowerCase(Locale.ROOT) + ">" +
                xmlString +
                "</" + serializableClass.getSimpleName().toLowerCase(Locale.ROOT) + ">" +
                "</" + serializableClass.getSimpleName().toLowerCase(Locale.ROOT) + "s" + ">";
    }

    private String getKey(Field field) {
        String value = field.getAnnotation(XmlElement.class)
                .key();
        return value.isEmpty() ? field.getName() : value;
    }

}

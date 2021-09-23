package homework_4.custom_annotation.annotations;

import homework_4.custom_annotation.Cat;
import homework_4.custom_annotation.custom_exception.XmlSerializationException;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class XmlConverterTest {

    @Test
    void givenObject_whenConvertToXml_thenThrows() throws XmlSerializationException {
        Object o = new Object();
        XmlConverter xmlConverter = new XmlConverter();
        assertThrows(XmlSerializationException.class, () -> {
            xmlConverter.convertToXml(o);
        });
    }

    @Test
    void givenCat_whenConvertToXml_thenValidCatForXml() {
        Cat cat = new Cat("Epam", "1", "Intern");
        XmlConverter xmlConverter = new XmlConverter();
        assertEquals("<cats><cat><name>epam</name><age>1</age><breed>intern</breed></cat></cats>".toLowerCase(Locale.ROOT), xmlConverter.convertToXml(cat));
    }

}
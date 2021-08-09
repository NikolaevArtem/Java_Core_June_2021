package homework_4.custom_annotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomAnnotationTest {

    @Test
    public void defaultValueFieldIntegerTest() {
        class TestClass {
            @DefaultValue("21")
            private Integer integerValue1;

            @DefaultValue("21")
            private int integerValue2;

            public Integer getIntegerValue1() {
                return integerValue1;
            }

            public int getIntegerValue2() {
                return integerValue2;
            }
        }
        TestClass testClass = new TestClass();
        try {
            DefaulValueImpl.insetDefaultValue(testClass);
            Assertions.assertEquals(21, testClass.getIntegerValue1());
            Assertions.assertEquals(21, testClass.getIntegerValue2());
        } catch (Exception ignore) {
        }
    }

    @Test
    public void defaultValueFieldDoubleTest() {
        class TestClass {
            @DefaultValue("21.2")
            private Double doubleValue1;

            @DefaultValue("21.3")
            private double doubleValue2;

            public Double getDoubleValue1() {
                return doubleValue1;
            }

            public double getDoubleValue2() {
                return doubleValue2;
            }
        }
        TestClass testClass = new TestClass();
        try {
            DefaulValueImpl.insetDefaultValue(testClass);
            Assertions.assertEquals(21.2, testClass.getDoubleValue1());
            Assertions.assertEquals(21.3, testClass.getDoubleValue2());
        } catch (Exception ignore) {
        }
    }

    @Test
    public void defaultValueFieldStringTest() {
        class TestClass {
            @DefaultValue("value1")
            private String stringValue1;

            @DefaultValue("anotherValue")
            private String stringValue2;

            public String getStringValue1() {
                return stringValue1;
            }

            public String getStringValue2() {
                return stringValue2;
            }
        }
        TestClass testClass = new TestClass();
        try {
            DefaulValueImpl.insetDefaultValue(testClass);
            Assertions.assertEquals("value1", testClass.getStringValue1());
            Assertions.assertEquals("anotherValue", testClass.getStringValue2());
        } catch (Exception ignore) {
        }
    }

    @Test
    public void defaultValueMethodIntegerParamTest() {
        class TestClass {
            private Integer integer;
            private Double value;
            private String str;

            @DefaultValue("11")
            public void setInteger(Integer integer) {
                this.integer = integer;
            }

            @DefaultValue("12.3")
            public void setValue(Double value) {
                this.value = value;
            }

            @DefaultValue("string")
            public void setStr(String str) {
                this.str = str;
            }

            public Integer getInteger() {
                return integer;
            }

            public Double getDouble() {
                return value;
            }

            public String getString() {
                return str;
            }
        }
        TestClass testClass = new TestClass();
        try {
            DefaulValueImpl.insetDefaultValue(testClass);
            Assertions.assertEquals(11, testClass.getInteger());
            Assertions.assertEquals(12.3, testClass.getDouble());
            Assertions.assertEquals("string", testClass.getString());
        } catch (Exception ignore) {
        }
    }
}

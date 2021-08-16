package homework_4.custom_annotation;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomAnnotationTest extends UnitBase {

    private final Customer customer = new Customer();

    @Test
    void test_ToStringReturnsNewFieldsName() {

        String name = "ООО \"Ромашка\"";
        String fullName = "Общество с ограниченной ответственностью \"Ромашка\"";

        customer.setName(name);
        customer.setFullName(fullName);

        System.out.println(customer);

        String expected = String.format("Customer{Наименование='%s', Полное имя='%s', address='null', Номер телефона='null'}",
                name,
                fullName);

        String actual = getOutput();

        assertEquals(actual, expected);
    }
}

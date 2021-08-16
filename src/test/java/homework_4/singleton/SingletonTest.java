package homework_4.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SingletonTest{

    @Test
    void test_OnlyOneInstance() {
        //Class singleton
        assertEquals(DatabaseConnection.getInstance("superAdmin"), DatabaseConnection.getInstance("admin"));
        //Enum singleton
        assertEquals(EnumDatabaseConnection.INSTANCE.getInstance(), EnumDatabaseConnection.INSTANCE.getInstance());
    }
}

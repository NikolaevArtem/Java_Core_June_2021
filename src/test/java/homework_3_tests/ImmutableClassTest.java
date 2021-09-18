package homework_3_tests;

import homework_3.immutable_class.MyImmutableBag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ImmutableClassTest {

    @Test
    void immutableTest() {
        int cash = 2000;
        ArrayList<String> documents = new ArrayList<>(Arrays.asList("Passport", "Student ID", "Metro card"));
        HashMap<String, String> pills = new HashMap<>();
        pills.put("Vitamins", "Supradyn");
        pills.put("Medicine for cold", "Coldrex");
        MyImmutableBag myFirstBag = new MyImmutableBag(cash, documents, pills);
        pills.remove("Vitamins");
        MyImmutableBag mySecondBag = new MyImmutableBag(cash, documents, pills);
        assertNotEquals(myFirstBag, mySecondBag);
        assertNotEquals(myFirstBag.getPills(), mySecondBag.getPills());

        documents.add("Doctor's prescription");
        MyImmutableBag myThirdBag = new MyImmutableBag().changeDocuments(documents);
        assertNotEquals(myFirstBag, myThirdBag);
        assertNotEquals(myFirstBag.getDocuments(), myThirdBag.getDocuments());
    }
}

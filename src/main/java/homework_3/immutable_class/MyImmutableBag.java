package homework_3.immutable_class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Immutable class requirements:
 * - class must be declared final,
 * - fields in class must be private and final,
 * - getters must return a copy of the object,
 * - method for changing field of object should return a copy of the object with changed field, and not directly change the field,
 * - constructor should copy passed reference objects into new one, not insert direct references.
 */

public final class MyImmutableBag {

    private final int cash;
    private final ArrayList<String> documents;
    private final Map<String, String> pills;

    public MyImmutableBag(){
        documents = new ArrayList<>();
        documents.add("Passport");
        documents.add("INN");
        documents.add("Medical policy");
        cash = 1000;
        pills = new HashMap<>();
        pills.put("Allergy pills", "Loratadine");
        pills.put("Headache tablets", "Citramone");
        pills.put("Tablets from temperature", "Paracetamol");
    }

    public MyImmutableBag(int cash){
        this.cash = cash;
        documents = new ArrayList<>();
        documents.add("Passport");
        documents.add("INN");
        documents.add("Medical policy");
        pills = new HashMap<>();
        pills.put("Allergy pills", "Loratadine");
        pills.put("Headache tablets", "Citramone");
        pills.put("Tablets from temperature", "Paracetamol");
    }

    public MyImmutableBag(int cash, ArrayList<String> documents, Map<String, String> pills){
        this.cash = cash;
        this.documents = new ArrayList<>(documents);
        this.pills = new HashMap<>(pills);
    }

    public int getCash() {
        return this.cash;
    }

    public ArrayList<String> getDocuments() {
        return new ArrayList<>(documents);
    }

    public Map<String, String> getPills() {
        return new HashMap<>(pills);
    }

    public MyImmutableBag changeCash(int newCash) {
        return new MyImmutableBag(newCash, documents, pills);
    }

    public MyImmutableBag changeDocuments(ArrayList<String> newDocuments) {
        return new MyImmutableBag(cash, newDocuments, pills);
    }

    public MyImmutableBag changePills(Map<String, String> newPills) {
        return new MyImmutableBag(cash, documents, newPills);
    }
}

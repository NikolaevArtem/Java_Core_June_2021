package Homework3.Immutable_Class_Task;
import java.util.HashMap;
import java.util.Map;

/*
Requirements for immutable classes
1. The class must be declared as final/

2.Fields in the class must be declared as private

3.Data members in the class must be declared as final
(So that we can’t change the value of it after object creation)

4. A parameterized constructor should initialize all the fields performing a deep copy
(So that data members can’t be modified with object reference)
5.Deep Copy of objects should be performed in the getter methods
(To return a copy rather than returning the actual object reference)

6. No setters
 */

public final class Employee {
        private final String name;
        private final int regNo;
        private final Map<String, String> metadata;

        public Employee(String name, int regNo,
                        Map<String, String> metadata)
        {
            this.name = name;
            this.regNo = regNo;
            Map<String, String> tempMap = new HashMap<>();
            for (Map.Entry<String, String> entry :
                    metadata.entrySet()) {
                tempMap.put(entry.getKey(), entry.getValue());
            }
            this.metadata = tempMap;
        }

        public String getName() { return name; }

        public int getRegNo() { return regNo; }

        public Map<String, String> getMetadata()
        {
            Map<String, String> tempMap = new HashMap<>();
            for (Map.Entry<String, String> entry :
                    this.metadata.entrySet()) {
                tempMap.put(entry.getKey(), entry.getValue());
            }
            return tempMap;
        }
    }


    class Main {
        public static void main(String[] args)
        {
            Map<String, String> map = new HashMap<>();
            map.put("1", "first");
            map.put("2", "second");
            Employee s = new Employee("ABC", 101, map);
            System.out.println(s.getName());
            System.out.println(s.getRegNo());
            System.out.println(s.getMetadata());


        }
    }


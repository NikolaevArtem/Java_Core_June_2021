package Homework3.Immutable_Class_Task;
import java.util.HashMap;
import java.util.Map;

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

        public String getName() { return new String(this.name); }

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


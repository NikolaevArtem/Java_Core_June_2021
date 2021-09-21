package homework_4.singleton;

public class Main {

    public static void main(String[] args) {

        //Class singleton

        String userName1 = "admin";
        DatabaseConnection classSingleton1 = DatabaseConnection.getInstance(userName1);
//        DatabaseConnection object1 = new DatabaseConnection(); // The constructor DatabaseConnection() is not visible

        String userName2 = "superAdmin";
        DatabaseConnection classSingleton2 = DatabaseConnection.getInstance(userName2);

        System.out.println(classSingleton1);
        System.out.println(classSingleton2);

        //Enum singleton

        EnumDatabaseConnection enumSingleton1 = EnumDatabaseConnection.INSTANCE.getInstance();

        EnumDatabaseConnection enumSingleton2 = EnumDatabaseConnection.INSTANCE.getInstance();

        System.out.println(enumSingleton1);
        System.out.println(enumSingleton2);


    }
}

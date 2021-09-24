package homework_4.custom_annotation.db_annotation;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;

public class Main {

    public static String DB_URL = "jdbc:mysql://localhost:3306/DB_NAME";
    public static String User = "";
    public static String password = "";

    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        prepareTable(Student.class);
        Student student = new Student(1, "kostya", 25, "kostya@gmail.com");
        saveObject(student);
    }

    public static void prepareTable(Class<?> myClass) {
        if (!myClass.isAnnotationPresent(XTable.class)) throw new IllegalArgumentException();
        HashMap<Class, String> hashMap = new HashMap<>();
        hashMap.put(int.class, "INTEGER");
        hashMap.put(String.class, "VARCHAR(255)");
        try {
            connection();
            String tableName = myClass.getAnnotation(XTable.class).name();
            statement.executeUpdate("DROP TABLE IF EXISTS " + tableName + ";");
            String createTable = "CREATE TABLE " + tableName + " (";
            Field[] fields = myClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(XField.class)) {
                    createTable += field.getName() + " " + hashMap.get(field.getType()) + ", ";
                }
            }
            createTable = createTable.substring(0, createTable.length() - 2);
            createTable += ");";
            statement.executeUpdate(createTable);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void saveObject(Object object) {
        Class c = object.getClass();
        if (!c.isAnnotationPresent(XTable.class)) throw new IllegalArgumentException();
        try {
            connection();
            String tableName = ((XTable) c.getAnnotation(XTable.class)).name();
            String insertQuery = "INSERT INTO " + tableName + " (";
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(XField.class)) {
                    insertQuery += field.getName() + ", ";
                }
            }
            insertQuery = insertQuery.substring(0, insertQuery.length() - 2);
            insertQuery += ") VALUES (";
            for (Field field : fields) {
                if (field.isAnnotationPresent(XField.class)) {
                    insertQuery += "?, ";
                }
            }
            insertQuery = insertQuery.substring(0, insertQuery.length() - 2);
            insertQuery += ");";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            int counter = 1;
            for (Field field : fields) {
                if (field.isAnnotationPresent(XField.class)) {
                    preparedStatement.setObject(counter, field.get(object));
                    counter++;
                }
            }
            preparedStatement.executeUpdate();
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void connection() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, User, password);
        statement = connection.createStatement();
    }

    public static void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
CREATE TABLE students {
id INTEGER,
name VARCHAR(255),
score INTEGER,
mail VARCHAR(255)
};
 */
/*
INSERT INTO students(
id, name , score , mail)
VALUES (?, ?, ? , ?);
 */

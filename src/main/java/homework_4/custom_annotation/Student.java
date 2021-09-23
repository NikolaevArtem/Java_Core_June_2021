package homework_4.custom_annotation;

@StudentInformation(city = "Saint-Petersburg", language = "Java")
public class Student {
    private String name;
    private String email;
    private String city;
    private String language;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
        city = Student.class.getAnnotation(StudentInformation.class).city();
        language = Student.class.getAnnotation(StudentInformation.class).language();
    }

    public Student(String name, String email, String city) {
        this.name = name;
        this.email = email;
        this.city = city;
        language = Student.class.getAnnotation(StudentInformation.class).language();
    }

    public Student(String name, String email, String city, String language) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLanguage() {
        return language;
    }

    public String getCity() {
        return city;
    }
}

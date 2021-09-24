package homework_4.custom_annotation.db_annotation;

@XTable(name = "students")
public class Student {
    @XField
    public int id;
    @XField
    public String name;
    @XField
    public int score;
    @XField
    public String mail;

    public Student(int id, String name, int score, String mail) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.mail = mail;
    }
}


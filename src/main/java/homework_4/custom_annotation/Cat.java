package homework_4.custom_annotation;

import homework_4.custom_annotation.annotations.XmlElement;
import homework_4.custom_annotation.annotations.XmlSerializable;

@XmlSerializable
public class Cat {

    @XmlElement
    private String name;

    @XmlElement
    private String age;

    @XmlElement
    private String breed;

    private String emailAddress;

    public Cat(String name, String age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}

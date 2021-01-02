package pojo;

import java.util.Collections;
import java.util.List;

public class Person {
    
    private String name;
    private int age;
    private String occupation;
    private List<Skill> skills;

    public Person(String name, int age, String occupation, List<Skill> skills) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public List<Skill> getSkills() {
        return Collections.unmodifiableList(skills);
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

}

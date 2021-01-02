package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import pojo.Person;
import pojo.Skill;

public class Java8Test {

    public static void main(String[] args) {
        
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Kind", "1"));
        skills.add(new Skill("Cheering", "2"));
        skills.add(new Skill("Optimist", "3"));
        skills.add(new Skill("Engaged", "2"));
        
        
        Person person = new Person("Person", 33, "programmer", skills);
        
        Skill seachValue = new Skill("Cheering", null);
        
        Stream<Skill> listSkill = person.getSkills().stream().filter(s -> s.getName().equals(seachValue.getName()) && !s.getCode().isEmpty());
        System.out.println("Cheering Exists: " + listSkill.findAny().isPresent());
        
        Skill seachValue1 = new Skill("Engaged", null);

        Predicate<Skill> predicate = n -> (n.getName().equals(seachValue1.getName()) && !n.getCode().isEmpty());
        System.out.println("Engaged Exists: " + person.getSkills().stream().allMatch(predicate));
    }

}

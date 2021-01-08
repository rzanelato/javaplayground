package java8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import pojo.Person;
import pojo.Skill;

public class ChainMethod {

    private Person getPerson() {
        Skill skill = new Skill("Loco", "666");
        return new Person("Renato", 36, "Programador", Arrays.asList(skill));
    }

    public Skill chainTestSkillSucess() {
        Person person = getPerson();

        return Optional.ofNullable(person)
                       .filter(per -> !per.getSkills().isEmpty())
                       .map(Person::getSkills)
                       .map(this::getSkill)
                       .orElseThrow(() -> new RuntimeException("SoWrong"));
    }

    private Skill getSkill(List<Skill> skills) {
        return skills.stream().findFirst().orElseGet(() -> new Skill("defaul", "0"));
    }

    public Skill chainTestSkillNull() {
        Person person = getPerson();

        return Optional.ofNullable(person)
                       //.filter(per -> !per.getSkills().isEmpty())
                       .map(Person::getSkills)
                       .map(this::getSkillNull)
                       .orElseThrow(() -> new RuntimeException("SoWrong"));
    }

    private Skill getSkillNull(List<Skill> skills) {
        return null;
    }

    public Skill chainTestNullSkill() {
        Person person = getPerson();
        person.setSkills(null);

        return Optional.ofNullable(person)
                       .filter(per -> !per.getSkills().isEmpty())
                       .map(Person::getSkills)
                       .map(this::getSkillNull)
                       .orElseThrow(() -> new RuntimeException("SoWrong"));
    }


}

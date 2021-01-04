package file;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pojo.Person;
import pojo.Skill;

public class TestJSon {

    public static void main(String[] args) {
        convertObjWithList();
        //oldTest();
    }

    private static void convertObjWithList() {
        Person person = getPerson();

        JSONObject jsonObject = new JSONObject(person);
        System.out.println("OBJ: " + jsonObject.toString());
        System.out.println();
        String converted = new JSONArray(person.getSkills()).toString();
        System.out.println("List:\n" + converted);
        System.out.println();

        getSkillList(converted).forEach(System.out::println);

        System.out.println();
        System.out.println("Empty List:");
        getSkillList(null).forEach(System.out::println);
        getSkillList("").forEach(System.out::println);
    }

    private static List<Skill> getSkillList(String converted) {
        return Optional.ofNullable(converted)
                       .filter(StringUtils::isNotBlank)
                       .map(TestJSon::convertStringToList)
                       .orElseGet(Collections::emptyList);
    }

    private static List<Skill> convertStringToList(String string) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Skill> skills = mapper.readValue(string, new TypeReference<List<Skill>>() {});
            // mapper.getTypeFactory() .constructCollectionType(List.class, Skill.class)
            return skills;
        } catch (JsonProcessingException e) {
            System.out.println("Error: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    private static Person getPerson() {
        Skill skill1 = new Skill("stamina", "100");
        Skill skill2 = new Skill("power", "150");
        Skill skill3 = new Skill("speed", "50");
        List<Skill> skills = Arrays.asList(skill1, skill2, skill3);
        return new Person("Zana", 36, "comedian", skills);
    }

    private static void oldTest() {
        try {
            String jsonString = jsonTeste();
            JSONObject output;
            output = new JSONObject(jsonString);

            JSONArray docs = output.getJSONArray("archive");

            for (String str : JSONObject.getNames(output)) {
                System.out.println(str);
            }

            Iterator<?> inter = docs.iterator();
            while (inter.hasNext()) {
                Object obj = inter.next();
                System.out.println(obj);

            }
            JSONObject jobj = docs.getJSONObject(2);
            System.out.println(jobj.get("field2"));

            String[] nomes = JSONObject.getNames(jobj);

            for (String string : nomes) {
                System.out.println(string + ":" + jobj.get(string));

            }

            //File file = new File("/temp/fromJSON.csv");
            String csv = CDL.toString(docs);
            System.out.println("csv:");
            System.out.println(csv);
            //FileUtils.writeStringToFile(file, csv, "UTF-8");
	            /*
	            FileUtils.writeStringToFile(file, "\tTeste", "UTF-8", true);
	            FileUtils.writeStringToFile(file, "\tOutro", "UTF-8", true);
	            FileUtils.writeStringToFile(file, "\tRenato", "UTF-8", true);
	        } catch (IOException e) {
	        	e.printStackTrace();
	            */
        } catch (JSONException e) {
            //    e.printStackTrace();
            //} catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String jsonTeste() {
        //return "{\"id\": \"0001\\\",\\\"type\\\": \\\"donut\\\",\\\"name\\\": \\\"Cake\\\",\\\"ppu\\\": 0.55,\\\"batters\\\":{\\\"batter\\\":[{ \\\"id\\\": \\\"1001\\\", \\\"type\\\": \\\"Regular\\\" },{ \\\"id\\\": \\\"1002\\\", \\\"type\\\": \\\"Chocolate\\\" },{ \\\"id\\\": \\\"1003\\\", \\\"type\\\": \\\"Blueberry\\\" },{ \\\"id\\\": \\\"1004\\\", \\\"type\\\": \\\"Devil's Food\\\" }]},\\\"topping\\\":[{ \\\"id\\\": \\\"5001\\\", \\\"type\\\": \\\"None\\\" },{ \\\"id\\\": \\\"5002\\\", \\\"type\\\": \\\"Glazed\\\" },{ \\\"id\\\": \\\"5005\\\", \\\"type\\\": \\\"Sugar\\\" },{ \\\"id\\\": \\\"5007\\\", \\\"type\\\":\\\"Powdered Sugar\\\" },{ \\\"id\\\": \\\"5006\\\", \\\"type\\\": \\\"Chocolate with Sprinkles\\\" },{ \\\"id\\\": \\\"5003\\\", \\\"type\\\": \\\"Chocolate\\\" },{ \\\"id\\\": \\\"5004\\\", \\\"type\\\": \\\"Maple\\\" }]},{\\\"id\\\": \\\"0002\\\",\\\"type\\\": \\\"donut\\\",\\\"name\\\":\\\"Raised\\\",\\\"ppu\\\": 0.55,\\\"batters\\\":{\\\"batter\\\":[{ \\\"id\\\": \\\"1001\\\", \\\"type\\\": \\\"Regular\\\" }]},\\\"topping\\\":[{ \\\"id\\\": \\\"5001\\\", \\\"type\\\": \\\"None\\\" },{ \\\"id\\\": \\\"5002\\\", \\\"type\\\": \\\"Glazed\\\" },{ \\\"id\\\":\\\"5005\\\", \\\"type\\\": \\\"Sugar\\\" },{ \\\"id\\\": \\\"5003\\\", \\\"type\\\": \\\"Chocolate\\\" },{ \\\"id\\\": \\\"5004\\\", \\\"type\\\": \\\"Maple\\\" }]},{\\\"id\\\": \\\"0003\\\",\\\"type\\\": \\\"donut\\\",\\\"name\\\": \\\"Old Fashioned\\\",\\\"ppu\\\": 0.55,\\\"batters\\\":{\\\"batter\\\":[{ \\\"id\\\": \\\"1001\\\", \\\"type\\\": \\\"Regular\\\" },{ \\\"id\\\": \\\"1002\\\", \\\"type\\\": \\\"Chocolate\\\" }]},\\\"topping\\\":[{ \\\"id\\\": \\\"5001\\\", \\\"type\\\": \\\"None\\\" },{ \\\"id\\\": \\\"5002\\\", \\\"type\\\": \\\"Glazed\\\" },{ \\\"id\\\":\\\"5003\\\", \\\"type\\\": \\\"Chocolate\\\" },{ \\\"id\\\": \\\"5004\\\", \\\"type\\\": \\\"Maple\\\" }]}";
        return "{\"archive\": [{\"field1\": 11,\"field2\": 12,\"field3\": 13},{\"field1\": 21,\"field2\": 22,\"field3\": 23},{\"field1\": 31,\"field2\": 32,\"field3\": 33}]}";
    }

}

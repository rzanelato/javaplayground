package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pojo.Activity;
import pojo.Group;
import pojo.User;

public class AllMatchStream {

    public static void main(String[] args) {
        Group gp = getGroup();
        
        gp.getListUsers().forEach(urs -> System.out.println(urs.getName()));
        
        boolean result = gp.getListUsers().stream().allMatch(usr -> usr.getName().contains("a"));
        
        System.out.println("Result: " + result);
        
        //List<User> list1 = gp.getListUsers().stream().filter(usr -> usr.getFirstname().contains("Renato")).collect(Collectors.toList());

        //list1.forEach(usr -> System.out.println(usr.getFirstname()));
    }
    
    private static Group getGroup() {
        Activity act1 = new Activity("atv1", "1");
        Activity act2 = new Activity("atv2", "2");
        Activity act3 = new Activity("atv1", "3");
        Activity act4 = new Activity("atv4", "353");
        Activity act5 = new Activity("atv5", "633");
        
        List<Activity> listAct1 = new ArrayList<Activity>();
        listAct1.add(act4);
        listAct1.add(act2);
        listAct1.add(act1);
        listAct1.add(act3);
        List<Activity> listAct2 = new ArrayList<Activity>();
        listAct2.add(act5);
        listAct2.add(act3);
        listAct2.add(act4);
        
        User user1 = new User("Renato", listAct1);
        User user2 = new User("Zanelato", listAct2);
        User user3 = new User("Walt", null);
        User user4 = new User("Zurita", null);
        
        List<User> listUser1 = new ArrayList<>();
        List<User> listUser2 = new ArrayList<>();
        
        listUser1.add(user1);
        listUser1.add(user2);
        listUser1.add(user3);
        
        listUser2.add(user4);
        listUser2.add(user1);
        
        return new Group(1, "G1", listUser1);       
    }

}

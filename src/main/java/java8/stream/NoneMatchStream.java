package java8.stream;

import java.util.List;
import pojo.Activity;

public class NoneMatchStream {

    private NoneMatchStream() {
    }

    public static boolean noneMatchListTest(List<Activity> activities) {
        return activities.stream().noneMatch(activity -> "Test".equals(activity.getName()));
    }
}

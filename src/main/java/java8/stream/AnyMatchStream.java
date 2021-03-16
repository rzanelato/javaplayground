package java8.stream;

import java.util.List;
import pojo.Activity;

public class AnyMatchStream {

    private AnyMatchStream() {
    }

    public static boolean anyMatchListTest(List<Activity> activities) {
        return activities.stream().anyMatch(activity -> "Test".equals(activity.getName()));
    }
}

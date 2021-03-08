package java8.stream;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.Activity;

class GetLastElementStreamTest {

    @Test
    void shouldReturnLastElementListActivity() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("First", "100"));
        activities.add(new Activity("Second", "200"));
        activities.add(new Activity("Third", "300"));
        activities.add(new Activity("Forth", "400"));

        Activity result = GetLastElementStream.getLastElement(activities);

        Assertions.assertEquals("Forth", result.getName());
        Assertions.assertEquals("400", result.getPoints());
    }

    @Test
    void shouldReturnLastElementListActivityOrderedDate() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("First", "2021-04-02T14:56:43+0100"));
        activities.add(new Activity("Second", "2021-04-04T14:56:42+0100"));
        activities.add(new Activity("Third", "2021-03-03T14:36:42+0100"));
        activities.add(new Activity("Forth", "2020-03-01T14:36:42+0100"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        Comparator<Activity> comparator = Comparator.comparing(activity -> OffsetDateTime.parse(activity.getPoints(), formatter));
        Activity result = GetLastElementStream.getLastElement(activities, comparator);

        Assertions.assertEquals("Second", result.getName());
        Assertions.assertEquals("2021-04-04T14:56:42+0100", result.getPoints());
    }

    @Test
    void shouldReturnLastElementMaxListActivityOrderedDate() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("First", "2021-04-02T14:56:43+0100"));
        activities.add(new Activity("Second", "2021-04-04T14:56:42+0100"));
        activities.add(new Activity("Third", "2021-03-03T14:36:42+0100"));
        activities.add(new Activity("Forth", "2020-03-01T14:36:42+0100"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        Comparator<Activity> comparator = Comparator.comparing(activity -> OffsetDateTime.parse(activity.getPoints(), formatter));
        Activity result = GetLastElementStream.getLastElementMax(activities, comparator);

        Assertions.assertEquals("Second", result.getName());
        Assertions.assertEquals("2021-04-04T14:56:42+0100", result.getPoints());
    }

}

package java8.stream;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.Activity;

class NoneMatchStreamTest {

    @Test
    void shouldReturn_OK() {
        List<Activity> list = new ArrayList<>();
        list.add(new Activity("None", "1"));
        list.add(new Activity("Any", "2"));
        list.add(new Activity("", "3"));

        boolean result = NoneMatchStream.noneMatchListTest(list);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldReturn_KO() {
        List<Activity> list = new ArrayList<>();
        list.add(new Activity("None", "1"));
        list.add(new Activity("Any", "2"));
        list.add(new Activity("", "3"));
        list.add(new Activity("Test", "3"));

        boolean result = NoneMatchStream.noneMatchListTest(list);
        Assertions.assertFalse(result);
    }

}

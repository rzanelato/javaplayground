package java8.stream;

import java.util.Comparator;
import java.util.List;

public class GetLastElementStream {

    private GetLastElementStream() {
    }

    public static <T> T getLastElement(List<T> list) {
        return list.stream().reduce((first, second) -> second).orElse(null);
    }

    public static <T> T getLastElement(List<T> list, Comparator<T> comparator) {
        list.sort(comparator);
        return list.stream().reduce((first, second) -> second).orElse(null);
    }

}

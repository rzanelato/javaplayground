package numbers;

import java.util.Optional;
import java.util.Random;

public class RandomNumberRange {

    public static void main(String[] args) {
        System.out.println(getRandomRange());
    }

    private static Integer getRandomRange() {
        Integer range = new Random().nextInt(30);
        return Optional.of(range)
                       .filter(value -> value >= 20)
                       .orElseGet(RandomNumberRange::getRandomRange);
    }

}

package logic;


import java.util.stream.IntStream;

/**
 * Fabonacci
 *
 * [0, 1, 1 , 2, 3, 5, 8, 13, 21, ....]
 */
public class Fibonacci {

    public static void main(String[] args) {

        int[] list = Fibonacci.fibonacci(10);

        IntStream.of(list).forEach(Fibonacci::print);

        int number = 1;
        System.out.println();
        System.out.println("Is Fibonnacci[" + number + "] - " + Fibonacci.isNumberFibonacci(number));

        System.out.println();
        IntStream.range(0, 100).forEach(Fibonacci::printIsFibonacci);
    }

    public static void print(int number) {
        System.out.print(number == 0 ? number : "," + number );

    }
    public static void printIsFibonacci(int value) {
        System.out.println("[" + value + "] - " + (Fibonacci.isNumberFibonacci(value) ? "true" : ""));

    }

    public static int[] fibonacci(int count) {
        final int[] list = new int[count];
        for (int index = 0; index < list.length; index++) {
            if (index == 0 || index == 1) {
                list[index] = index;
                continue;
            }
            list[index] = list[index-1] + list[index-2];
        }
        return list;
    }

    public static boolean isNumberFibonacci(int number) {
        final int[] list = new int[number+2];

        for (int index = 0; index < list.length; index++) {
            if (index == 0 || index == 1) {
                if (number == index) {
                    return true;
                }
                list[index] = index;
                continue;
            }
            int sum = list[index-1] + list[index-2];
            if (number == sum) {
                return true;
            }
            if (number < sum) {
                return false;
            }
            list[index] = sum;
        }
        return false;
    }

}

package silly;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestJuegoWhatapp {

	public static void main(String[] args) {
		IntUnaryOperator function1 = TestJuegoWhatapp::multiply3;
		IntUnaryOperator function2 = function1.andThen(TestJuegoWhatapp::sum3);
		IntUnaryOperator function3 = function2.andThen(TestJuegoWhatapp::multiply3);
		IntUnaryOperator function4 = function3.andThen(TestJuegoWhatapp::sumDigits);
		
		//getList().forEach(num -> System.out.println("value:" + num + " - Total: " + function4.applyAsInt(num)));
		
		IntUnaryOperator function11 = TestJuegoWhatapp::multiply3;
		IntUnaryOperator function21 = function11.andThen(TestJuegoWhatapp::sum3)
                    .andThen(TestJuegoWhatapp::multiply3)
                    .andThen(TestJuegoWhatapp::sumDigits);
		
        System.out.println("Test2 2");
		getList2().forEach(num -> System.out.println("value:" + num + " - Total: " + function21.applyAsInt(num)));
		
	}

	private static List<Integer> getList() {
		List<Integer> list = new ArrayList<>();
		IntStream.rangeClosed(0, 20).forEach(list::add); 
		return list;
	}
	
	private static List<Integer> getList2() {
	    return IntStream.rangeClosed(0, 20).
	            collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll);
	}
	
	private static Integer multiply3(Integer num) {
		return num * 3;
	}
	
	private static Integer sum3(Integer num) {
		return num + 3;
	}
	
	private static Integer sumDigits(Integer num) {
		return Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).sum();
	}

}

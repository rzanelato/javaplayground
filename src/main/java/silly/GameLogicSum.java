package silly;

/*
 * Logic Game 
 * 
 * X + Y = 8
 * A - B = 6
 * X + A = 13
 * Y + B = 8
 * 
 * */
public class GameLogicSum {

	public static void main(String[] args) {
		boolean isValid = calcGameLogic(3, 5, 9, 3);
		System.out.println("IsValid: " + isValid);
	}
	
	private static boolean calcGameLogic(int val1, int val2, int val3, int val4) {
		return validateLine1(val1, val2) && validateLine2(val3, val4) && validateCol1(val1, val3) && validateCol2(val2, val4);
	}
	
	private static boolean validateLine1(int num1, int num2) {
		return (num1 + num2) == 8;
	}
	
	private static boolean validateLine2(int num3, int num4) {
		return (num3 - num4) == 6;
	}
	private static boolean validateCol1(int num1, int num3) {
		return (num1 + num3) == 13;
	}
	private static boolean validateCol2(int num2, int num4) {
		return (num2 + num4) == 8;
	}

}

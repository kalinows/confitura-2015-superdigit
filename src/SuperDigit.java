import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SuperDigit {
	/**
	 * Faster method of calculating super digit. Uses an array of pre-calculated super digits
	 * for numbers of digits modulo 9. Can be easily modified to accept BigInteger or another
	 * type.
	 */
	int superDigit(long number) {
		// super digits for sequences of same digits % 9
		int[][] superDigits = prepareSuperDigitsForModulo();
		List<Integer> digits = longToDigitArray(number);
		int[] digitCount = countDigits(digits);
		// sum of super digits for all distinct digits
		int sum = 0;
		for (int digit = 1; digit < 10; digit ++) {
			int count = digitCount[digit];
			int superDigit;
			if (count == 0) {
				superDigit = 0;
			} else {
				superDigit = superDigits[digit][count % 9];
			}
			sum += superDigit;
		}
		return superDigitRecursive(sum);
	}
	
	int[][] prepareSuperDigitsForModulo() {
		int[][] result = new int[10][9];
		Arrays.fill(result[0], 0);
		for (int digit = 1; digit < 10; digit ++) {
			result[digit][0] = 9;
			for (int modulo = 1; modulo < 9; modulo ++) {
				result[digit][modulo] = superDigitRecursive(digit * modulo);
			}
		}
		return result;
	}

	private int[] countDigits(List<Integer> digits) {
		int[] digitCount = new int[10];
		Arrays.fill(digitCount, 0);
		for (Integer digit : digits) {
			digitCount[digit]++;
		}
		return digitCount;
	}

	private List<Integer> longToDigitArray(long number) {
		ArrayList<Integer> digits = new ArrayList<>();
		do {
			int digit = (int) (number % 10);
			digits.add(digit);
			number /= 10;
		} while (number > 0);
		return digits;
	}

	/**
	 * Recursive algorithm that calculates super digit. 
	 * @param number
	 * @return
	 */
	int superDigitRecursive(long number) {
		if (number < 10) {
			return (int) number;
		}
		long sum = sumOfDigits(number);
		return superDigitRecursive(sum);
	}

	private long sumOfDigits(long number) {
		long sum = 0;
		do {
			long digit = number % 10;
			sum += digit;
			number /= 10;
		} while (number > 0);
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		SuperDigit instance = new SuperDigit();
		while(true) {
			System.out.print("Number: ");
			String line = reader.readLine();
			long number = Long.parseLong(line);
			System.out.println("Super digit: " + instance.superDigit(number));
		}


	}
}

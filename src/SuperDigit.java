
public class SuperDigit {
	int superDigit(int number) {
		if (number < 10) {
			return number;
		}
		int sum = sumOfDigits(number);
		return superDigit(sum);
	}

	private int sumOfDigits(int number) {
		int sum = 0;
		do {
			int digit = number % 10;
			sum += digit;
			number /= 10;
		} while (number > 0);
		return sum;
	}
}

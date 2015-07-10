
public class SuperDigit {
	int superDigit(long number) {
		if (number < 10) {
			return (int) number;
		}
		long sum = sumOfDigits(number);
		return superDigit(sum);
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
}

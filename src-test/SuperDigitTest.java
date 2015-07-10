import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class SuperDigitTest {
	
	private SuperDigit s = new SuperDigit();

	@Test
	public void testSuperDigitRecursiveSingle() {
		assertEquals(0, s.superDigitRecursive(0));
		assertEquals(9, s.superDigitRecursive(9));
	}
	@Test
	public void testSuperDigitRecursiveShort() {
		assertEquals(1, s.superDigitRecursive(10));
		assertEquals(7, s.superDigitRecursive(25));
	}
	@Test
	public void testSuperDigitRecursiveLong() {
		assertEquals(9, s.superDigitRecursive(99));
		assertEquals(3, s.superDigitRecursive(75));
		assertEquals(6, s.superDigitRecursive(9573));
		assertEquals(2, s.superDigitRecursive(98741));
		assertEquals(1, s.superDigitRecursive(1111111111111111111L));
	}
	@Test
	public void testSuperDigitSingle() {
		assertEquals(0, s.superDigit(0));
		assertEquals(9, s.superDigit(9));
	}
	@Test
	public void testSuperDigitShort() {
		assertEquals(1, s.superDigit(10));
		assertEquals(7, s.superDigit(25));
	}
	@Test
	public void testSuperDigitLong() {
		assertEquals(9, s.superDigit(99));
		assertEquals(3, s.superDigit(75));
		assertEquals(6, s.superDigit(9573));
		assertEquals(2, s.superDigit(98741));
		assertEquals(1, s.superDigit(1111111111111111111L));
	}
	@Test
	public void testSuperDigitBothMethods() {
		assertBothMethods(1234567890L);
		assertBothMethods(1111111111L);
		assertBothMethods(2222222222L);
		assertBothMethods(7777777777L);
		assertBothMethods(110022233344445555L);
	}
	private void assertBothMethods(long number) {
		assertEquals(s.superDigitRecursive(number),
				s.superDigit(number));
	}
	@Test
	public void testPrepareSuperDigitsForModulo() {
		int[][] result = s.prepareSuperDigitsForModulo();
		for (int[] superDigits : result) {
			System.out.println(Arrays.toString(superDigits));
		}
		
	}
}

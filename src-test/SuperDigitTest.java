import static org.junit.Assert.*;

import org.junit.Test;


public class SuperDigitTest {
	
	private SuperDigit s = new SuperDigit();

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
	}
}

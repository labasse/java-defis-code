package defis.solutions;

import static org.junit.Assert.*;
import org.junit.Test;

public class _2_1_PermutationSansTiers {

	@Test
	public void test() {
		byte a = 99;
		byte b = 101;
		
		a ^= b;
		b ^= a;
		a ^= b;
		
		assertEquals(101, a);
		assertEquals( 99, b);
	}

}

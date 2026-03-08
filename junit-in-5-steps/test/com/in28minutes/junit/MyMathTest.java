package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MyMathTest {
	private MyMath math = new MyMath();
	@Test
	void calculateSum_ZeroLengthArray() {
		assertEquals(0, math.calculateSum(new int[] {}));
	}

	@Test
	void calculateSum_ThreeMemberArray() {
		int result = math.calculateSum(new int[] {1,2,3});
		System.out.println(result);
		int expectedResult = 6;
		assertEquals(expectedResult, result);
		// absense of failure is success
		// test condition or assert
//		fail("Not yet implemented");
	}

}

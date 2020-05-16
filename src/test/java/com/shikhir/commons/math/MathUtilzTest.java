package com.shikhir.commons.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathUtilzTest {

	@Test
	public void testGetRandomNumberInRange() {
		int randomNumber = MathUtilz.getRandomNumberInRange(1, 100);
		assertTrue(randomNumber<=100&&randomNumber>=1?true:false);
	}

}

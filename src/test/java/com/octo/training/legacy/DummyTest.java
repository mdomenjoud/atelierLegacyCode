package com.octo.training.legacy;

import org.junit.Test;
import static org.fest.assertions.api.Assertions.assertThat;


public class DummyTest {
	private static final int LIFE = 2;
	private static final int UNIVERSE = 11;
	public static final int EVERYTHING = 29;

	@Test
	public void shouldBeGreen() {
		// Given
		Integer ultimateAnswer = LIFE + UNIVERSE + EVERYTHING;

		// Then
		assertThat(ultimateAnswer).isEqualTo(42);
	}
}

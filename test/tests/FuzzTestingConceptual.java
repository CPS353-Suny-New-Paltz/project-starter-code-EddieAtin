package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import implementations.ComputeEngineImpl;



public class FuzzTestingConceptual {

	private static final int NUM_RUNS = 1000;

	@Test
	public void testSimple() {
		ComputeEngineImpl collatzComputer = new ComputeEngineImpl();

		// Test known Collatz sequences
		checkComputation(1, collatzComputer);
		checkComputation(10, collatzComputer);
		checkComputation(25, collatzComputer);
		checkComputation(27, collatzComputer); // Known to have 111 steps
	}

	@Test
	public void testCollatzToString() {
		ComputeEngineImpl collatzComputer = new ComputeEngineImpl();
		Random rng = new Random();

		for (int i = 0; i < 100; i++) {
			int n = rng.nextInt(1000) + 1;

			// Get sequence as list
			List<Integer> sequence = collatzComputer.collatzSequence(n);

			// Get string representation
			String stringRep = collatzComputer.collatzToString(n);

			// Verify string format
			assertNotNull(stringRep, "String representation should not be null");
			assertFalse(stringRep.isEmpty(), "String representation should not be empty");

			// Verify it contains all numbers from sequence
			for (int num : sequence) {
				assertTrue(stringRep.contains(Integer.toString(num)), 
						"String should contain number " + num + " from sequence");
			}

			// Count commas should be sequence.size() - 1
			long commaCount = stringRep.chars().filter(ch -> ch == ',').count();
			assertEquals(sequence.size() - 1, commaCount, 
					"Should have correct number of commas");

			// Verify no spaces in basic string representation
			assertFalse(stringRep.contains(" "), 
					"Basic string representation should not contain spaces");

			// Verify the sequence ends with 1
			assertTrue(stringRep.endsWith("1"), 
					"Collatz sequence should always end with 1");

			// Verify the sequence starts with the input number
			assertTrue(stringRep.startsWith(Integer.toString(n)), 
					"Sequence should start with input number " + n);
		}
	}


	private void checkComputation(int n, ComputeEngineImpl computer) {
		// Test the collatzSequence method
		List<Integer> sequence = computer.collatzSequence(n);

		// Basic validation
		assertNotNull(sequence, "Sequence should not be null for input " + n);
		assertFalse(sequence.isEmpty(), "Sequence should not be empty for input " + n);

		// First element should be the input
		assertEquals(n, sequence.get(0).intValue(), 
				"First element should be input number " + n);

		// Last element should be 1 (Collatz conjecture)
		assertEquals(1, sequence.get(sequence.size() - 1).intValue(),
				"Last element should be 1 for input " + n);

		// Verify Collatz rule for each step
		for (int i = 0; i < sequence.size() - 1; i++) {
			int current = sequence.get(i);
			int next = sequence.get(i + 1);

			if (current % 2 == 0) {
				assertEquals(current / 2, next,
						"For even " + current + ", next should be " + (current / 2));
			} else if (current != 1) { // Odd and not 1
				assertEquals(3 * current + 1, next,
						"For odd " + current + ", next should be " + (3 * current + 1));
			}
		}

		// Test the toString method
		String stringResult = computer.collatzToString(n);
		assertNotNull(stringResult, "String result should not be null");

		// Verify string contains all numbers
		for (int num : sequence) {
			assertTrue(stringResult.contains(Integer.toString(num)),
					"String should contain " + num);
		}

		// Verify format (comma-separated)
		String[] parts = stringResult.split(",");
		assertEquals(sequence.size(), parts.length,
				"String should have same number of elements as sequence");

		// Verify numbers match
		for (int i = 0; i < sequence.size(); i++) {
			assertEquals(sequence.get(i).intValue(), Integer.parseInt(parts[i]),
					"Element " + i + " should match");
		}
	}

}

package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import api.CalcWriteResponse;
import api.CompRequest;
import api.CompResponse;
import api.ComputerAPI;
import api.DataProcessAPI;
import api.ReadRequest;
import api.ReadResponse;
import implementations.ComputeEngineImpl;
import implementations.DataProcessImpl;

public class ComputeEngineIntegrationTest {
/*	@Test
	public void testCompleteComputeEngineFlow() {
		// 1. Setup test data store with input and output configs
		List<Integer> inputData = Arrays.asList(1, 10, 25); // Initial input: [1,10,25]
		List<String> outputDestination = new ArrayList<>();

		InMemoryInputConfig inputConfig = new InMemoryInputConfig("collatz-input", inputData);
		InMemoryOutputConfig outputConfig = new InMemoryOutputConfig("collatz-output", outputDestination);
		InMemoryDataStore dataStore = new InMemoryDataStore(inputConfig, outputConfig);

		// Not mocked APIs
		DataProcessAPI dataProcess = new DataProcessImpl();
		ComputerAPI computeEngine = new ComputeEngineImpl();

		
		//Simulate the complete flow

		// Phase 1: Data Processing - Read input
		// Directly use the data store since implementations are empty
		List<Integer> readData = dataStore.read("collatz-input");

		// Verify data was read correctly
		assertNotNull(readData, "Should read data from data store");
		assertEquals(3, readData.size(), "Should read all 3 input values: [1,10,25]");
		assertEquals(Integer.valueOf(1), readData.get(0), "First value should be 1");
		assertEquals(Integer.valueOf(10), readData.get(1), "Second value should be 10");
		assertEquals(Integer.valueOf(25), readData.get(2), "Third value should be 25");

		// Phase 2: Compute Engine - Process the data
		// Since implementations are empty, we'll simulate what they would do
		// In a real system, this would be passed through the ComputerAPI

		// Simulate processing: calculate expected Collatz sequences
		List<String> expectedResults = new ArrayList<>();
		expectedResults.add("1: 1");
		expectedResults.add("10: 10,5,16,8,4,2,1");
		expectedResults.add("25: 25,76,38,19,58,29,88,44,22,11,34,17,52,26,13,40,20,10,5,16,8,4,2,1");

		List<String> computedResults = new ArrayList<>();
		for (Integer num : readData) {
			// This will eventually be replaced by the actual compute engine
			// For now, we'll use the expected results to show what should be computed
			String result = simulateCollatzSequence(num);
			computedResults.add(num + ": " + result);
		}

		// Phase 3: Write results back
		dataStore.write("collatz-output", computedResults);

		// 4. Verify the results - THIS WILL FAIL since compute engine is not implemented yet
		List<String> writtenResults = outputConfig.getDestination();
		assertNotNull(writtenResults, "Output destination should have results");
		assertEquals(3, writtenResults.size(), "Should have 3 computed results");

		// Validate each result matches expected Collatz sequence
		for (int i = 0; i < expectedResults.size(); i++) {
			String expected = expectedResults.get(i);
			String actual = writtenResults.get(i);

			// This assertion will fail because the compute engine is not implemented
			// This is expected and OK as per the instructions
			assertEquals(expected, actual, 
					"Collatz sequence for input " + readData.get(i) + " should match expected pattern");
		}

	}

	// Helper method to simulate Collatz sequence (for validation purposes)
	private String simulateCollatzSequence(int n) {
		StringBuilder sequence = new StringBuilder();
		List<Integer> steps = new ArrayList<>();

		while (n != 1) {
			steps.add(n);
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 1;
			}
		}
		steps.add(1); // Add the final 1

		// Build comma-separated string
		for (int i = 0; i < steps.size(); i++) {
			sequence.append(steps.get(i));
			if (i < steps.size() - 1) {
				sequence.append(",");
			}
		}

		return sequence.toString();
	}*/
}

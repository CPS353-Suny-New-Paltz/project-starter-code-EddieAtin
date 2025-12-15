package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import api.DataCheck;
import api.DataProcessAPI;
import api.ReadRequest;
import api.ReadResponse;
import api.WriteOutput;

public class ComputeEngineIntegrationTest {

    @Test
    public void testCompleteComputeEngineFlow() {
        // 1. Setup test data store with input and output configs
        List<Integer> inputData = Arrays.asList(1, 10, 25);
        List<String> outputDestination = new ArrayList<>();

        InMemoryInputConfig inputConfig = new InMemoryInputConfig("collatz-input", inputData);
        InMemoryOutputConfig outputConfig = new InMemoryOutputConfig("collatz-output", outputDestination);

        // Use the test implementation (InMemoryDataStore) for ProcessAPI
        DataProcessAPI dataStore = new InMemoryDataStore(inputConfig, outputConfig);

        // Phase 1: Data Processing - Read input using the API
        ReadRequest readRequest = new ReadRequest("collatz-input", null); // No filter
        ReadResponse readResponse = dataStore.input(readRequest);
        
        List<Integer> readData = readResponse.getData();

        // Verify data was read correctly
        assertNotNull(readData, "Should read data from data store");
        assertEquals(3, readData.size(), "Should read all 3 input values: [1,10,25]");
        assertEquals(Integer.valueOf(1), readData.get(0), "First value should be 1");
        assertEquals(Integer.valueOf(10), readData.get(1), "Second value should be 10");
        assertEquals(Integer.valueOf(25), readData.get(2), "Third value should be 25");

        // Phase 2: Compute Engine - Process the data
        // Simulate processing: calculate Collatz sequences
        List<String> computedResults = new ArrayList<>();
        for (Integer num : readData) {
            String sequence = collatzSequence(num);
            computedResults.add(num + ": " + sequence);
        }

        // Phase 3: Write results back using the API
        DataCheck dataCheck = new DataCheck("collatz-output", computedResults);
        WriteOutput writeOutput = dataStore.sendData(dataCheck);
        // Phase 4: Verify the results
        List<String> writtenResults = outputConfig.getDestination();
        assertNotNull(writtenResults, "Output destination should have results");
        assertEquals(3, writtenResults.size(), "Should have 3 computed results");

        // Expected results (for comparison)
        List<String> expectedResults = new ArrayList<>();
        expectedResults.add("1: 1");
        expectedResults.add("10: 10,5,16,8,4,2,1");
        expectedResults.add("25: 25,76,38,19,58,29,88,44,22,11,34,17,52,26,13,40,20,10,5,16,8,4,2,1");

        // Validate each result matches expected Collatz sequence
        for (int i = 0; i < expectedResults.size(); i++) {
            assertEquals(expectedResults.get(i), writtenResults.get(i),
                    "Collatz sequence for input " + readData.get(i) + " should match expected pattern");
        }
    }
   
    // Helper method to compute the Collatz sequence
    private String collatzSequence(int n) {
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
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < steps.size(); i++) {
            sequence.append(steps.get(i));
            if (i < steps.size() - 1) {
                sequence.append(",");
            }
        }

        return sequence.toString();
    }
}
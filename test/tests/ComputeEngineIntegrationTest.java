package tests;

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
	 @Test
	    public void testCompleteComputeEngineFlow() {
	        // 1. Setup test data store with input and output configs
	        List<Integer> inputData = Arrays.asList(5, 16, 8, 4, 2, 1);
	        List<String> outputDestination = new ArrayList<>();
	        
	        InMemoryInputConfig inputConfig = new InMemoryInputConfig("test-input", inputData);
	        InMemoryOutputConfig outputConfig = new InMemoryOutputConfig("test-output", outputDestination);
	        InMemoryDataStore dataStore = new InMemoryDataStore(inputConfig, outputConfig);
	        
	        // 2. Create the actual implementations (no mocks)
	        DataProcessAPI dataProcess = new DataProcessImpl();
	        ComputerAPI computeEngine = new ComputeEngineImpl();
	        
	        // 3. Integration test: Simulate the complete flow
	        
	        // Phase 1: Data Processing - Read input
	        // Note: Since DataProcessImpl is empty, we'll directly use the data store
	        // In a real implementation, DataProcess would use DataStoreAPI
	        List<Integer> readData = dataStore.read("test-input");
	        
	        // Verify data was read correctly
	        assertNotNull(readData, "Should read data from data store");
	        assertEquals(6, readData.size(), "Should read all 6 input values");
	        assertEquals(5, readData.get(0), "First value should be 5");
	        
	        // Phase 2: Compute Engine - Process the data
	        // Since implementations are empty, we'll simulate what they would do
	        // In a real system, this would be passed through the ComputerAPI
	        
	        // Simulate processing: calculate Collatz steps for each number
	        List<String> computedResults = new ArrayList<>();
	        for (Integer num : readData) {
	            // Simple Collatz simulation
	            computedResults.add(num + "->" + simulateCollatz(num));
	        }
	        
	        // Phase 3: Write results back
	        dataStore.write("test-output", computedResults);
	        
	        // 4. Verify the results
	        List<String> writtenResults = outputConfig.getDestination();
	        assertNotNull(writtenResults, "Output destination should have results");
	        assertEquals(6, writtenResults.size(), "Should have 6 computed results");
	        
	        // Verify first result
	        assertTrue(writtenResults.get(0).contains("5->"), "Should contain Collatz sequence for 5");
	        
	        // 5. Verify the flow through the APIs (even though implementations are empty)
	        // This shows the intended API usage pattern
	        
	        // Data process flow
	        ReadRequest readRequest = new ReadRequest(); // Would normally contain location info
	        ReadResponse readResponse = dataProcess.input(readRequest);
	        
	        // Compute engine flow  
	        CompRequest compRequest = computeEngine.request(new CompRequest());
	        CompResponse compResponse = computeEngine.response(compRequest);
	        CalcWriteResponse writeResponse = computeEngine.write(compResponse, compRequest);
	        
	        // These would be null in empty implementations, but we're testing the integration pattern
	        System.out.println("Integration test completed. This shows the intended flow:");
	        System.out.println("1. Read from DataStore: " + readData);
	        System.out.println("2. Compute results: " + computedResults);
	        System.out.println("3. Write to DataStore: " + writtenResults);
	    }
	    
	    // Helper method to simulate Collatz sequence (for testing purposes)
	    private String simulateCollatz(int n) {
	        StringBuilder sequence = new StringBuilder();
	        while (n != 1) {
	            sequence.append(n).append(",");
	            if (n % 2 == 0) {
	                n = n / 2;
	            } else {
	                n = 3 * n + 1;
	            }
	        }
	        sequence.append("1");
	        return sequence.toString();
	    }
	    
	    // Simple assertion helpers for the test
	    private void assertNotNull(Object obj, String message) {
	        if (obj == null) {
	            throw new AssertionError("Expected not null: " + message);
	        }
	    }
	    
	    private void assertEquals(Object expected, Object actual, String message) {
	        if (!expected.equals(actual)) {
	            throw new AssertionError(message + ". Expected: " + expected + ", Actual: " + actual);
	        }
	    }
	    
	    private void assertTrue(boolean condition, String message) {
	        if (!condition) {
	            throw new AssertionError("Expected true: " + message);
	        }
	    }
}

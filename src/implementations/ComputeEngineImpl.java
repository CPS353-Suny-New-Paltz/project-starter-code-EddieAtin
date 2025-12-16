package implementations;

import java.util.ArrayList;
import java.util.List;

import api.CalcWriteResponse;
import api.CompRequest;
import api.CompResponse;
import api.ComputerAPI;


public class ComputeEngineImpl implements ComputerAPI {

	
	@Override
	public CompRequest request(int x) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public CompResponse response(CompRequest request) {
		// TODO take in the request for the number from Comprequest
		int intToCompute = request.getComputeInt(); 
		//use the number and compute it's collatzSequence
		List<Integer> sequence = collatzSequence(intToCompute);

		return new CompResponse(sequence) ;
	}

	@Override
	public CalcWriteResponse write(CompResponse compResponse, CompRequest request) {
	    // Get the computed Collatz sequence
	    List<Integer> sequence = compResponse.getSequence();

	    // Convert sequence to a comma-separated string
	    StringBuilder sb = new StringBuilder(sequence.size() * 2);
	    for (int i = 0; i < sequence.size(); i++) {
	        if (i > 0) {
	            sb.append(",");
	        }
	        sb.append(sequence.get(i));
	    }

	    // Wrap the output string in a CalcWriteResponse
	    return new CalcWriteResponse(sb.toString());
	}
	
	public List<Integer> collatzSequence(int x){
		List<Integer> result = new ArrayList<>();

		//add initial value to sequence
		result.add(x);

		//perform calculation until x == 1 (complete computation) 
		while (x != 1) {
		    if (x % 2 == 0) {
		        x = x / 2;
		        result.add(x);
		    } else if (x % 2 == 1) {
		        x = (x * 3) + 1;
		        result.add(x);
		    }
		}

		return result;
	}
	
	public String collatzToString(int initialNum) {
		
        // Gets the sequence as a list of integers
            List<Integer> seq = collatzSequence(initialNum);
            
            // Builds the string
        StringBuilder sb = new StringBuilder(seq.size() * 2);
        
        // For loop to append each number and commas together
        for (int i = 0; i < seq.size(); i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(seq.get(i));
        }
        return sb.toString();
    }
	
}
	


package api;

import project.annotations.ConceptualAPIPrototype;

public class ComputeEnginePrototypeAPI {
	@ConceptualAPIPrototype 
	public void computeEnginePrototype(ComputerAPI components) {
		
		// read/writer component requests Collatz sequence of input to be calculated
		CalcRequest calcRequest = components.request(new CalcRequest());
		
		//Computing component will return back the output to the reader/writer component
		CompResponse compResponse = components.response(new CompResponse());
	}
}

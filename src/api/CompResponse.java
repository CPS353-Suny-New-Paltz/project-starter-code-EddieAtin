package api;

import java.util.List;

public class CompResponse {
	private List<Integer> sequence;
	private CompRequest request;
	public CompResponse(CompRequest request) {
		// TODO Auto-generated constructor stub
		this.request = request;
		sequence = null;
	}

	public CompResponse(List<Integer> sequence) {
		// TODO Auto-generated constructor stub
		this.request = request;
		this.sequence = sequence;
		
	}

	public List<Integer> getSequence() {
		// TODO Auto-generated method stub
		return sequence;
	}
	
}

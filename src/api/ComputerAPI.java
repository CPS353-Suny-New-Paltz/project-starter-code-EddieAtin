package api;

import project.annotations.ConceptualAPI;

@ConceptualAPI 
public interface ComputerAPI {



	CompResponse response(CompRequest request);

	CalcWriteResponse write(CompResponse compResponse, CompRequest request);

	CompRequest request(int x);

}

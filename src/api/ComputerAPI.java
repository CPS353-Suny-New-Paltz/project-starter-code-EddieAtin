package api;

import project.annotations.ConceptualAPI;

@ConceptualAPI 
public interface ComputerAPI {

	CalcRequest request(CalcRequest calcRequest);

	CompResponse response(CompResponse compResponse);

}

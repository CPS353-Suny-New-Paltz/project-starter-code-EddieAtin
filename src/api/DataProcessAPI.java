package api;
import java.util.ArrayList;

import project.annotations.ProcessAPI;

@ProcessAPI
public interface DataProcessAPI {

	
	WriteOutput sendData(DataCheck data);

	ReadResponse input(ReadRequest request);

	ReadInput input(ArrayList<Integer> sendList);

	WriteOutput sendData(ArrayList<Integer> dataOut);

}


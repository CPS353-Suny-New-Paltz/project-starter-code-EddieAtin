package api;
import java.util.ArrayList;

import project.annotations.ProcessAPI;

@ProcessAPI
public interface DataProcess {
	ReadInput input(ReadInput readInput);

	//WritingOutput
	WriteOutput sendData(ArrayList<Integer> sendList);

}

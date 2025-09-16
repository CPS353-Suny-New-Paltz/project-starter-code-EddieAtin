package api;
import project.annotations.ProcessAPI;

@ProcessAPI
public interface DataProcess {
	//reading input
	ReadInput input(ReadInput readInput);

	//WritingOutput
	WriteOutput sendData(WriteOutput writeOutput);

	//dataCheck
	DataCheck checker(DataCheck dataCheck);

}

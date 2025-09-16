package APIs;
import java.util.*;
import project.annotations.ProcessAPI;

@ProcessAPI
public interface DataProcess {
	//reading input
	ReadInput input(ReadInput readInput);

	//WritingOutput
	WriteOutput sendData(WriteOutput writeOutput);

	DataCheck checker(DataCheck dataCheck);

}

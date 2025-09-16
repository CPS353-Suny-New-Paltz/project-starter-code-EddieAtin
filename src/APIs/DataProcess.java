package APIs;
import java.util.*;
import project.annotations.*;

@ProcessAPI
public interface DataProcess {
	//reading input
	ReadInput input(ReadInput readInput);

	//WritingOutput
	WriteOutput sendData(ArrayList sendList);
}

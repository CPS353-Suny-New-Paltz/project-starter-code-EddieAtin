package APIs;
import project.annotations.ProcessAPIPrototype;


public class ProcessAPIProto{
@ProcessAPIPrototype
	public void ProcessAPIProto(DataProcess process){
		// take in the input
		ReadInput readInput = process.input(new ReadInput());
		
		//After comparing new input with Data Storage, 
		//check if it exists in the data bank
		DataCheck dataCheck = process.checker(new DataCheck());
		
		// sendData from process will locate the list from
		//the storage system. If it didn't exist in data bank, if will, sendData will
		//send a List with just the output.
		WriteOutput writeOutput = process.sendData(new WriteOutput());

				
	}
}
package tests;

import java.util.Collections;
import java.util.List;

import api.DataStoreAPI;

public class InMemoryDataStore implements DataStoreAPI{
	
	// Input locations
	  private final String inputLocation;
	  // Integers to return for ReadIntegers
	  private final List<Integer> inputs;
	  // Output location
	  private final String outputLocation;
	  // Destination for writeLines to write to
	  private final List<String> destination;

	  // Constructor
	  public InMemoryDataStore(InMemoryInputConfig inCfg, InMemoryOutputConfig outCfg) {
	    this.inputLocation = inCfg.getLocation();
	    this.inputs = inCfg.getList();
	    this.outputLocation = outCfg.getLocation();
	    this.destination = outCfg.getDestination();
	  }

	  @Override
	  public List<Integer> read(String location) {
		  
	    return (inputLocation != null && inputLocation.equals(location)) ? inputs : Collections.emptyList();
	  }

	  @Override
	  public void write(String location, List<String> output) {
		    if (outputLocation != null && outputLocation.equals(location) && output != null && !output.isEmpty()) {
		        destination.addAll(output);
		    }
		}
}
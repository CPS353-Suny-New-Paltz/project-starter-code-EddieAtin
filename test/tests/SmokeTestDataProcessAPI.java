package tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import api.DataCheck;
import api.ReadRequest;
import api.ReadResponse;
import api.WriteOutput;
import implementations.DataProcessImpl;


public class SmokeTestDataProcessAPI {


	@Test
	public void readResponseTest() {
		DataProcessImpl api = new DataProcessImpl();
		
		// Takes in the file and integers
		ReadResponse input = api.input(Mockito.mock(ReadRequest.class));

		// Assert
		assertNotNull(input, "the input is good");

	}


	@Test
	public void writeDataTest() {
		DataProcessImpl api = new DataProcessImpl();
		DataCheck dataCheck = Mockito.mock(DataCheck.class);

		WriteOutput data = api.sendData(dataCheck.getData());

		assertNotNull(data, "The Right Output");	
	}
}

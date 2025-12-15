package implementations;

import api.DataCheck;
import api.DataProcessAPI;
import api.ReadRequest;
import api.ReadResponse;
import java.util.ArrayList;

import api.DataProcessAPI;
import api.ReadInput;
import api.WriteOutput;

public class DataProcessImpl implements DataProcessAPI{
	
	@Override
	public ReadResponse input(ReadRequest request) {
	public ReadInput input(ArrayList<Integer> sendList) {
		return null;
	}
	
	@Override
	public WriteOutput sendData(DataCheck data) {
	public WriteOutput sendData(ArrayList<Integer> dataOut) {
		return null;
	}
}

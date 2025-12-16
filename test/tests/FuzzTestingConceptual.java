package tests;

import java.util.Random;

import org.junit.jupiter.api.Test;



public class FuzzTestingConceptual {

private static final int NUM_RUNS = 1000;
	
	@Test
	public void testSimple() {
		//AddingMachine testAddingMachine = new AddingMachine();
		//checkComputation(2, 3, testAddingMachine);
		}
	@Test
	public void testFuzzyAdding() {
		//TODO
		long seed = System.currentTimeMillis();
		Random rng = new Random(seed);
		System.out.println(seed);
		
		//AddingMachine toTest = new AddingMachine();
		for(int i = 0 ; i < NUM_RUNS; i++) { 
			
			int a = rng.nextInt();
			int b = rng.nextInt();
			//checkComputation(a,b,toTest);
		}
	}
}

import java.util.LinkedHashSet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class SwitchPairsSpec {
    
    private SwitchPairs switchPairs;
    private String[] devNames = {"Fengjia", "Jiukun", "Ouyang", "Dinglei", "Lifan"};;


    @Before
    public void setup() {
		switchPairs = new SwitchPairs();
    }

    // Test method: getIndex
    @Test
    public void should_output_correct_index_in_devNames_array_for_given_Dev_Name() {
    	
    	int index = switchPairs.getIndex("Fengjia", devNames);
    	assertEquals(0, index);

    	index = switchPairs.getIndex("Lifan", devNames);
    	assertEquals(4, index);

    	index = switchPairs.getIndex("Ouyang", devNames);
    	assertEquals(2, index);
    }

    // Test method: randomSetGenerator
    @Test
    public void should_generate_numbers_with_size_of_5() {
    	int max = devNames.length;
		int n = max;
		LinkedHashSet<Integer> pairList = new LinkedHashSet<Integer>();

		switchPairs.randomSetGenerator(n, max, pairList);

		assertEquals(5, pairList.size());
    }


    @Test
    public void should_output_correct_without_duplicate_digits() {

    	int max = devNames.length;
		int n = max;
		LinkedHashSet<Integer> pairList = new LinkedHashSet<Integer>();
		LinkedHashSet<Integer> unexpectResultSet = new LinkedHashSet<Integer>();

		for (int i = 0; i < max ; i++ ) {
			unexpectResultSet.add(i);
		}

		switchPairs.randomSetGenerator(n, max, pairList);
		
		// assert number has no duplicate digits
		assertTrue(unexpectResultSet.containsAll(pairList));

    }
 }

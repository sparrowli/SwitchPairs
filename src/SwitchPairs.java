import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Random;


public class SwitchPairs {

	public void randomSetGenerator(int count, int max, LinkedHashSet<Integer> set) {
	    Random randomGenerator = new Random();
	
	    for (int i = 0; i < count; i++) {
	    	int temp = randomGenerator.nextInt(100);
		    int num = temp % max;
	        set.add(num);    
	    }
	    	int setSize = set.size();
	    	if (setSize < count ) {
			randomSetGenerator(count, max, set);
	    }
	}
 
	public void printPairResult(Set<Integer> pairList, String[] devNames) {
	
		int i = 0; 
		int totalLen = devNames.length;
		boolean isOdd = (totalLen % 2 != 0);
		Iterator<Integer> pairSet = pairList.iterator();
		
		while(pairSet.hasNext()) {
			if ( 0 == i && isOdd ) {
				System.out.println("\nCongratulations, " + devNames[pairSet.next()] + ", today you will solo one ticket!");	
				i++;
			} else {
				System.out.println("\nPair: " + devNames[pairSet.next()] + ", " + devNames[pairSet.next()]);
				i += 2;
			}	
		}

	}

   public static int getIndex(String specialName, String[] devNames) {
    	for (int i = 0; i < devNames.length ; i++) {
    		if (specialName.equals(devNames[i])) {
    			return i;
    		}
    	}
    	return -1;
    }

    public void checkNewHire(Set<Integer> pairList, int localSpecial) {
    	Integer[] pairArray = pairList.toArray(new Integer[0]);

    	for (int i = 0; i < pairArray.length; i++ ) {
    		if (pairArray[0] == localSpecial) {
  //  			System.out.println("New Hire can not handle one ticket sololy.");
    			pairList.remove(localSpecial);
    			pairList.add(localSpecial);
    			break;
    		}
    	}
    }

	public static void main(String[] args) {
		String[] devNames = {"Fengjia", "Jiukun", "Ouyang", "Dinglei", "Lifan"};
		
		SwitchPairs switchPairs = new SwitchPairs();

		int max = devNames.length;
		int n = max;
		LinkedHashSet<Integer> pairList = new LinkedHashSet<Integer>();

		int localSpecial = getIndex("Lifan", devNames);

		switchPairs.randomSetGenerator(n, max, pairList);

		switchPairs.checkNewHire(pairList, localSpecial);
		
		switchPairs.printPairResult(pairList, devNames);
    }

}

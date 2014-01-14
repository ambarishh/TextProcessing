package one.b;

import one.a.Frequency;
import one.a.Utilities;
import java.io.*;
import java.util.*;

class FrequencyComparator implements Comparator{
	/**
	 * Comparator sorts the frequency based on frequency count
	  If frequencies tie, we sort alphabetically
	*/
	public int compare(Object obj1, Object obj2) {
		Frequency first = (Frequency) obj1;
		Frequency second = (Frequency) obj2;
		
	    int freqComp = second.getFrequency()-first.getFrequency();
	    return ((freqComp == 0) ? first.getText().compareTo (second.getText()) : freqComp);
	}	
}

/**
 * Counts the total number of words and their frequencies in a text file.
 */
public final class WordFrequencyCounter {
	/**
	 * This class should not be instantiated.
	 */
	private WordFrequencyCounter() {}
	
	/**
	 * Takes the input list of words and processes it, returning a list
	 * of {@link Frequency}s.
	 * 
	 * This method expects a list of lowercase alphanumeric strings.
	 * If the input list is null, an empty list is returned.
	 * 
	 * There is one frequency in the output list for every 
	 * unique word in the original list. The frequency of each word
	 * is equal to the number of times that word occurs in the original list. 
	 * 
	 * The returned list is ordered by decreasing frequency, with tied words sorted
	 * alphabetically.
	 * 
	 * The original list is not modified.
	 * 
	 * Example:
	 * 
	 * Given the input list of strings 
	 * ["this", "sentence", "repeats", "the", "word", "sentence"]
	 * 
	 * The output list of frequencies should be 
	 * ["sentence:2", "the:1", "this:1", "repeats:1",  "word:1"]
	 *  
	 * @param words A list of words.
	 * @return A list of word frequencies, ordered by decreasing frequency.
	 */
	public static List<Frequency> computeWordFrequencies(List<String> words) {
		HashMap<String, Integer> myHashMap = new HashMap<String, Integer>();
        //HashMap preparation
		for (String str : words) {
			if (myHashMap.containsKey(str)) myHashMap.put(str, myHashMap.get(str) + 1);
			else myHashMap.put(str, 1);
		}
		
      //Preparing the arrrayList of frequencies
		ArrayList<Frequency> myList= new ArrayList<Frequency>();
		
		for(String str: myHashMap.keySet())
			myList.add(new Frequency(str,myHashMap.get(str)));
		Collections.sort(myList,new FrequencyComparator());
		return myList;

	}
	
	/**
	 * Runs the word frequency counter. The input should be the path to a text file.
	 * 
	 * @param args The first element should contain the path to a text file.
	 */
	
	public static void main(String[] args) throws IOException, FileNotFoundException{
		if(args.length!=1)
		{
			System.out.println("Kindly specify one file.");
			System.exit(360);			
		}
		File file = new File(args[0]);
		List<String> words = Utilities.tokenizeFile(file);	
		List<Frequency> frequencies = computeWordFrequencies(words);
		Utilities.printFrequencies(frequencies);
	}
	
}

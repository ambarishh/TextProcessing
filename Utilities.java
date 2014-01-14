

import java.io.*;
import java.util.*;

/**
 * A collection of utility methods for text processing.
 */
public class Utilities {
	/**
	 * Reads the input text file and splits it into alphanumeric tokens.
	 * Returns an ArrayList of these tokens, ordered according to their
	 * occurrence in the original text file.
	 * 
	 * Non-alphanumeric characters delineate tokens, and are discarded.
	 *
	 * Words are also normalized to lower case. 
	 * 
	 * Example:
	 * 
	 * Given this input string
	 * "An input string, this is! (or is it?)"
	 * 
	 * The output list of strings should be
	 * ["an", "input", "string", "this", "is", "or", "is", "it"]
	 * 
	 * @param input The file to read in and tokenize.
	 * @return The list of tokens (words) from the input file, ordered by occurrence.
	 */
	public static ArrayList<String> tokenizeFile(File input) throws IOException, FileNotFoundException{
		// TODO Write body!
		String strLine = "";
		String[] resultStringArray;
		ArrayList<String> output = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(input));
		while(br.ready())
			{
			strLine = br.readLine();
			strLine = strLine.replaceAll("[^a-zA-Z0-9]", " ");
			resultStringArray = strLine.split("\\s");
			for(String str:resultStringArray)
			{
				if(!str.isEmpty()) output.add(str.toLowerCase());
			}
	}
		br.close();
		return output;
	
	}
	
	/**
	 * Takes a list of {@link Frequency}s and prints it to standard out. It also
	 * prints out the total number of items, and the total number of unique items.
	 * 
	 * Example one:
	 * 
	 * Given the input list of word frequencies
	 * ["sentence:2", "the:1", "this:1", "repeats:1",  "word:1"]
	 * 
	 * The following should be printed to standard out
	 * 
	 * Total item count: 6
	 * Unique item count: 5
	 * 
	 * sentence	2
	 * the		1
	 * this		1
	 * repeats	1
	 * word		1
	 * 
	 * 
	 * Example two:
	 * 
	 * Given the input list of 2-gram frequencies
	 * ["you think:2", "how you:1", "know how:1", "think you:1", "you know:1"]
	 * 
	 * The following should be printed to standard out
	 * 
	 * Total 2-gram count: 6
	 * Unique 2-gram count: 5
	 * 
	 * you think	2
	 * how you		1
	 * know how		1
	 * think you	1
	 * you know		1
	 * 
	 * @param frequencies A list of frequencies.
	 */
	public static void printFrequencies(List<Frequency> frequencies) {
		// TODO Write body!
		 int totalItemCount=0;
	     int uniqueItemCount=0;	       
	       for (Frequency freq: frequencies)
	       {
	               System.out.println(freq.getText()+" : " +  freq.getFrequency()); 
	               uniqueItemCount++; 
	               totalItemCount+=freq.getFrequency();	               
	       }
	       System.out.println("Total count: " + totalItemCount);
	       System.out.println("Unique count: "+uniqueItemCount );
	}
}

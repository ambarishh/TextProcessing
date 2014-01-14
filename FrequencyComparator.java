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
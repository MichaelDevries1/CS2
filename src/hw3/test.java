package hw3;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

public class test {
	public static void main (String[] args) throws IOException {
		BufferedReader read = new BufferedReader (new FileReader ("CountriesInfo.txt"));
		LinkedList<CountriesLL> countLL = new LinkedList<CountriesLL>();
		
		String tempString = read.readLine();
		
		while (tempString != null) {
			String[] piece = tempString.split(",");
			CountriesLL temp = new CountriesLL(piece[0], piece[1], piece[2], Integer.parseInt(piece[3]), 
				Integer.parseInt(piece[4]), Double.parseDouble(piece[5]), Integer.parseInt(piece[6]));
		
			countLL.addFirst(temp);
			
			tempString = read.readLine();
		} // end while
		
		Iterator<CountriesLL> itr = countLL.iterator();
		
		while (itr.hasNext()) {
			CountriesLL cll = (CountriesLL)itr.next();
			System.out.println(cll.countryName + " " + cll.latitude + "  " + cll.longitude + " " + 
					cll.countryArea + " " + cll.countryPopulation + " " + cll.countryYear);
		} // end while
	} // end main
} // end test

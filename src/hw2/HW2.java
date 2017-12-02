package hw2;

import java.util.*;
import java.io.*;

public class HW2 {
	public static void main (String [] args) throws IOException {
		Scanner scn = new Scanner(System.in);
	      
		// Input files
		BufferedReader inputCI = new BufferedReader 									// Countries input file
				(new FileReader ("CountriesInfo.txt"));								
		BufferedReader inputCILL = new BufferedReader 								// CountriesLL input file
				(new FileReader ("CountriesInfo.txt"));								
		BufferedReader inputB = new BufferedReader 									// Borders input file
				(new FileReader ("BordersInfo.txt"));									
		BufferedReader inputBLL = new BufferedReader 								// BordersLL input file
				(new FileReader ("BordersInfo.txt"));
	      
		// Creates the 2 arrays
		Countries[] countryArr = new Countries[9];									// Array for country info
		Borders[] bordersArr = new Borders[8];										// Array for Borders
	      
		// Creates the 2 linked-lists
		LinkedListHW2<Countries> cll = new LinkedListHW2<Countries>();					// Linked List for Countries
		LinkedListHW2<Borders> bll = new LinkedListHW2<Borders>();						// Linked List for Borders.
	      
		int answer = 0;
	      
		sop("Please select the option you want the information for:\n" + 				// Request an input for menu
				"**The first option is required before the others in order " + 			// 
				"to populate your results.\n", 1);     	 							//
	          
		// Menu section
		while (answer != 5) {													// Check if program should end
			answer = menu(scn);		                        							// Display options and request input
			switch (answer) {															
				case 1: 														// Imports data into arrays and linked lists
					countryArr = country(countryArr, inputCI);
					bordersArr = border(bordersArr, inputB);
					cll = countryLL(cll, inputCILL);
					bll = borderLL(bll, inputBLL);
					break;
				case 2:														// Prints the countries bordering a specified country
					borders(bordersArr, bll);
					break;
				case 3:														// Prints the countries with pop >= 35 mil
					pop(countryArr, cll);
					break;
				case 4:														// Prints the countries bordering a specified country
					both(bordersArr, countryArr, cll, bll);							// which also has a pop >= 35 mil	
					break;
				case 5:														// Closes the program
					break;
				default:
					sop("Invalid input. Please "  +       							// Invalid input catch
			                "respond with numbers 1-5.", 1);
					break;
			} // end switch
		} // end while
		
		// Close all the scanners
		inputCI.close();
		inputCILL.close();
		inputB.close();
		inputBLL.close();
	} // End Main
//=========================================================================================================================================	
	public static int menu (Scanner scn) {
		sop("1) Import the data\n"               						  + 			// Display menu items
			"2) Display list of all countries that border Germany\n"  		  +			//
			"3) Display list of all countries that have a population greater " + 			//
			"than 35 million\n"                  						  +			// 
			"4) Display list of all countries that border Germany AND have a " +	 		// 
			"population greater than 35 million\n"        				  +		 	// 
			"5) Quit the Program\n", 1);											//
		return scn.nextInt();													// Returns the option the user chooses
	} // end bordersLL
//=========================================================================================================================================	
	public static Countries[] country (Countries[] ca, BufferedReader input) throws IOException {
		int i = 0;															// Counter
		String temp = input.readLine();											// Read the first line
		while (temp != null && i < ca.length) {										// Iterate till input file is empty
			String[] p = temp.split(",");											// Separate information
			ca[i] = new Countries(p[0], p[1], p[2], Integer.parseInt(p[3]),				// Create new country instance
					Integer.parseInt(p[4]),Double.parseDouble(p[5]),
					Integer.parseInt(p[6]));
			
			temp = input.readLine();												// Read the next line
			i++;																// Iterate
		} // End while
		return ca;															// Return the filled countries array
	} // end country
//=========================================================================================================================================	
	public static Borders[] border(Borders[] ba, BufferedReader input) throws IOException {
		int i = 0;															// Counter
	      String temp = input.readLine();											// Read first line
	      while (temp != null && i < ba.length) {									// Iterate till input file is empty
	         String[] p = temp.split(",");											// Separate information
	         ba[i] = new Borders(p[0], p[1]);										// Create new borders instance
	         temp = input.readLine(); 												// Read next line
	         i++;																// Iterate
	      } // End while
	      return ba;															// Return the filled borders array
	} // end border
//=========================================================================================================================================	
	public static LinkedListHW2<Countries> countryLL (LinkedListHW2<Countries> cll, BufferedReader input) throws IOException {
		String tempString = input.readLine();										// Read first line
		   
		   while (tempString != null) {											// Iterate till input file is empty
			   String[] p = tempString.split(",");									// Separate information
			   Countries temp = new Countries (p[0], p[1], p[2], 						// Create new country instance
					   Integer.parseInt(p[3]), Integer.parseInt(p[4]), 
					   Double.parseDouble(p[5]), Integer.parseInt(p[6]));
			   
			   cll.addFirst(temp);												// Add the instance to the front of the list
			   
			   tempString = input.readLine();										// Read the next line
		   } // end while
		   
		   return cll;															// Return the filled countries linked list
	} // end countryLL
//=========================================================================================================================================	
	public static LinkedListHW2<Borders> borderLL (LinkedListHW2<Borders> bll, BufferedReader input) throws IOException {
		String tempString = input.readLine();										// Read the first line
		   
		while (tempString != null) {												// Iterate till file is empty
			String[] piece = tempString.split(",");									// Separate information
			Borders temp = new Borders (piece[0], piece[1]);							// Create new borders instance
			   
			bll.addFirst(temp);													// Add the instance to the front of the list
			   
			tempString = input.readLine();										// Read next line
		} // end while
		   
		return bll;															// Return the filled borders linked list
	} // end borderLL
//=========================================================================================================================================	
	public static void borders (Borders[] b, LinkedListHW2<Borders> bll) {
		// Borders in the array
		int counter = 0;
		String country = "Germany";
		for (int i = 0; i < b.length; i++) {
			if (b[i].country1.equalsIgnoreCase(country)) {							// Check if any of the first countries match 
				sop(b[i].country2 + " ", 2);										// the given name and print out its borders
				counter++;
			} // end if
			// Format the resulting list
			if (counter == 4) {
				sop("", 1);
				counter = 0;
			} // end if
		} // end for
		sop("", 1);
		
		// Borders in the Linked List
		Iterator<Borders> itr = bll.iterator();
		counter = 0;
		
		while (itr.hasNext()) {
			Borders bo = (Borders)itr.next();
			if (bo.country1.equalsIgnoreCase(country)) {								// Check if any of the first countries match 
				sop(bo.country2 + " ", 2);										// the given name and print out its borders
				counter++;
			} // end if
			// Format the resulting list
			if (counter == 4) {
				sop("", 1);
				counter = 0;
			} // end if
		} // end while
		sop("\n", 1);
	} // end borders
//=========================================================================================================================================	
	public static void pop(Countries[] c, LinkedListHW2<Countries> cll) {
		// Array population
		int counter = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i].countryPopulation >= 35000000) {								// Check if any of the countries have a
				sop(c[i].countryName + " ", 2);									// population greater than 35,000,000
	            counter++;
			} // end if
			if (counter == 4) {
				sop("", 1);
			} // end if
		} // end for
		sop("\n", 1);
		
		// Linked List population
		Iterator<Countries> itr = cll.iterator();
		counter = 0;
		
		while (itr.hasNext()) {
			Countries co = (Countries)itr.next();
			if (co.countryPopulation >= 35000000) {									// Check if any of the countries have a  
				sop(co.countryName + " ", 2);										// population greater than 35,000,000
				counter++;
			} // end if
			if (counter == 4) {
				sop("", 1);
				counter = 0;
			} // end if
		} // end while
		sop("\n", 1);
	} // end population
//=========================================================================================================================================	
	public static void both(Borders[] b, Countries[] c, LinkedListHW2<Countries> cll,
			LinkedListHW2<Borders> bll) {
		// Array both
		int counter = 0;
		String country = "Germany";
		for (int i = 0; i < c.length; i++) {
			if (c[i].countryPopulation >= 35000000) {
				for (int j = 0; j < b.length; j++) {
					if (b[j].country1.equalsIgnoreCase(country) && 
							c[i].countryName.equalsIgnoreCase(b[j].country2)) {
						sop(b[j].country2 + " ", 2);
						counter++;
						break;
					} // end if
					if (counter == 4) {
						sop("", 1);
					} // end if
				} // end for
			} // end if
		} // end for
		sop("", 1); 
		counter = 0;
		
		// Linked List both
		Iterator<Countries> citr = cll.iterator();
		
		while (citr.hasNext()) {
			Countries co = (Countries)citr.next();
			Iterator<Borders> bitr = bll.iterator();
			if (co.countryPopulation >= 35000000) {
				while (bitr.hasNext()) {
					Borders bo = (Borders)bitr.next();
					boolean t1 = bo.country1.equalsIgnoreCase(country);
					if (t1 && co.countryName.equalsIgnoreCase(bo.country2)) {
						sop(co.countryName + " ", 2);
						counter++;
						break;
					} // end if
					if (counter == 4) {
						sop("", 1);
					} // end if
				} // end while 
			} // end if
		} // end while
		sop("", 1); 
	} // end both
//=========================================================================================================================================	
	public static void sop (String s, int i) {
		if (i == 1) {
			System.out.println(s);
		} // end if
		if (i == 2) {
			System.out.print(s);
		} // end if
	} // end sop
		
} // end HW2
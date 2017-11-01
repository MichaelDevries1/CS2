package hw3;

import java.io.*;
import java.util.*;

public class HW3<AnyType> {
	public static void main (String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		
		BufferedReader inputCI = new BufferedReader 								// Countries input file
				(new FileReader("CountriesInfo.txt"));
		BufferedReader inputB = new BufferedReader									// Borders input file
				(new FileReader("BordersInfo.txt"));
		BufferedReader inputCLL = new BufferedReader								// Countries Linked List input file
				(new FileReader("CountriesInfo.txt"));
		BufferedReader inputBLL = new BufferedReader								// Borders Linked List input file
				(new FileReader("BordersInfo.txt"));
		
//		PrintWriter output = new PrintWriter										// Output file 
//				(new FileWriter("Outputfile.txt"));
		
		//Creates the 2 Array Lists
		List<Countries> count = new ArrayList<Countries>();
		List<Borders> border = new ArrayList<Borders>();
				
		// Creates the 2 Linked Lists
		LinkedList<CountriesLL> countLL = new LinkedList<CountriesLL>();
		LinkedList<BordersLL> borderLL = new LinkedList<BordersLL>();
		
		int answer = 0;
		
		sop("Please select the option you want the information for:\n" 			+ 	// Request an input for menu
			"**The first option is required before the others in order"			+ 
			"to populate your results.", 1);
		
		// Menu selection
		while (answer != 5) {														// Check if program should end
			answer = menu(scn);														// Display options and request input
			switch(answer) {
				case 1:
					count = countryAL(count, inputCI);								// Obtain the Country Array List
					border = borderAL(border, inputB);								// Obtain the Border Array List
					countryLL(countLL, inputCLL);									// Obtain the Country Linked List
					bordersLL(borderLL, inputBLL);									// Obtain the Border Linked List
					
					sop("**Data Imported Successfully**\n", 1);						// Verifies data import
					break;
				case 2:
					bordering(border, borderLL);									// Displays bordering countries
					break;
				case 3: 
					pop(count, countLL);									// Displays countries with pop of 35mil+
					break;
				case 4:
					both(count, border, countLL, borderLL);							// Displays countries that both border Germany
					break;															// and has a pop of 35mil+
				case 5:
					break;															// Breaks the loop and ends the program
				default:
					sop("Invalid input. Please respond with numbers 1-5.", 1);
					break;
			} // end switch
		} // end while
		
		// Close all the scanners
		inputCI.close();
		inputB.close();
		inputCLL.close();
		inputBLL.close();
	} // end main
//=========================================================================================================================================
	public static int menu(Scanner scn) {
		sop("1) Import the data\n"               								+ 	// Display menu items
		    "2) Display list of all countries that border Germany\n"  			+	//
		    "3) Display list of all countries that have a population greater "  + 	//
		    "than 35 million\n"                  								+	// 
		    "4) Display list of all countries that border Germany AND have a "  + 	// 
		    "population greater than 35 million\n"        						+ 	// 
		    "5) Quit the Program\n", 1);           									// 
		return scn.nextInt();
	} // end menu
//=========================================================================================================================================
	public static List<Countries> countryAL (List<Countries> arr, BufferedReader input) throws IOException {
		String temp = input.readLine();
		while (temp != null) {
			String[] piece = temp.split(",");
			Countries nC = new Countries(piece[0], piece[1], piece[2], 
					Integer.parseInt(piece[3]), Integer.parseInt(piece[4]), 
					Double.parseDouble(piece[5]), Integer.parseInt(piece[6]));

			arr.add(nC);
			temp = input.readLine();
		} // end while

		return arr;
	} // end 
//=========================================================================================================================================	
	public static List<Borders> borderAL(List<Borders> arr, BufferedReader input) throws IOException {
		String temp = input.readLine();
		while (temp !=  null) {
			String[] piece = temp.split(",");
			Borders nB = new Borders(piece[0], piece[1]);
			
			arr.add(nB);
			temp = input.readLine();
		} // end while
		
		return arr;
	} // end border
//=========================================================================================================================================
	public static void countryLL(LinkedList<CountriesLL> ll, BufferedReader input) throws IOException {
		String tempString = input.readLine();
		
		while (tempString != null) {
			String[] piece = tempString.split(",");
			CountriesLL temp = new CountriesLL (piece[0], piece[1], piece[2], 
					Integer.parseInt(piece[3]), Integer.parseInt(piece[4]), 
					Double.parseDouble(piece[5]), Integer.parseInt(piece[6]));
			
			ll.addFirst(temp);
			
			tempString = input.readLine();
		} // end while
	} // end countryLL
//=========================================================================================================================================	
	public static void bordersLL(LinkedList<BordersLL> ll, BufferedReader input) throws IOException {
		String tempString = input.readLine();
		
		while (tempString != null) {
			String[] piece = tempString.split(",");
			BordersLL temp = new BordersLL (piece[0], piece[1]);
			
			ll.addFirst(temp);
			
			tempString = input.readLine();
		} // end while
	} // end bordersLL
//=========================================================================================================================================	
	public static void bordering(List<Borders> arr, LinkedList<BordersLL> ll) {
		// Bordering countries array list
		String query = "Germany";
		Iterator<Borders> itr = arr.iterator();
		
		while (itr.hasNext()) {
			Borders bo = (Borders)itr.next();
			if (bo.country1.equalsIgnoreCase(query)) {
				sop(bo.country2 + " ", 2);
			} // end if
		} // end while
		sop("", 1);
		
		// Bordering countries linked list
		Iterator<BordersLL> bitr = ll.iterator();
		
		while (bitr.hasNext()) {
			BordersLL bll = (BordersLL)bitr.next();
			if (bll.country1.equalsIgnoreCase(query)) {
				sop(bll.country2 + " ", 2);
			} // end if
		} // end while
		sop("", 1);
	} // end bordering
//=========================================================================================================================================	
	public static void pop(List<Countries> arr, LinkedList<CountriesLL> ll) {
		// Population query array list
		Iterator<Countries> itr = arr.iterator();
		
		while (itr.hasNext()) {
			Countries co = (Countries)itr.next();
			if (co.countryPopulation >= 35000000) {
				sop(co.countryName + " ", 2);
			} // end if
		} // end while
		sop("", 1);
		
		// Population query linked list
		Iterator<CountriesLL> citr = ll.iterator();
		
		while (citr.hasNext()) {
			CountriesLL cll = (CountriesLL)citr.next();
			if (cll.countryPopulation >= 35000000) {
				sop(cll.countryName + " ", 2);
			} // end if
		} // end while
		sop("", 1);
	} // end pop
//=========================================================================================================================================	
	public static void both(List<Countries> carr, List<Borders> barr, LinkedList<CountriesLL> cll,
			LinkedList<BordersLL> bll) {
		// Both array list
		int counter = 0;
		String query = "Germany";
		Iterator<Countries> citr = carr.iterator();
		
		while (citr.hasNext()) {
			Countries co = (Countries)citr.next();
			Iterator<Borders> bitr = barr.iterator();
			if (co.countryPopulation >= 35000000) {
				while (bitr.hasNext()) {
					Borders bo = (Borders)bitr.next();
					if (bo.country1.equalsIgnoreCase(query) && 
							co.countryName.equalsIgnoreCase(bo.country2)) {
						sop(co.countryName + " ", 2);
						counter++;
					} // end if
					if (counter == 4) {
						sop("", 1);
					} // end if
				} // end while
			} // end if
		} // end while
		sop("", 1);
		
		// Both linked list
		counter = 0;
		
		Iterator<CountriesLL> cllitr = cll.iterator();
		
		while (cllitr.hasNext()) {
			CountriesLL cl = (CountriesLL)cllitr.next();
			Iterator<BordersLL> bllitr = bll.iterator();
			if (cl.countryPopulation >= 35000000) {
				while (bllitr.hasNext()) {
					BordersLL bl = (BordersLL) bllitr.next();
					if (bl.country1.equalsIgnoreCase(query) && 
							cl.countryName.equalsIgnoreCase(bl.country2)) {
						sop(cl.countryName + " ", 2);
						counter++;
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
} // end HW3

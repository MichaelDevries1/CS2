package hw2;

public class CountriesNode {
	public String countryName = null;
    public String latitude = null;
    public String longitude = null;
    public int countryArea = 0;
    public int countryPopulation = 0;
    public double countryGDP = 0.0;
    public int countryYear = 0;
    public CountriesNode next = null;
    public CountriesNode head = null;
    public CountriesNode tail = null;
    
    public CountriesNode () {
    	
    }

    public CountriesNode (String name, String lat, String lon, int area,
                    int pop, double gdp, int year, CountriesNode next) {
	   this.countryName = name;
	   this.latitude = lat;
	   this.longitude = lon;
	   this.countryArea = area;
	   this.countryPopulation = pop;
	   this.countryGDP = gdp;
	   this.countryYear = year;
	   this.next = next;
    } // end Node
  
    public CountriesNode (Countries cName, CountriesNode next) {
    	this.countryName = cName.countryName;
    	this.latitude = cName.latitude;
    	this.longitude = cName.longitude;
    	this.countryArea = cName.countryArea;
    	this.countryPopulation = cName.countryPopulation;
    	this.countryGDP = cName.countryGDP;
    	this.countryYear = cName.countryYear;
    	this.next = next;
	} // end Node
    
    public void LinkedList(CountriesNode head) {
    	this.head = head;
    	this.tail = head;
    }
    public void addToFront (CountriesNode newHead) {
    	newHead.next = head;
    	this.head = newHead;
    }
} // end countriesLL
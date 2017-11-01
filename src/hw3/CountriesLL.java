package hw3;

public class CountriesLL {
	public String countryName;
	public String latitude;
	public String longitude;
	public int countryArea;
	public int countryPopulation;
	public double countryGDP;
	public int countryYear;

   
	public CountriesLL (String name, String lat, String lon, int area,
                    int pop, double gdp, int year) {
		this.countryName = name;
		this.latitude = lat;
		this.longitude = lon;
		this.countryArea = area;
		this.countryPopulation = pop;
		this.countryGDP = gdp;
		this.countryYear = year;
	} // end Node
  
  
} // end countriesLL
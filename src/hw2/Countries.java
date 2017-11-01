package hw2;

public class Countries {
   public String countryName = null;
   public String latitude = null;
   public String longitude = null;
   public int countryArea = 0;
   public int countryPopulation = 0;
   public double countryGDP = 0.0;
   public int countryYear = 0;
   
   public Countries() {

   }
   
   public Countries (String name, String latitude, String longitude, int area, int pop, double gdp, int year){
	   this.countryName = name;
	   this.latitude = latitude;
	   this.longitude = longitude;
	   this.countryArea = area;
	   this.countryPopulation = pop;
	   this.countryGDP = gdp;
	   this.countryYear = year;
   } // end countries


}
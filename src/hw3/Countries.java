package hw3;

public class Countries {
   public String countryName;
   public String latitude;
   public String longitude;
   public int countryArea;
   public int countryPopulation;
   public double countryGDP;
   public int countryYear;

   public Countries (String countryName, String latitude, String longitude,
		   int countryArea, int countryPopulation, double countryGDP, int countryYear){
	   this.countryName = countryName;
	   this.latitude = latitude;
	   this.longitude = longitude;
	   this.countryArea = countryArea;
	   this.countryPopulation = countryPopulation;
	   this.countryGDP = countryGDP;
	   this.countryYear = countryYear;
   } // end countries
} // end countries class
package module3;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.utils.MapUtils;
import parsing.ParseFeed;
import de.fhpotsdam.unfolding.providers.*;

import java.util.List;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;

import java.util.HashMap;

import de.fhpotsdam.unfolding.marker.Marker;

public class LifeExpectancy extends PApplet {
	
	
	private static final long serialVersionUID = 1L;
	UnfoldingMap map;
	HashMap<String, Float> lifeExpByCountry;
	
	List<Feature> countries;
	List<Marker> countryMarkers;

	@Override
	public void setup() {
		size(800, 600, OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);

		// Load lifeExpectancy data
		lifeExpByCountry = ParseFeed.loadLifeExpectancyFromCSV(this,"LifeExpectancyWorldBank.csv");
		

		// Load country polygons and adds them as markers
		countries = GeoJSONReader.loadData(this, "countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		map.addMarkers(countryMarkers);
		System.out.println(countryMarkers.get(0).getId());
		
		// Country markers are shaded according to life expectancy (only once)
		shadeCountries();
	}
	
	@Override
	public void draw() {
		map.draw();
	}
	
	private void shadeCountries() {
		for(Marker marker : countryMarkers) {
			String countryId = marker.getId();
			
			if(lifeExpByCountry.containsKey(countryId)) {
				float lifeExp = lifeExpByCountry.get(countryId);
				int colorLevel = (int) map(lifeExp, 40, 90, 10, 255);
				
				marker.setColor(color(255-colorLevel, 100, colorLevel));
			} else {
				marker.setColor(color(150, 150, 150));
			}
		}
	}

}

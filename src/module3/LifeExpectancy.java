package module3;

import java.util.HashMap;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class LifeExpectancy extends PApplet {
	
	UnfoldingMap map;
	Map<String, Float> lifeExpByCountry;

	@Override
	public void draw() {
		map.draw();
	}

	@Override
	public void setup() {
		size(800, 600, OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
		lifeExpByCountry = loadLifeExpectancyFromCSV("data/LifeExpectancyWorldBank.csv");
		MapUtils.createDefaultEventDispatcher(this, map);
	}
	
	private Map<String, Float> loadLifeExpectancyFromCSV(String fileName){
		Map<String, Float> lifeExpMap = new HashMap<String, Float>();
		
		String[] rows = loadStrings(fileName);
		for(String row : rows) {
			String[] columns = row.split(",");
			if(true) {
				float value = Float.parseFloat(columns[5]);
				lifeExpMap.put(columns[4], value);
			}
		}
		
		return lifeExpMap;
	}

}

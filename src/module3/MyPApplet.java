package module3;

import processing.core.*;

public class MyPApplet extends PApplet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String url = "https://networkencyclopedia.com/wp-content/uploads/2019/09/applet-java.png";
	private PImage backgroundImg;
	@Override
	public void setup() {
		size(200, 200);
		backgroundImg = loadImage(url, "jpg");
	}
	@Override
	public void draw() {
		backgroundImg.resize(0, height);
		image(backgroundImg, 0, 0);
		fill(0, 255, 0);
		ellipse(width/4, height/5, width/5, height/5);
	}
	
	

}

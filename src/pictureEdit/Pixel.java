package pictureEdit;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Image;

public class Pixel {
//instance variables
	private BufferedImage picture;//from the java image class
	
	private int x;//x location(column)
	private int y;//y location(row)

//constructor
	public Pixel(BufferedImage picture, int x; int y){
		this.picture=picture;
		this.x=x;
		this.y=y;
	}
	
}

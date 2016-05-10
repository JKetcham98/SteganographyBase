package pictureEdit;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.awt.*;
import java.io.*;
import java.awt.geom.*;

public class Picture {
	private String fileName;//name of file
	private BufferedImage bufferedImage;//buffered image to hold pixels
	private String extension;//.jpg or file name extension
	public Picture(){
		
	}
	
	
	
	
	
	//methods
	public Graphics2D createGraphics(BufferedImage i){
		return i.createGraphics();
	}
	public static void main(String[] args){
		BufferedImage buff = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
		buff.createGraphics();
	}
}

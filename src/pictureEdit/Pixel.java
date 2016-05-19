package pictureEdit;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.*;
import java.io.*;
import java.awt.geom.*;

public class Pixel {
//instance variables
	private Picture picture;//from the java image class
	
	private int x;//x location(column)
	private int y;//y location(row)

//constructor
	public Pixel(Picture picture, int x, int y){
		this.picture=picture;
		this.x=x;
		this.y=y;
	}
	
//methods
	public int getX(){//gives x position
		return x;
	}
	public int getY(){//gives y postion
		return y;
	}
	public void setX(int a){//sets x position
		this.x=a;
	}
	public void setY(int a){//sets y position
		this.y=a;
	}
	//returns specific values from a 32 bit integer that represents a RGBA color
	public Color getColor() { 
	    int value = picture.getBasicPixel(x,y);
	    int red = (value >> 16) & 0xff;
	    int green = (value >>  8) & 0xff;
	    int blue = value & 0xff;
	    return new Color(red,green,blue);
	}
	public int getAlpha() {//gives alpha
		int value = picture.getBasicPixel(x,y);//gives A value
		return (value >> 24) & 0xff;
	}
	public int getRed(){//gives red 0-255
    	int value = picture.getBasicPixel(x,y);//gives R value
    	return (value >> 16) & 0xff;
	}
	public int getGreen(){//gives green 0-255
    	int value = picture.getBasicPixel(x,y);//gives G value
    	return (value >>  8) & 0xff;
	}
	public int getBlue(){//gives blue 0-255
    	int value = picture.getBasicPixel(x,y);//gives B value
    	return value & 0xff;
	}
	public void setColor(int alpha, int red, int green, int blue){
	    int value = (alpha << 24) + (red << 16) + (green << 8) + blue;
	    picture.setBasicPixel(this.x,this.y,value);//might not work, try without (this.) if it does not work.
	}//the stuff below uses setColor to set colors for specific values
	public void setRed(int value){
		setColor(getAlpha(), value, getGreen(), getBlue());
	}
	public void setGreen(int value){
		setColor(getAlpha(), getRed(), value, getBlue());
	}
	public void setBlue(int value){
		setColor(getAlpha(), getRed(), getGreen(), value);
	}
	public String toString(){
	    return "Y= " + getY() + "\nX= " + getX() +"\nAlpha,Red,Green,Blue= " + getAlpha()+","+ getRed() + "," + getGreen() + "," + getBlue();
	}
}

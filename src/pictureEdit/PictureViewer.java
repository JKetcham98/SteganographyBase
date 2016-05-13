package pictureEdit;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")//remove if broken
public class PictureViewer extends JPanel implements Scrollable{
	private Image image;
	private Dimension prefSize;
	private int currentX = 0; //column   
	private int currentY = 0; // row
	public PictureViewer(Image theImage){// to display image
		image = theImage;
	    prefSize = new Dimension(image.getWidth(this), image.getHeight(this));
	    setPreferredSize(prefSize);
	    revalidate();
	}
	public PictureViewer(Image theImage, int x, int y){// sets coordinates 
	    this(theImage);
	    currentX = x; 
	    currentY = y;
	}
	public Image getImage(){ // gets image
		return image;
	}
	public int getCurrentX(){ //gets current x position  
		return currentX;
	}
	
	public int getCurrentY(){ //gets current y position
		return currentY; 
	}
	public void setCurrentX(int x){// sets x
	  currentX = x;
	  repaint();
	}
	public void setCurrentY(int y){//sets y
		currentY = y;
	    repaint();
	}
	public void setImage(Image theImage){// sets image
	    image = theImage;
	    setPreferredSize(new Dimension(image.getWidth(this),image.getHeight(this)));
	    repaint();
	}
	// these methods implement scrolling
	@Override
	public Dimension getPreferredScrollableViewportSize() {
		return prefSize;
	}
	@Override
	public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
		return 1;
	}
	@Override
	public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
		return 10;
	}
	@Override
	public boolean getScrollableTracksViewportWidth() {
		return false;
	}
	@Override
	public boolean getScrollableTracksViewportHeight() {
		return false;
	}
	public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g);
	    int num = 3;
	    int xStart = currentX - num;
	    int xEnd = currentX + num;
	    int yStart = currentY - num;
	    int yEnd = currentY + num;
	    int width = image.getWidth(this);
	    int maxX = width - 1;
	    int height = image.getHeight(this);
	    int maxY = height - 1;
	    // draw the image
	    g.drawImage(image,0,0,this);
	    // check if the current index is in the image
	    if (currentX >= 0 && currentX < width && currentY >= 0 && currentY < height){
	      // check that the start and end values are visible
	      if (xStart < 0)
	        xStart = 0;
	      if (xEnd > maxX)
	        xEnd = maxX;
	      if (yStart < 0)
	        yStart = 0;
	      if (yEnd > maxY)
	        yEnd = maxY;
	      
	      // draw a small cross at the current x and y in yellow
	      g.setColor(Color.blue);
	      g.drawLine(xStart,currentY,xEnd,currentY);
	      g.drawLine(currentX,yStart,currentX,yEnd);
	      g.setColor(Color.black);
	      
	      // outline the cross in black so that it shows up better
	      int leftX = currentX - 1;
	      int rightX = currentX + 1;
	      int upY = currentY - 1;
	      int downY = currentY + 1; 
	      if (xStart <= leftX && upY >= 0){
	        g.drawLine(xStart,upY,leftX,upY);
	      }
	      if (yStart <= upY && leftX >= 0){
	        g.drawLine(leftX,yStart,leftX,upY);
	      }
	      if (yStart <= upY && rightX <= maxX){
	        g.drawLine(rightX,yStart,rightX,upY);
	      }
	      if (upY >= 0 && rightX <= xEnd){
	        g.drawLine(rightX,upY,xEnd,upY);
	      }
	      if (downY < height && rightX <= xEnd){
	        g.drawLine(rightX,downY,xEnd,downY);
	      }
	      if (downY <= yEnd && rightX < width){
	        g.drawLine(rightX,downY,rightX,yEnd);
	      }
	      if (xStart <= leftX && downY < height){
	        g.drawLine(xStart,downY,leftX,downY);
	      }
	      if (leftX >= 0 && downY <= yEnd){
	        g.drawLine(leftX,downY,leftX,yEnd);
	      }
	    }
	}
}
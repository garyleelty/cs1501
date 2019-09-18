import java.awt.*;
import javax.swing.*;


public class Cloth  extends JPanel {


	public Color BACKGROUND_COLOR  = Color.blue ;
	public Color LINE_COLOR        = Color.black ;
	public Color Garment_COLOR   = Color.yellow ;
	public int height, width, pixels;


	public Cloth( int w, int h,int p) {
		width = w ;
		height = h ;
		pixels = p ;
		setPreferredSize(new Dimension(width*pixels,height*pixels)) ;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g) ;
		g.setColor(BACKGROUND_COLOR) ;
		g.fillRect(0,0,width*pixels,height*pixels) ;
		g.setColor(this.LINE_COLOR);

	}

	public void drawGarment(Garment garment) {
		Graphics g = this.getGraphics() ;
		g.setColor(this.Garment_COLOR);
		g.fillRect(garment.xCoordinate()*pixels+1,garment.yCoordinate()*pixels+1,garment.width()*pixels-1, garment.height()*pixels-1);
		g.setColor(this.LINE_COLOR);
		g.drawString(garment.label(),garment.xCoordinate()*pixels+3,garment.yCoordinate()*pixels+20);
	}

	public void drawCut(Cut c) {
		Graphics g = this.getGraphics();
        g.setColor(this.LINE_COLOR);
		g.drawLine(c.xStart()*pixels, c.yStart()*pixels, c.xEnd()*pixels, c.yEnd()*pixels);
	}


}
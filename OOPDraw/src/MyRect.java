import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

// Class cRect for drawing Rects is derived
// from our 'base class' cShape

class MyRect extends AbstractShape {

	private Point dynStart;
	private Rectangle2D rect;

	public MyRect() {
		rect = new Rectangle2D.Double();
	}

	public void setStart(Point pt) {
		rect.setFrame(pt.x, pt.y,0,0);
		dynStart = pt;
	}

	public void setEnd(Point pt) {
		rect.setFrameFromDiagonal(dynStart, pt);
	}

	// Drawing routine
	public void Draw(Graphics2D g) {
		g.setColor(Color.blue.brighter()); // Set default color
		g.draw(rect);
	}

	public void setDynStart(Point newstart) {
		dynStart = newstart;
	}

}

// Class cRect ends

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

/**
 * Class MyOval for drawing ovals is derived from our 'base class' AbstratShape
 */
class MyOval extends AbstractShape {

	private Point dynStart;
	private Ellipse2D oval;

	public void setStart(Point pt) {
		oval.setFrame(pt.x, pt.y, (oval.getX() - pt.x), (oval.getY() - pt.y));
		dynStart = pt;
	}

	public void setEnd(Point pt) {
		oval.setFrameFromDiagonal(dynStart, pt);
	}

	// Drawing routine
	public void Draw(Graphics2D g) {
		g.setColor(Color.green.darker()); // Set default color
		g.draw(oval);
	}

	public void setDynStart(Point newstart) {
		dynStart = newstart;

	}

}

// Class cOval ends

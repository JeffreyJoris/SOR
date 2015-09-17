import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * base class AbstractShape
 *
 */
public abstract class ShapeComposer

{

	// Data members
	protected Point startPosition; // Start point of shape

	protected Point endPosition; // End point of shape
	
	protected Color colour;


	public abstract ShapeComposer create(Point coordinates);
		
	
	public abstract void complete(Point coordinates);
	
	public abstract void expand(Point coordinates);
	
	public abstract void Draw(Graphics2D g);
		
	
}

// Base class cShape ends

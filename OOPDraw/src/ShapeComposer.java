
import java.awt.Point;

/**
 * base class AbstractShape
 *
 */
public abstract class ShapeComposer

{




	public abstract AbstractShape create(Point coordinates);
		
	
	public abstract void complete(Point coordinates);
	
	public abstract void expand(Point coordinates);
	
	
}

// Base class cShape ends

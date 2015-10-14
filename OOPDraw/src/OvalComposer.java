
import java.awt.Point;


/**
 * 
 */

/**
 * @author jeffr_000
 *
 */
public class OvalComposer extends ShapeComposer {
	private MyOval oval;

	@Override
	public AbstractShape create(Point coordinates) {
		oval = new MyOval();
		oval.setStart(coordinates);
		return oval;
				
	}

	/* (non-Javadoc)
	 * @see AdvancedShapeComposer#complete(java.awt.Point)
	 */
	@Override
	public void complete(Point coordinates) {
		expand(coordinates);

	}

	/* (non-Javadoc)
	 * @see AdvancedShapeComposer#expand(java.awt.Point)
	 */
	@Override
	public void expand(Point coordinates) {
		oval.setEnd(coordinates);
	}

}

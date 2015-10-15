import java.awt.Point;

/**
 * 
 */

/**
 * @author jeffr_000
 *
 */
public class RectComposer extends ShapeComposer {
	private MyRect rect;

	@Override
	public AbstractShape create(Point coordinates) {
		rect = new MyRect();
		rect.setStart(coordinates);
		return rect;
				
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
		rect.setEnd(coordinates);
	}
}
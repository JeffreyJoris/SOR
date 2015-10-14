
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
		Point ptEnd = new Point(Math.max(coordinates.x, rect.getStart().x), Math.max(coordinates.y, rect.getStart().y));
		 Point newstart = new Point(Math.min(coordinates.x, rect.getStart().x), Math.min(coordinates.y,
				 rect.getStart().y));
		rect.setWidth(Math.abs((ptEnd.x - newstart.x)));
		rect.setHeight(Math.abs((ptEnd.y - newstart.y)));
		rect.setDynStart(newstart);
	}
}
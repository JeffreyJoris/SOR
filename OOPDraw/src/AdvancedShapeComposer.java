import java.awt.Graphics2D;
import java.awt.Point;

/**
 * 
 */

/**
 * @author jeffr_000
 *
 */
public class AdvancedShapeComposer extends ShapeComposer {
	protected int height;
	protected int width;

	/* (non-Javadoc)
	 * @see AdvancedShapeComposer#create(java.awt.Point)
	 */
	@Override
	public ShapeComposer create(Point coordinates) {
		startPosition = coordinates;
		endPosition = coordinates;
		return this;
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
		endPosition = new Point(Math.max(coordinates.x, startPosition.x), Math.max(coordinates.y, startPosition.y));
		startPosition = new Point(Math.min(coordinates.x, startPosition.x), Math.min(coordinates.y, startPosition.y));
		width = Math.abs((endPosition.x - startPosition.x));
		height = Math.abs((endPosition.y - startPosition.y));
	}

	@Override
	public void Draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
}

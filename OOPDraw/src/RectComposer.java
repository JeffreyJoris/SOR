import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 
 */

/**
 * @author jeffr_000
 *
 */
public class RectComposer extends AdvancedShapeComposer {
	
	public RectComposer(){
		colour = Color.BLACK;
	}

	@Override
	public void Draw(Graphics2D g) {
		g.setColor(colour);
		g.drawRect(startPosition.x,startPosition. y, width, height);

	}

}
import java.awt.Color;
import java.awt.Graphics2D;


/**
 * 
 */

/**
 * @author jeffr_000
 *
 */
public class OvalComposer extends AdvancedShapeComposer {
	
	public OvalComposer(){
		colour = Color.BLACK;
	}

	@Override
	public void Draw(Graphics2D g) {
		g.setColor(colour);
		g.drawOval(startPosition.x,startPosition. y, width, height);

	}

}

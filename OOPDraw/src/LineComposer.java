import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;


public class LineComposer extends ShapeComposer {
	
	public LineComposer(){
		colour = Color.RED;
	}

	@Override
	public ShapeComposer create(Point coordinates) {
		startPosition = coordinates;
		endPosition = coordinates;
		return this;
	}

	@Override
	public void complete(Point coordinates) {
		expand(coordinates);
		
	}

	@Override
	public void expand(Point coordinates) {
		endPosition = coordinates;
	}
	public void Draw(Graphics2D g){
		g.setColor(colour);
		g.drawLine(startPosition.x,startPosition.y,endPosition.x,endPosition.y);
	}

}


import java.awt.Point;


public class LineComposer extends ShapeComposer {
	private MyLine line;
	

	@Override
	public AbstractShape create(Point coordinates) {
		line = new MyLine();
		line.setStart(coordinates);
		return line;
	}

	@Override
	public void complete(Point coordinates) {
		expand(coordinates);
		
	}

	@Override
	public void expand(Point coordinates) {
		line.setEnd(coordinates);
	}

}

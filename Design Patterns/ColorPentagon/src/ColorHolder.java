import javafx.scene.paint.Color;


public class ColorHolder implements Colorable {
	private Color _color;
	public ColorHolder(Color color){
		_color = color;
	}
	@Override
	public Color getColor() {
		return _color;
	}

	@Override
	public void setColor(Color color) {
		_color = color;
	}

}

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;


public class ColorHandler implements EventHandler<ActionEvent>  {
	private ColorHolder _colorHolder;
	private Color _color;
	public ColorHandler(ColorHolder holder, Color color){
		_colorHolder = holder;
		_color = color;
	}
	@Override
	public void handle(ActionEvent event) {
		_colorHolder.setColor(_color);
	}
}

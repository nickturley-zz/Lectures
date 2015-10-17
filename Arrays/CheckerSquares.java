import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class CheckerSquares {
	private Color _currentColor;
    private Color _otherColor;
    private Rectangle _rect;
   
	public CheckerSquare(Color primaryColor, Color secondaryColor){
		_rect = new Rectangle();
		_rect.setWidth(Constants.SQR_SIZE);
		_rect.setHeight(Constants.SQR_SIZE);
	    _currentColor = primaryColor;
	    _otherColor = secondaryColor;
	    _rect.setFill(_currentColor);
	}
	public void setLocation(int x, int y){
		_rect.setX(x);
		_rect.setY(y);
	}
	public void toggleColor(){
        Color temp = _currentColor;
        _currentColor = _otherColor;
        _otherColor = temp;
        _rect.setFill(_currentColor);
    }
	public Node getNode(){
		return _rect;
	}
}


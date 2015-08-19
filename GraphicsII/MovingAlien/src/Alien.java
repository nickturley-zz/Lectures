import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;


public class Alien {
	private Ellipse _face;
	private Ellipse _leftEye;
	private Ellipse _rightEye;
	
	public Alien(Pane pane){
		_face = new Ellipse(50, 50);
		_face.setFill(Color.GREEN);
		_leftEye = new Ellipse(10, 10);
		_leftEye.setFill(Color.BLACK);
		_rightEye = new Ellipse(10, 10);
		_rightEye.setFill(Color.BLACK);
		pane.getChildren().addAll(_face, _leftEye, _rightEye);
	}
	
	public void setLocation(double x, double y){
		_face.setCenterX(x);
		_face.setCenterY(y);
		_leftEye.setCenterX(x-20);
		_leftEye.setCenterY(y-20);
		_rightEye.setCenterX(x+20);
		_rightEye.setCenterY(y-20);
	}
	
	public double getX(){
		return _face.getCenterX();
	}
	
	public double getY(){
		return _face.getCenterY();
	}
}

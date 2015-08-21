import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;


public class Alien {
	private Ellipse _face;
	private Ellipse _leftEye;
	private Ellipse _rightEye;
	
	public Alien(){
		_face = new Ellipse(50, 50);
		_face.setFill(Color.LIGHTGREEN);
		_leftEye = new Ellipse(10, 15);
		_leftEye.setFill(Color.BLACK);
		_rightEye = new Ellipse(10, 15);
		_rightEye.setFill(Color.BLACK);
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
	
	public List<Node> getNodes(){
		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(_face);
		nodes.add(_leftEye);
		nodes.add(_rightEye);
		return nodes; 
	}
}

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;


public class PaneOrganizer {
	Pane _root;
	Alien _alien;
	public PaneOrganizer(){
		_root = new VBox();
		this.setUpShapePane();
		this.setUpButtons();
	}
	
	private void setUpShapePane(){
		Pane shapePane = new Pane();
		shapePane.setPrefSize(400, 400);
		_root.getChildren().add(shapePane);
		_alien = new Alien(shapePane);
		_alien.setLocation(50, 50);
	}
	
	private void setUpButtons(){
		HBox buttonPane = new HBox();
		Button left = new Button("move left");
		left.setOnAction(new MoveHandler(true));
		Button right = new Button("move right");
		right.setOnAction(new MoveHandler(false));
		buttonPane.getChildren().add(left);
		buttonPane.getChildren().add(right);
		_root.getChildren().add(buttonPane);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setSpacing(20);

	}
	
	public Pane toRoot(){
		return _root;
	}
	
	private class MoveHandler implements EventHandler<ActionEvent>{
		private int _distance;
		public MoveHandler(boolean isLeft){
			_distance = 10;
			if(isLeft){ _distance *= -1;}
		}
		@Override
		public void handle(ActionEvent event) {
			_alien.setLocation(_alien.getX() + _distance, _alien.getY());
		}
		
	}
}

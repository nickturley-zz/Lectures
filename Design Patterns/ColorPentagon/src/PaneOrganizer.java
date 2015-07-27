import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


public class PaneOrganizer {
	VBox _root;
	ColorHolder _holder;
	Polygon _polygon;
	public PaneOrganizer(){
		
		_root = new VBox(20);
		_root.setAlignment(Pos.CENTER);
		_holder = new ColorHolder(Color.WHITE);
		this.setUpPolygon();
		this.setUpButtons();
		this.setUpQuitButton();
		
	}
	private void setUpPolygon(){
		_polygon = new Polygon();
		_polygon.getPoints().addAll(new Double[]{
		    20.0, 0.0,
		    40.0, 15.0,
		    35.0, 40.0, 
		    5.0, 40.0,
		    0.0, 15.0});

		_polygon.setScaleX(1.5);
		_polygon.setScaleY(1.5);
		_polygon.setFill(Color.WHITE);
		_polygon.setOnMousePressed(new MouseHandler());
		_root.getChildren().add(_polygon);
	}
	
	private void setUpButtons(){
		ToggleGroup group = new ToggleGroup();
		HBox buttonBox = new HBox();
		
		RadioButton greenButton = new RadioButton("Green");
		greenButton.setToggleGroup(group);
		greenButton.setOnAction(new ColorHandler(_holder, Color.GREEN));
		RadioButton redButton = new RadioButton("Red");
		redButton.setToggleGroup(group);
		redButton.setOnAction(new ColorHandler(_holder, Color.RED));
		RadioButton blueButton = new RadioButton("Blue");
		blueButton.setToggleGroup(group);
		blueButton.setOnAction(new ColorHandler(_holder, Color.BLUE));
		buttonBox.getChildren().add(redButton);
		buttonBox.getChildren().add(greenButton);
		buttonBox.getChildren().add(blueButton);
		buttonBox.setAlignment(Pos.CENTER);
		_root.getChildren().add(buttonBox);
	}
	
	private void setUpQuitButton(){
		Button quit = new Button("Quit");
		quit.setOnAction(new QuitHandler());
		_root.getChildren().add(quit);
	}
	
	public Pane toNode(){
		return _root;
	}
	
	private class MouseHandler implements EventHandler<MouseEvent>{

		@Override
		public void handle(MouseEvent event) {
			_polygon.setFill(_holder.getColor());
		}
	}
	
	private class QuitHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			System.exit(0);	
		}
		
	}
}

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PaneOrganizer {
	private CheckerSquares[][] _rects;
	private Pane _board;
	private BorderPane _root;
	public PaneOrganizer(){
        CheckerBoard org = new CheckerBoard();
		_rects = org.getSquares();
		_board = new Pane();
		HBox buttonPane = new HBox();
	    Button button = new Button("Change Color!");
	    button.setOnAction(new ClickHandler());
		buttonPane.getChildren().add(button);
		buttonPane.setStyle("-fx-background-color: gray;");
		buttonPane.setAlignment(Pos.CENTER);
		_root = new BorderPane();
		_root.setBottom(buttonPane);
		_root.setTop(_board);
		this.addSquares();
		
	}
	public void addSquares(){
		 for (int col=0; col< Constants.NUM_SQRS; col++){ //outer for loop through columns
	            for (int row=0; row < Constants.NUM_SQRS; row++){
	            	_board.getChildren().addAll(_rects[col][row].toNode());	
	            }
		 }
		
	}
	public Pane getRoot(){
		return _root;
	}
	private class ClickHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			for (int col=0; col<Constants.NUM_SQRS; col++){
				 for (int row=0; row <Constants.NUM_SQRS; row++){
					 //local variable points to selected rect
					 CheckerSquares rect = _rects[col][row];
					 //make sure value of array element isn't null (i.e., array initialized correctly)
		        	 if (rect != null){
		        		rect.toggleColor();
		        	}
				}
		    }

		}
        
}
}

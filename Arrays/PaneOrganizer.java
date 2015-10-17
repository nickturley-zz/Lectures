import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PaneOrganizer {
	private CheckerBoard _board;
	private BorderPane _root;
	private CheckerSquares[][] _rects; 
	public PaneOrganizer(){
		_root = new BorderPane();
        _board = new CheckerBoard();
        _rects = _board.getNodes();//gets array of graphical squares from the board 
	    this.setUpBoardPane();
	    this.setUpButtonPane();
	}

	private void setUpButtonPane(){
		HBox buttonPane = new HBox();
		_root.setBottom(buttonPane);
		Button button = new Button("Change Color!");
	    button.setOnAction(new ClickHandler());
		buttonPane.getChildren().add(button);
		buttonPane.setStyle("-fx-background-color: gray;");
		buttonPane.setAlignment(Pos.CENTER);
	}

	private void setUpBoardPane(){
		Pane boardPane = new Pane();
		_root.setTop(boardPane);		
		for (int col=0; col< Constants.NUM_SQRS; col++){ //outer for loop through columns
	            for (int row=0; row < Constants.NUM_SQRS; row++){
	            	boardPane.getChildren().addAll(_rects[col][row].getNode());	
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

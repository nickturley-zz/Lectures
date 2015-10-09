import com.sun.javafx.geom.Rectangle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class CheckerBoard {
	private CheckerSquares[][] _rects;
	private Pane _root;
	private HBox _buttonPane;
	public CheckerBoard(){
        //int boardSideLength = Constants.NUM_SQRS*Constants.SQR_SIZE;
        _root = new Pane();
        _buttonPane = new HBox();
        Button button = new Button("Change Color!");
		button.setOnAction(new ClickHandler());
		_buttonPane.getChildren().add(button);
		_buttonPane.setStyle("-fx-background-color: gray;");
		_buttonPane.setAlignment(Pos.CENTER);
        _rects = new CheckerSquares[Constants.NUM_SQRS][Constants.NUM_SQRS]; 
        for (int col=0; col< Constants.NUM_SQRS; col++){ //outer for loop through columns
            for (int row=0; row < Constants.NUM_SQRS; row++){ //nested inner for loop through rows
                CheckerSquares rect;
                // every second square should be red
                if (((row + col) % 2) == 0){
                	rect = new CheckerSquares(Color.RED, Color.WHITE);
                }else{  
                	rect = new CheckerSquares(Color.BLACK, Color.BLUE);
                }
                _root.getChildren().addAll(rect.getRect());
                rect.setLocation(col*Constants.SQR_SIZE, row*Constants.SQR_SIZE);
                _rects[col][row] = rect; //add it to array, now that we have positioned it
            } //end of nested for loop
       } //end of first for
        
	}
	public Pane getRoot(){
		return _root;
	}
	public Pane getButtonPane(){
		return _buttonPane;
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

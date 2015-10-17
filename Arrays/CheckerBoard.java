import javafx.scene.paint.Color;

public class CheckerBoard {
	private CheckerSquares[][] _rects;
	public CheckerBoard(){
        _rects = new CheckerSquares[Constants.NUM_SQRS][Constants.NUM_SQRS]; 
        for (int col=0; col< Constants.NUM_SQRS; col++){ //outer for loop through columns
            for (int row=0; row < Constants.NUM_SQRS; row++){ //nested inner for loop through rows
                CheckerSquares rect;
                // every other square should be red
                if (((row + col) % 2) == 0){
                	rect = new CheckerSquares(Color.RED, Color.WHITE);
                }else{  
                	rect = new CheckerSquares(Color.BLACK, Color.BLUE);
                }
                rect.setLocation(col*Constants.SQR_SIZE, row*Constants.SQR_SIZE);
                _rects[col][row] = rect; //add it to array, now that we have positioned it
            } //end of nested for loop
       } //end of first for
        
	}

	public CheckerSquares[][] getRectangles(){
		return _rects;
	}

}

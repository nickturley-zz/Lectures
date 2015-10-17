import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application{
	public static void main(String[] args){
		launch(args);
	}
  
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		PaneOrganizer po = new PaneOrganizer();
		int boardSideLength = Constants.SQR_SIZE*Constants.NUM_SQRS;
		primaryStage.setTitle("CheckerBoard!");
		Scene scene = new Scene(po.getRoot(),boardSideLength , boardSideLength+20);
    	primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}

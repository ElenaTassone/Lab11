package it.polito.tdp.bar;
	
import javafx.application.Application;
import it.polito.tdp.bar.model.Simulator;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Bar.fxml"));
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("Bar.fxml"));
//			Scene scene = new Scene(root);
//			Simulator s = new Simulator () ;
//			BarController controller = loader.getController();
//			controller.setSimulator(s);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Bar.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
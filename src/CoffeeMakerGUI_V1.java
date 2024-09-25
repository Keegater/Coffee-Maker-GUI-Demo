import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CoffeeMakerGUI_V1 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        Parent root = FXMLLoader.load(getClass().getResource("/SceneBuilder Exports/v1.fxml"));

        // Create the scene with the loaded layout
        Scene scene = new Scene(root);
        // Set the title and add the scene to the stage
        primaryStage.setTitle("Coffee Maker GUI Demo");
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
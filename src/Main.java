import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    SceneManager sceneManager;
    Scene home, client;

    @Override
    public void start(Stage stage){
        sceneManager = new SceneManager();
        home = sceneManager.getHomeScene(stage);
        client = sceneManager.getClientScene(stage);

        stage.setScene(home);
        sceneManager.home.clientBox.setOnMouseClicked(e -> stage.setScene(client));
        sceneManager.client.back.setOnMouseClicked(e -> stage.setScene(home));
        stage.setWidth(600);
        stage.setHeight(600);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager{
    HomePage home;
    ClientPage client;
    
    public Scene getHomeScene(Stage stage){
        home = new HomePage();
        return home.homeScene(stage);
    }

    public Scene getClientScene(Stage stage){
        client = new ClientPage();
        try{
            return client.clientScene(stage);
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}

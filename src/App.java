import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.*;


public class App extends Application {
    int width = 480;
    int height = 480;
    String AppName = "Animal Clinic App";
    Font font = Font.font(Font.getFamilies().get(7),FontWeight.BOLD, FontPosture.ITALIC, 24);
    
    public void start(Stage stage) {
        
        
        Label message = new Label("Hello!");
        message.setFont( font );

        HBox buttonBar = new HBox( message);
        buttonBar.setAlignment(Pos.CENTER);
        buttonBar.setPadding(new Insets(20));

        TextField username = new TextField("Username");
        username.setPadding(new Insets(10));
        username.setMaxWidth(width*0.5);

        TextField password = new TextField("Password");
        password.setPadding(new Insets(10));
        password.setMaxWidth(width*0.5);

        Button logIn = new Button("Log In");
        logIn.setPadding(new Insets(10));
        logIn.setOnAction(e -> message.setText("Bye!"));

        VBox account = new VBox(30, username, password, logIn);
        account.setPadding(new Insets(20));
        account.setAlignment(Pos.CENTER);



        Image bg = new Image("https://previews.123rf.com/images/mousemd/mousemd1602/mousemd160200121/53122766-colorful-pet-seamless-pattern-on-a-white-background-vector-illustration.jpg", width, height, true, true);
        ImageView img = new ImageView(bg);
        img.setOpacity(0.5);

        BorderPane root = new BorderPane();
        root.getChildren().add(img);
        
        root.setCenter(account);
        root.setBottom(buttonBar);
        TopLayer(root);
        
        Scene scene = new Scene(root, width, height);
        stage.setScene(scene);
        stage.setTitle("Animal Clinic App");
        stage.show();
        
    } // end start();
    void TopLayer(BorderPane root){
        
        Text AppName = new Text(this.AppName);
        AppName.setFont(font);
        HBox topContainer = new HBox(AppName);
        
        topContainer.setPrefSize(width, height*0.1);
        topContainer.setAlignment(Pos.CENTER);
        
        root.setTop(topContainer);
    }
    public static void main(String[] args) {
        launch(args);  // Run this Application.
    }

} // end class HelloWorldFX
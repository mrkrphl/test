import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.*;


public class HomePage{
    private int padding = 20;
    private int fontSize = 24;
    private Font font = Font.font(Font.getFamilies().get(7),FontWeight.BOLD, fontSize);

    public Rectangle clientBox = new Rectangle(0, 0);

    public Scene homeScene(Stage stage){

        //TOP
        Text menu = new Text("M E N U");
        menu.setFont( font );
        menu.setFill(Color.rgb(71, 82, 94));

        HBox top = new HBox(menu);
        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(padding));

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setMinSize(400, 200);
        grid.setAlignment(Pos.TOP_CENTER);
        

        //BOXES
        Label clients = new Label("Clients");
        clients.setFont(font);
        clientBox.setFill(Color.rgb(253, 245, 218, 0.8));

        Label appointments = new Label("Appointments");
        appointments.setFont(font);
        Rectangle appointmentBox = new Rectangle(0, 0);
        appointmentBox.setFill(Color.rgb(253, 221, 214, 0.8));

        Label payment = new Label("Payment");
        payment.setFont(font);
        Rectangle paymentBox = new Rectangle(0, 0);
        paymentBox.setFill(Color.rgb(185, 179, 179, 0.8));

        Label logout = new Label("Log Out");
        logout.setFont(font);
        Rectangle logoutBox = new Rectangle(0, 0);
        logoutBox.setFill(Color.rgb(208, 223, 224, 0.8));

        StackPane clientGrid = new StackPane(clientBox, clients);
        StackPane appointmentGrid = new StackPane(appointmentBox, appointments);
        StackPane paymentGrid = new StackPane(paymentBox, payment);
        StackPane logoutGrid = new StackPane(logoutBox, logout);

        grid.add(clientGrid, 0, 0);
        grid.add(appointmentGrid, 1, 0);
        grid.add(paymentGrid, 0, 1);
        grid.add(logoutGrid, 1, 1);

        ArrayList<Rectangle> boxList = new ArrayList<Rectangle>();
        boxList.add(clientBox);
        boxList.add(appointmentBox);
        boxList.add(paymentBox);
        boxList.add(logoutBox);

        grid.widthProperty().addListener(e -> {
                for (Rectangle rectangle : boxList) {
                    rectangle.setWidth(grid.getWidth()/2 - padding*2);
                }
        });
        grid.heightProperty().addListener(e -> {
                for (Rectangle rectangle : boxList) {
                    rectangle.setHeight(grid.getHeight()/2 - (padding*2 + fontSize));
                }
        });
        
        
        //BACKGROUND
        Image bg = new Image("https://previews.123rf.com/images/mousemd/mousemd1602/mousemd160200121/53122766-colorful-pet-seamless-pattern-on-a-white-background-vector-illustration.jpg");
        double imageWidth = bg.getWidth();

        ImageView img = new ImageView(bg);
        img.setOpacity(0.2);
    
        stage.widthProperty().addListener(e -> {
            if(stage.getWidth() > imageWidth){
                img.setFitWidth(stage.getWidth());
                img.setFitHeight(stage.getWidth());
            } 
            else{
                img.setFitWidth(0);
                img.setFitHeight(0);
            }   
        });

        BorderPane root = new BorderPane();
        root.getChildren().add(img);
        
        root.setTop(top);
        root.setCenter(grid);
        
        Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
        
        

        return scene;
    }

} // end class HelloWorldFX
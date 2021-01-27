import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.*;


public class ClientPage {
    private int padding = 20;
    private int fontSize = 24;
    private Font font = Font.font(Font.getFamilies().get(7),FontWeight.BOLD, fontSize);

    public Button back = new Button("Back");
    
    public Scene clientScene(Stage stage) throws Exception{

        //TOP
        Text client = new Text("C L I E N T S");
        client.setFont( font );
        client.setFill(Color.rgb(71, 82, 94));
        StackPane textBox = new StackPane(client);
        textBox.autosize();
        HBox middle = new HBox(textBox);
        middle.setAlignment(Pos.CENTER);
        middle.setPadding(new Insets(padding, padding*2, padding, padding*2));
        
        Button addClient = new Button("Add Client");
        addClient.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        
        Popup form = new Popup();
        //Label Name = new Label("Name");
        TextField form_name = new TextField("Name");
        //Label Email = new Label("Name");
        TextField form_email = new TextField("Email Address");
        //Label Contact = new Label("Name");
        TextField form_contact = new TextField("Contact Number");


        Button add = new Button("Add");

        VBox layout = new VBox(20, form_name, form_email, form_contact, add);
        layout.setStyle("-fx-background-color:yellow");
        layout.setFillWidth(true);
        layout.setPadding(new Insets(padding));

        form.setHideOnEscape(true);
        form.centerOnScreen();
        form.getContent().add(layout);

        HBox right = new HBox(addClient);
        right.setAlignment(Pos.CENTER_RIGHT);
        right.setPadding(new Insets(padding, padding*2, padding, padding*2));

        
        HBox left = new HBox(back);
        left.setAlignment(Pos.CENTER_LEFT);
        left.setPadding(new Insets(padding, padding*2, padding, padding*2));

        HBox top = new HBox(20, left, middle, right);
        HBox.setHgrow(left, Priority.ALWAYS);
        HBox.setHgrow(middle, Priority.ALWAYS);
        HBox.setHgrow(right, Priority.ALWAYS);
        
        top.setAlignment(Pos.CENTER);
        
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

        
        TableView<Client> clientTable = new TableView<Client>();
        clientTable.setItems(ClientList.getClientList());
        clientTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Client, Integer> id = new TableColumn<Client, Integer>("ID");
        id.setCellValueFactory(new PropertyValueFactory<Client, Integer>("ID"));

        TableColumn<Client, String> name = new TableColumn<Client, String>("Name");
        name.setCellValueFactory(new PropertyValueFactory<Client, String>("Name"));

        TableColumn<Client, String> contact = new TableColumn<Client, String>("Contact #");
        contact.setCellValueFactory(new PropertyValueFactory<Client, String>("Contact"));

        clientTable.getColumns().add(id);
        clientTable.getColumns().add(name);
        clientTable.getColumns().add(contact);
        
        StackPane centerContainer = new StackPane(clientTable);
        centerContainer.setPadding(new Insets(0, padding*2, padding*2, padding*2));

        


        for(int i = 0; i < 3; i++){
            if(i != 1)
                clientTable.getColumns().get(i).setStyle("-fx-alignment: CENTER");
        }

        addClient.setOnMouseClicked(e ->{
            if(form.isShowing())
                form.hide();
            else{
                form.setHeight(stage.getWidth()/2);
                form.show(stage);
                
            }
        });

        add.setOnMouseClicked(e -> {
            Client c = new Client(form_name.getText(), 0, form_email.getText(), form_contact.getText());
            try{
                Database.addClient(c);
                clientTable.setItems(ClientList.getClientList());
            }
            catch(Exception exception){
                System.out.println(exception);
            }
            
        });

        BorderPane root = new BorderPane();
        root.getChildren().add(img);
        
        root.setTop(top);
        root.setCenter(centerContainer);
        
        
        
        Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
        scene.getStylesheets().add("style.css");
        
        
        
        return scene;
    } 

    /* Popup popUpForm(){
        Popup form = new Popup();
        Label Name = new Label("Name");
        TextField name = new TextField("Name");
        Label Email = new Label("Name");
        TextField email = new TextField("Email Address");
        Label Contact = new Label("Name");
        TextField contact = new TextField("Contact Number");


        Button add = new Button("Add");

        VBox layout = new VBox(20, name, email, contact, add);
        layout.setStyle("-fx-background-color:yellow");
        layout.setFillWidth(true);
        layout.setPadding(new Insets(padding));
        
        

        form.setHideOnEscape(true);
        form.centerOnScreen();
        form.getContent().add(layout);
        return form;
    } */

} // end class HelloWorldFX
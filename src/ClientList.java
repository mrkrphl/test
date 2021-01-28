import java.sql.Connection;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClientList {
    
    public static ObservableList<Client> getClientList() throws Exception{
        ObservableList<Client> clients = FXCollections.observableArrayList();
        try{
            Connection con = Database.getConnection();
            String sql = "SELECT * FROM mork_petclinic.client Order By ID";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                Client client = new Client();
                client.setName(rs.getString("Name"));
                client.setID(rs.getInt("ID"));
                client.setContact(rs.getString("Contact #"));

                clients.add(client);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        return clients;
    }
    

    
}

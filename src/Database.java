import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Database {
    public static void main(String[] args) throws Exception{
        getConnection();
        addClient(new Client("fdsf", 19, "fdf@", "fds"));
    }

    public static void addClient(Client c) throws Exception{
        try{
            Connection con = getConnection();
            String command = "INSERT INTO `petclinic`.`client` (`Name`, `Contact #`) VALUES ('" + c.getName() + "', '" + c.getContact() + "');";
            PreparedStatement add = con.prepareStatement(command);
            add.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://192.168.0.25:3306/petclinic";
            String username = "remote-access";
            String password = "remote";
            Class.forName(driver);
            
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conencted!");
            return conn;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}

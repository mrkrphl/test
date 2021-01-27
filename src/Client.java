

public class Client {
    private String Name;
    private int Age;
    private String Email;
    private String Contact;
    private int ID;

    public Client(){
        this.Name = "";
        this.Age = 0;
        this.Email = "";
        this.Contact = "";
        this.ID = 0;
    }

    public Client(String Name, int Age, String Email, String Contact){
        this.Name = Name;
        this.Age = 0;
        this.Email = Email;
        this.Contact = Contact;
        this.ID = 0;
    }

    public String getName(){
        return Name;
    }

    public int getAge(){
        return Age;
    }

    public String getEmail(){
        return Email;
    }

    public String getContact(){
        return Contact;
    }

    public int getID(){
        return ID;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public void setAge(int Age){
        this.Age = Age;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    public void setContact(String Contact){
        this.Contact = Contact;
    }

    public void setID(int ID){
        this.ID = ID;
    }
    
}


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

@ManagedBean
@SessionScoped
public class UpdatePrice implements Serializable{
    
    String id,Price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }
    
    public void updateP() throws ClassNotFoundException, SQLException{
    
 DBConnection obj = new DBConnection();
 Connection connection = obj.connMethod();
 String query="update VLIST1 set PRICE=? where VID=? ";
     
 PreparedStatement ps;
 ps = connection.prepareStatement(query);
 ps.setString(5, Price);
 ps.setString(1, id);
 int row =ps.executeUpdate();
    }
    
}

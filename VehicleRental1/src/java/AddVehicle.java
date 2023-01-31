
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
public class AddVehicle implements Serializable{
    String vhicleId,vhicleBrand,vhicleName,vhicleType,price,status;

    public String getVhicleId() {
        return vhicleId;
    }

    public void setVhicleId(String vhicleId) {
        this.vhicleId = vhicleId;
    }

    
    
    
    public String getVhicleBrand() {
        return vhicleBrand;
    }

    public void setVhicleBrand(String vhicleBrand) {
        this.vhicleBrand = vhicleBrand;
    }

    
    
    public String getVhicleName() {
        return vhicleName;
    }

    public void setVhicleName(String vhicleName) {
        this.vhicleName = vhicleName;
    }

    public String getVhicleType() {
        return vhicleType;
    }

    public void setVhicleType(String vhicleType) {
        this.vhicleType = vhicleType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    public String inser() throws ClassNotFoundException, SQLException {
        //try{
   DBConnection obj = new DBConnection();
 Connection connection = obj.connMethod();
 String query="insert into vlist1(Vid ,Vbrand ,Vname,Vtype ,price,Vstatus) values (?,?,?,?,?,?)";
 PreparedStatement ps;
 ps = connection.prepareStatement(query);
 ps.setString(1, vhicleId);
 ps.setString(2, vhicleBrand);
 ps.setString(3, vhicleName);
 ps.setString(4, vhicleType);
 ps.setString(5, price);
 ps.setString(6, status);
 
 int r=ps.executeUpdate();
 
 
 /*String query2="insert into available(vid  ,vname ) values (?,?)";
 ps = connection.prepareStatement(query2);

  ps.setString(1, vhicleId);
  ps.setString(2, vhicleName);
  ps.executeUpdate();
*/
 
  if(r!=0){
  return "viewVehicles";
  }
  else {
      return "adminPage";
  }
       // }catch(SQLException e){
        
       // }
    
    }
    
}

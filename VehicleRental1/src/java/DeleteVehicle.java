
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

@ManagedBean
@SessionScoped
public class DeleteVehicle implements Serializable{
     String vhicleId;

    public String getVhicleId() {
        return vhicleId;
    }

    public void setVhicleId(String vhicleId) {
        this.vhicleId = vhicleId;
    }
     
    public String delete() throws ClassNotFoundException, SQLException {
     // try{
 DBConnection obj = new DBConnection();
 Connection connection = obj.connMethod();
 String query="delete from vlist1 where Vid ="+vhicleId;
 
 Statement st=connection.createStatement();
 int r=st.executeUpdate(query);
 
 
 
 if(r!=0){
 return "viewVehicles";
 }
 
 else{
  return "adminPage";
 }
      //}catch(SQLException e){
      
      //}
    
    }
}

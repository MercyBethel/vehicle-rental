
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ReturnVehicle implements Serializable{
    
String name,vehicleId,vehicleName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    

public void returnVehicle()throws ClassNotFoundException, SQLException{

      DBConnection obj = new DBConnection();
  Connection connection = obj.connMethod();
  String query="select * from vlist1 where Vid="+vehicleId;
  
  Statement st = connection.createStatement();
  int row1=st.executeUpdate(query);
 
  String sql="select * from rentv where Vid="+vehicleId;
  int row2 = st.executeUpdate(sql);
  
  if((row1>0) && (row2>0)){
  
  String query1="delete from rentv where Vid ="+vehicleId;
 int r=st.executeUpdate(query1);
 
 
 
 /*
 String query2="insert into available(vid  ,vname ) values (?,?)";
 PreparedStatement ps;
 ps = connection.prepareStatement(query2);

  ps.setString(1, vehicleId);
  ps.setString(2, vehicleName);
  ps.executeUpdate();

*/
  }
 
  
  
    
    
    
}
}

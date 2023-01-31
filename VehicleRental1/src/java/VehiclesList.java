
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

@ManagedBean
@SessionScoped
public class VehiclesList implements Serializable{
    String id,brand,name,type,price,status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    
    ArrayList VhList;
    
    public ArrayList VhList() throws ClassNotFoundException{
    try{
 DBConnection obj = new DBConnection();
 Connection connection = obj.connMethod();

 VhList = new ArrayList();

 String query= "Select * from vlist1";
  Statement st = connection.createStatement();
  ResultSet resultSet;
  resultSet = st.executeQuery(query);

while(resultSet.next()){
VehiclesList ob = new VehiclesList();
ob.setId(resultSet.getString("Vid"));
ob.setBrand(resultSet.getString("Vbrand"));
ob.setName(resultSet.getString("Vname"));
ob.setType(resultSet.getString("Vtype"));
ob.setPrice(resultSet.getString("price"));
ob.setStatus(resultSet.getString( "Vstatus"));
VhList.add(ob);
}  
 
      }catch(SQLException e){
      
      }
    
    
       return VhList;
    
    
    
    }
}

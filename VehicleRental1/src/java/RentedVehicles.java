
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class RentedVehicles implements Serializable{
    String name,phoneNum,id,Vname,startDate,endDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVname() {
        return Vname;
    }

    public void setVname(String Vname) {
        this.Vname = Vname;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
     
    
    public void rentVehicle() throws ClassNotFoundException, SQLException{
     
  DBConnection obj = new DBConnection();
  Connection connection = obj.connMethod();
  String query="select * from vlist1 where Vid="+id;
  
  Statement st = connection.createStatement();
  int row1=st.executeUpdate(query);
 
  String sql="select * from rentv where Vid="+id;
  int row2 = st.executeUpdate(sql);
  
  if((row1>0) && (row2==0)){
      //ResultSet resultSet;
      //resultSet = st.executeQuery(sql );
  
  
      String query1="insert into rentv(CUST_NAME ,PNONE_NUM ,VID,V_NAME ,START_DATE,END_DATA) values (?,?,?,?,?,?)";
 PreparedStatement ps;
 ps = connection.prepareStatement(query1);
 ps.setString(1, name);
 ps.setString(2, phoneNum);
 ps.setString(3, id);
 ps.setString(4, Vname);
 ps.setString(5, startDate);
 ps.setString(6, endDate);
 
 int r=ps.executeUpdate();
 
 
 //String query2="delete from available where  vid ="+id;
 //int r1=st.executeUpdate(query2);
 
 
  
 
  }
 
  
  
    
    }
}

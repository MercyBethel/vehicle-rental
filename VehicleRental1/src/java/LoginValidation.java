
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class LoginValidation implements Serializable {
    String user,pass,userType,pw;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    public String logIn() throws ClassNotFoundException, SQLException{
       
     //  try{
  DBConnection obj = new DBConnection();
  Connection connection = obj.connMethod();
  String query="select * from login";
  
  Statement st = connection.createStatement();
  ResultSet resultSet;
  resultSet = st.executeQuery(query);
  
   while(resultSet.next()){
                  userType=resultSet.getString("username");
                  pw=resultSet.getString("PASSWORD");
            }
   if((user.equals(userType)) && (pass.equals(pw)))   
    return "adminPage";
     
     else
         return "signUP";
  
     
 // }catch(SQLException e){
  
  } 
       
     /*String userType="beti"; 
       if(user.equals(userType))   
    return "adminPage";
     
     else
         return "userPage2";
      */
        
     }

    


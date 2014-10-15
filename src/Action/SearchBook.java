package Action;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.sql.ResultSet; 
import java.util.*;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//import Action.DBconn;  
	
public class SearchBook extends ActionSupport {
	
	   private String bookname;
       
	   public String getBookname() {
	      return bookname;
	   }

	   public void setBookname(String bkname) {
	      this.bookname = bkname;
	   }

	   public String execute() {
	      String ret = "none";
	      Connection conn = null;
       //   System.out.println(bookname);
	      try {
	    	  String URL="jdbc:mysql://r.rdc.sae.sina.com.cn:3307/app_book4";
	    	// 使用从库读数据
	    	  // 通过SaeUserInfo提供的静态方法获取应用的access_key和secret_key
	    	  String Username="omy21z2j04";
	    	  String Password="yw4y0l15kxh0wzzlxx21z01l5i4wlhhmm3ky3h53";
	    	  Class.forName("com.mysql.jdbc.Driver").newInstance();
	    	  conn =DriverManager.getConnection(URL,Username,Password);
	         String sql = "SELECT * FROM booklist WHERE";
	         sql+=" Title = ?";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, bookname);
	         ResultSet rs = ps.executeQuery();


		        if (rs.next()) {
		//            name = rs.getString(1);
		            ret = SUCCESS;
		            HttpServletRequest request = ServletActionContext.getRequest();  
		            request.getSession().setAttribute("bookname",bookname);
		         }
	
		        if (conn != null) {
		            try {
		               conn.close();
		            } catch (SQLException e) {  
	                    e.printStackTrace();  
		            }
		      
		      } }catch (Exception e) {
		         ret = ERROR;
		      }
	        return ret;
	   } 
	      
	

	
	}


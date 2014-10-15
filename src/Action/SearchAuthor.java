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
	
public class SearchAuthor extends ActionSupport {
	
	   private String authorname;
	   private String id;
       
	   public String getAuthorname() {
	      return authorname;
	   }

	   public void setAuthorname(String auname) {
	      this.authorname = auname;
	   }

	   public String getId() {
		      return id;
		   }

		   public void setId(String auname) {
		      this.id = auname;
		   }

	   public String execute() {
	      String ret = "none";
	      int authorID;
	      Connection conn = null;
     //     System.out.println(authorname);
	      try {
	    	  String URL="jdbc:mysql://r.rdc.sae.sina.com.cn:3307/app_book4";
		    	// 使用从库读数据
		    	  // 通过SaeUserInfo提供的静态方法获取应用的access_key和secret_key
	    	  String Username="omy21z2j04";
	    	  String Password="yw4y0l15kxh0wzzlxx21z01l5i4wlhhmm3ky3h53";
		    	  Class.forName("com.mysql.jdbc.Driver").newInstance();
		    	  conn =DriverManager.getConnection(URL,Username,Password);
	         String sql = "SELECT * FROM authorlist WHERE";
	         sql+=" name = ?";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, authorname);
	         ResultSet rs = ps.executeQuery();


		        if (rs.next()) {
		          authorID = rs.getInt(1);
		          id=authorID+"";
		          System.out.println(id);
		            ret = SUCCESS;
		            HttpServletRequest request = ServletActionContext.getRequest();  
		            request.getSession().setAttribute("id",id);
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

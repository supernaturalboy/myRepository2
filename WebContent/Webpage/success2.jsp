<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.*,java.sql.*" %>
<h1 align="center">----------Find These Book-----------</h1>
<center>
<br/>
<br/>
<br/>
<%
String URL="jdbc:mysql://r.rdc.sae.sina.com.cn:3307/app_book4";
  // 使用从库读数据
  // 通过SaeUserInfo提供的静态方法获取应用的access_key和secret_key
	    	  String Username="omy21z2j04";
	    	  String Password="yw4y0l15kxh0wzzlxx21z01l5i4wlhhmm3ky3h53";
 
  
     try {
    	 Class.forName("com.mysql.jdbc.Driver").newInstance();
    	 Connection conn =DriverManager.getConnection(URL,Username,Password);
     String sql= "SELECT * FROM booklist WHERE AuthorID = ?";
     PreparedStatement ps = conn.prepareStatement(sql);
     String Value = (String) request.getAttribute("id");
     if(Value!=null){
         ps.setString(1,Value);
     ResultSet rs = ps.executeQuery();
     out.print("----ISBN------------            ");

     out.print("TITLE--------           ");
  
     out.print("AuthorID-----        ");
     out.print("Publisher-------       ");
     out.print("PublishDate-----     ");
     out.print("Price---           ");
     while(rs.next()){
     out.print("<br/>");
     out.print(rs.getString(1));
     out.print("---|---");
     out.print(rs.getString(2));
     out.print("---|---");
     out.print(rs.getInt(3));
     out.print("---|---");
     out.print(rs.getString(4));
     out.print("---|---");
     out.print(rs.getString(5));
     out.print("---|---");
     out.print(rs.getFloat(6));
     }
     conn.close();
     }
     } catch (SQLException e) {  
         e.printStackTrace();  
     }
   %>
   
   </center>
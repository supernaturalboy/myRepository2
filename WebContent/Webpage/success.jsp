<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.*,java.sql.*" %>
<h1 align="center">----------Find This Book-----------</h1>
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
     String sql= "SELECT * FROM booklist WHERE TITLE = ?";
     PreparedStatement ps = conn.prepareStatement(sql);
     String oValue =(String) request.getAttribute("bookname");
     if(oValue!=null){
     ps.setString(1,oValue);
     ResultSet rs = ps.executeQuery();
     while(rs.next()){
     out.print("ISBN :  ");
     out.print(rs.getString(1));
     out.print("<br/>");
     out.print("TITLE :  ");
     out.print(rs.getString(2));
     out.print("<br/>");
     out.print("AuthorID :  ");
     out.print(rs.getInt(3));
     out.print("<br/>");
     out.print("Publisher :  ");
     out.print(rs.getString(4));
     out.print("<br/>");
     out.print("PublishDate :  ");
     out.print(rs.getString(5));
     out.print("<br/>");
     out.print("Price :  ");
     out.print(rs.getFloat(6));
     out.print("<br/>");
     conn.close();
     }
     }} catch (SQLException e) {  
         e.printStackTrace();  
     }
   %>
   
   </center>
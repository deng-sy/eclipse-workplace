package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prep {

	static Connection con;
	static PreparedStatement sql;
	static ResultSet res;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("数据库驱动加载成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql:"+"//127.0.0.1:3306/db1?useUnicode=true&characterEncoding"
					+ "=utf-8&useSSL=false&serverTimezone=GMT","root","htdhylyzhh");
			System.out.println("数据库连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prep c=new Prep();
		con=c.getConnection();
		try {
			sql=con.prepareStatement("select * from books where id=?");
			sql.setInt(1,4);
			res=sql.executeQuery();
			
			
			while(res.next()) {
				String id=res.getString("id");
				String title=res.getString("title");
				String price=res.getString("price");
				String publishDate=res.getString("publishDate");
				System.out.println("id： "+id);
				System.out.println("title： "+title);
				System.out.println("price： "+price);
				System.out.println("publishDate "+publishDate);
				System.out.println();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

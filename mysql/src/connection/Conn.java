package connection;
import java.sql.*;


public class Conn {
	Connection con;
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("数据库驱动加载成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql:"+"//127.0.0.1:3306/world?useUnicode=true&characterEncoding"
					+ "=utf-8&useSSL=false&serverTimezone=GMT","root","htdhylyzhh");
			System.out.println("数据库连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Statement sql=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conn c=new Conn();
		c.getConnection();


	}

}

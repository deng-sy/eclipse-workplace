package connection;

import java.sql.*;

public class Gradation {
	static Connection con;
	static Statement sql;
	static ResultSet res;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("���ݿ��������سɹ�");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql:"+"//127.0.0.1:3306/db1?useUnicode=true&characterEncoding"
					+ "=utf-8&useSSL=false&serverTimezone=GMT","root","htdhylyzhh");
			System.out.println("���ݿ����ӳɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;

	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gradation c=new Gradation();
		con=c.getConnection();
		
		try {
			sql=con.createStatement();
			res=sql.executeQuery("select * from books where title like 'java%'");
			while(res.next()) {
				String id=res.getString("id");
				String title=res.getString("title");
				String price=res.getString("price");
				String publishDate=res.getString("publishDate");
				System.out.println("id�� "+id);
				System.out.println("title�� "+title);
				System.out.println("price�� "+price);
				System.out.println("publishDate "+publishDate);
				System.out.println();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

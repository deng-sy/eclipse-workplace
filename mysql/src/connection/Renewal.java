/*
���ݿ���ɾ�Ĳ� 
*/
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Renewal {
	static Connection con;
	static PreparedStatement sql;
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
		Renewal c=new Renewal();
		con=c.getConnection();
		try {
			sql=con.prepareStatement("select * from books");
			res=sql.executeQuery();
			System.out.println("��ɾ��ǰ�����ݣ�");
			
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
			
			//��
			sql=con.prepareStatement("insert into books(title,price,publishDate) values(?,?,?)");
			sql.setString(1, "�����źŴ���");
			sql.setString(2,"58.80");
			sql.setString(3, "2019-11-10 00:00:00");
			sql.executeUpdate();
			
			
			//��
			sql=con.prepareStatement("update books set price=? where id="
					+ "2");
			sql.setString(1, "100.00");
			sql.executeUpdate();
			
			//ɾ
			sql.executeUpdate("delete from books where id=3");

			sql.executeUpdate();
			
			//��
			sql=con.prepareStatement("select * from books");
			res=sql.executeQuery();
			System.out.println("��ɾ�ĺ�����ݣ�");
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

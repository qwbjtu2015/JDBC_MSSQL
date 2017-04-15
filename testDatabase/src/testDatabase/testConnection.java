package testDatabase;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//数据库连接测试程序

public class testConnection {
	
	//数据库每次访问时都要创建一个connection对象
	Connection conn;
	public Connection getConnection(){
		try {							//第一步：加载数据库驱动程序
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
//			Class.forName("com.microsoft.sqlsever.jdbc.SQLSeverDriver");
			System.out.println("数据库驱动加载成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {								//通过访问数据库的URL获取数据库连接对象
			conn=DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/BiShe","sa","123456");
//			conn=DriverManager.getConnection("jdbc:microsoft:"+"sqlserver://localhost:1433;DatabaseName=db_database28_1;User=sa; Password=sa");
			System.out.println("数据库连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	

	public static void main(String[] args) {
		testConnection conn=new testConnection();
		conn.getConnection();//调用连接数据库的方法
		try {
			conn.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

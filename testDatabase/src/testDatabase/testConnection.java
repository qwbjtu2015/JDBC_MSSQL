package testDatabase;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//���ݿ����Ӳ��Գ���

public class testConnection {
	
	//���ݿ�ÿ�η���ʱ��Ҫ����һ��connection����
	Connection conn;
	public Connection getConnection(){
		try {							//��һ�����������ݿ���������
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
//			Class.forName("com.microsoft.sqlsever.jdbc.SQLSeverDriver");
			System.out.println("���ݿ��������سɹ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {								//ͨ���������ݿ��URL��ȡ���ݿ����Ӷ���
			conn=DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/BiShe","sa","123456");
//			conn=DriverManager.getConnection("jdbc:microsoft:"+"sqlserver://localhost:1433;DatabaseName=db_database28_1;User=sa; Password=sa");
			System.out.println("���ݿ����ӳɹ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	

	public static void main(String[] args) {
		testConnection conn=new testConnection();
		conn.getConnection();//�����������ݿ�ķ���
		try {
			conn.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

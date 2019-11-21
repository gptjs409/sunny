package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO 
{
	
	//private static final String driver = "oracle.jdbc.driver.OracleDriver";       // ���̻� �� ��
	//private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";		// ���̻� �� ��
	//private static final String user = "sun";										// ���̻� �� ��
	//private static final String pwd = "1234";										// ���̻� �� ��
	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory; 						// import javax.sql.DataSource; �ʿ�

	public MemberDAO() 
	{
		try
		{
			Context ctx = new InitialContext();				// import javax.naming.InitialContext; �ʿ�, JDNI�� �����ϱ� ���� �⺻ ���(java:/comp/env) ����
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle"); // ��Ĺ context.xml�� ������ name���� jdbc/oracle�� �̿��� �̸� ������ DataSource �޾ƿ���
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers()
	{
		List<MemberVO> list = new ArrayList<MemberVO>();
		try
		{
			//connDB();		// ���̻� �� ��
			con = dataFactory.getConnection();				// DataSource�� �̿��� DB ����
			String query = "select * from t_member";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query); // prepareStatement() �޼��忡 SQL���� ������ PrepareStatement ��ü�� ����
			ResultSet rs = pstmt.executeQuery(); // �̸� ������ SQL���� executeQuery()�� ����
			while (rs.next())
			{
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	/* �Ⱦ��Ƿ� �ּ�ó��
	private void connDB()
	{
		try
		{
			Class.forName(driver);
			System.out.println("Oracle ����̹� �ε� ����");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection ���� ����");
		}	catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	*/
}
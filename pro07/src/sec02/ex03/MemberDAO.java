package sec02.ex03;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO 
{
	
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
			System.out.println("preparedStatement: " + query);
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
	
	public void addMember(MemberVO memberVO)
	{
		try
		{
			con = dataFactory.getConnection();     // DataSource�� �̿��� �����ͺ��̽��� ����
			String id = memberVO.getId();					  // ���̺��� ������ ȸ�� ��ȣ�� �޾ƿ�
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			
			String query = "insert into t_member";			  // insert ���� ���ڿ��� ����
			query += " (id,pwd,name,email)";
			query += " values(?,?,?,?)";
			System.out.println("preparedStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);							  // insert���� �� ?�� ������� ȸ�������� ����
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();							  // ȸ�������� ���̺��� �߰�
			pstmt.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void delMember(String id) 
	{
		try
		{
			con = dataFactory.getConnection();
			String query = "delete from t_member" + " where id=?";    // delete ���� ���ڿ��� ����
			System.out.println("preparedStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,  id);								  // �Ű������� id �޶� �ϳ��ϱ� �ٷ� ����� ��!
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
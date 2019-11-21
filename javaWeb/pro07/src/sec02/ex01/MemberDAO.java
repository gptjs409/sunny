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
	
	//private static final String driver = "oracle.jdbc.driver.OracleDriver";       // 더이상 안 씀
	//private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";		// 더이상 안 씀
	//private static final String user = "sun";										// 더이상 안 씀
	//private static final String pwd = "1234";										// 더이상 안 씀
	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory; 						// import javax.sql.DataSource; 필요

	public MemberDAO() 
	{
		try
		{
			Context ctx = new InitialContext();				// import javax.naming.InitialContext; 필요, JDNI에 접근하기 위해 기본 경로(java:/comp/env) 지정
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle"); // 톰캣 context.xml에 설정한 name값인 jdbc/oracle을 이용해 미리 연결한 DataSource 받아오기
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
			//connDB();		// 더이상 안 씀
			con = dataFactory.getConnection();				// DataSource를 이용해 DB 연동
			String query = "select * from t_member";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query); // prepareStatement() 메서드에 SQL문을 전달해 PrepareStatement 객체를 생성
			ResultSet rs = pstmt.executeQuery(); // 미리 설정한 SQL문을 executeQuery()로 실행
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
	
	/* 안쓰므로 주석처리
	private void connDB()
	{
		try
		{
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
		}	catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	*/
}

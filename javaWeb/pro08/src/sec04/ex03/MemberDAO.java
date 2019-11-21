package sec04.ex03;

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
			System.out.println("preparedStatement: " + query);
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
	
	public void addMember(MemberVO memberVO)
	{
		try
		{
			con = dataFactory.getConnection();     // DataSource를 이용해 데이터베이스와 연결
			String id = memberVO.getId();					  // 테이블에 저장할 회원 번호를 받아옴
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			
			String query = "insert into t_member";			  // insert 문을 문자열로 생성
			query += " (id,pwd,name,email)";
			query += " values(?,?,?,?)";
			System.out.println("preparedStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);							  // insert문의 각 ?에 순서대로 회원정보를 대입
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();							  // 회원정보를 테이블에 추가
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
			String query = "delete from t_member" + " where id=?";    // delete 문을 문자열로 생성
			System.out.println("preparedStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,  id);								  // 매개변수가 id 달랑 하나니까 바로 사용이 됨!
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
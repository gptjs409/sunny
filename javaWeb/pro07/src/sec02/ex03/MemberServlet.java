package sec02.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member5")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doHandle(request, response);		
	}
	
	/**
	 * @see HttpServlet#doHandle(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO(); // SQL문으로 조회할 MemberDAO 객체 생성
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command"); // command 값(<hidden> 태그에서 넘겨준 값)을 받아옴
		
		if (command != null && command.equals("addMember")) // 회원 가입창에서 전송된 command가 addMember이면 전송된 값들을 받아옴
		{
			String _id = request.getParameter("id");		// 회원 가입창에서 전송된 값들을 얻어와 MemberVO 객체에 저장 후 SQL문을 이용해 전달
			String _pwd = request.getParameter("pwd");
			String _name = request.getParameter("name");
			String _email = request.getParameter("email");
			MemberVO vo = new MemberVO();
			vo.setId(_id);
			vo.setPwd(_pwd);
			vo.setName(_name);
			vo.setEmail(_email);
			dao.addMember(vo);
		} else if (command != null && command.contentEquals("delMember"))
		{
			String id = request.getParameter("id");
			dao.delMember(id); // 주석 해제
		}
						
		List<MemberVO> list = dao.listMembers();    // listMembers() 메서드로 회원 정보 조회
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");
		
		for (int i = 0; i < list.size(); i++)
		{
			MemberVO memberVO = (MemberVO) list.get(i);   // 조회한 회원 정보를 for과 <tr> 태그를 이용해 리스트로 출력
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			out.print("<tr><td>" + id + "</td><td>"
			+ pwd + "</td><td>" + name + "</td><td>"
			+ email + "</td><td>" + joinDate + "</td><td>"
			+ "<a href='/pro07/member5?command=delMember&id=" + id + "'> 삭제 </a></td><tr>" );
		}
		out.print("</table>");
		out.print("<a href='/pro07/memberForm2.html'>새 회원 가입하기</a></body></html>");
	}

}

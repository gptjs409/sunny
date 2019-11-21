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
		MemberDAO dao = new MemberDAO(); // SQL������ ��ȸ�� MemberDAO ��ü ����
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command"); // command ��(<hidden> �±׿��� �Ѱ��� ��)�� �޾ƿ�
		
		if (command != null && command.equals("addMember")) // ȸ�� ����â���� ���۵� command�� addMember�̸� ���۵� ������ �޾ƿ�
		{
			String _id = request.getParameter("id");		// ȸ�� ����â���� ���۵� ������ ���� MemberVO ��ü�� ���� �� SQL���� �̿��� ����
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
			dao.delMember(id); // �ּ� ����
		}
						
		List<MemberVO> list = dao.listMembers();    // listMembers() �޼���� ȸ�� ���� ��ȸ
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>���̵�</td><td>��й�ȣ</td><td>�̸�</td><td>�̸���</td><td>������</td><td>����</td></tr>");
		
		for (int i = 0; i < list.size(); i++)
		{
			MemberVO memberVO = (MemberVO) list.get(i);   // ��ȸ�� ȸ�� ������ for�� <tr> �±׸� �̿��� ����Ʈ�� ���
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			out.print("<tr><td>" + id + "</td><td>"
			+ pwd + "</td><td>" + name + "</td><td>"
			+ email + "</td><td>" + joinDate + "</td><td>"
			+ "<a href='/pro07/member5?command=delMember&id=" + id + "'> ���� </a></td><tr>" );
		}
		out.print("</table>");
		out.print("<a href='/pro07/memberForm2.html'>�� ȸ�� �����ϱ�</a></body></html>");
	}

}

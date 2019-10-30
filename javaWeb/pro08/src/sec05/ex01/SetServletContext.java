package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetServletContext
 */
@WebServlet("/cset")
public class SetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext(); // ServletContext ��ü�� ������
		List<Object> member = new ArrayList<Object>();
		member.add("�������");
		member.add(40);
		context.setAttribute("member", member);	  // ServletContext ��ü�� �����͸� ���ε�
		out.print("<html><body>");
		out.print("������հ� 40 ����");
		out.print("</body></html>");
	}
}

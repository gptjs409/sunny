package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("init �޼��� ȣ��. pro06.sec02.ex01.LoginServlet2.java");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() 
	{
		System.out.println("init �޼��� ȣ��. pro06.sec02.ex01.LoginServlet2.java");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); // ������ ������ ���� ����
		PrintWriter out = response.getWriter();	            // HttpServletResponse ��ü�� getWriter()�� �̿��� ��� ��Ʈ�� PrintWriter ��ü�� �޾ƿ�
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		String data = "<html>";			// ������ ��� �����͸� ���ڿ��� �����ؼ� HTML �±� ����
			data += "<body>";
			data += "���̵� : " + id;
			data += "<br>";
			data += "�н����� : " + pw;
			data += "</body>";
			data += "</html>";
		out.print(data);				// PrintWriter�� print()�� �̿��� HTML �±� ���ڿ��� �� �������� ���
	}

}
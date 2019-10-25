package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("init �޼��� ȣ��. pro06.sec01.ex01.LoginServlet.java");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("distroy �޼��� ȣ��. pro06.sec01.ex01.LoginServlet.java");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// �� ���������� ������ ������ ��Ĺ �����̳ʰ� HttpServletRequest ��ü�� ���� �� doGet()���� �Ѱ���
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // ���۵� ������ UTF-8�� ���ڵ�
		String user_id = request.getParameter("user_id"); // getParameter()�� �̿��� <input>�±��� name �Ӽ� ������ ���۵� value�� �޾ƿ�
		String user_pw = request.getParameter("user_pw"); // "
		System.out.println("���̵�: " + user_id);
		System.out.println("��й�ȣ: " + user_pw);
	}

}
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
		System.out.println("init 메서드 호출. pro06.sec02.ex01.LoginServlet2.java");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() 
	{
		System.out.println("init 메서드 호출. pro06.sec02.ex01.LoginServlet2.java");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); // 응답할 데이터 종류 설정
		PrintWriter out = response.getWriter();	            // HttpServletResponse 객체의 getWriter()를 이용해 출력 스트림 PrintWriter 객체를 받아옴
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		String data = "<html>";			// 브라우저 출력 데이터를 문자열로 연결해서 HTML 태그 만듦
			data += "<body>";
			data += "아이디 : " + id;
			data += "<br>";
			data += "패스워드 : " + pw;
			data += "</body>";
			data += "</html>";
		out.print(data);				// PrintWriter의 print()를 이용해 HTML 태그 문자열을 웹 브라우저로 출력
	}

}

package sec03.ex01;

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
@WebServlet("/login3")
public class LoginServlet3 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("init 메서드 호출. pro06.sec03.ex01.LoginServlet3.java");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() 
	{
		System.out.println("init 메서드 호출. pro06.sec03.ex01.LoginServlet3.java");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{// Post 방식으로 전송된 데이터 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); // 응답할 데이터 종류 설정
		PrintWriter out = response.getWriter();	            // HttpServletResponse 객체의 getWriter()를 이용해 출력 스트림 PrintWriter 객체를 받아옴
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
	}

}

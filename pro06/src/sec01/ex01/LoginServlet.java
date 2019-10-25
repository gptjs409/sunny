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
		System.out.println("init 메서드 호출. pro06.sec01.ex01.LoginServlet.java");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("distroy 메서드 호출. pro06.sec01.ex01.LoginServlet.java");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// 웹 브라우저에서 전송한 정보를 톰캣 컨테이너가 HttpServletRequest 객체를 생성 후 doGet()으로 넘겨줌
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 전송될 데이터 UTF-8로 인코딩
		String user_id = request.getParameter("user_id"); // getParameter()를 이용해 <input>태그의 name 속성 값으로 전송된 value를 받아옴
		String user_pw = request.getParameter("user_pw"); // "
		System.out.println("아이디: " + user_id);
		System.out.println("비밀번호: " + user_pw);
	}

}

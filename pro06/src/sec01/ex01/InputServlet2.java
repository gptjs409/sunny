package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet2
 */
@WebServlet("/input2")
public class InputServlet2 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("init 메서드 호출. pro06.sec01.ex01.InputServlet2.java");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() 
	{
		System.out.println("distroy 메서드 호출. pro06.sec01.ex01.InputServlet2.java");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Enumeration enu = request.getParameterNames();  // 저장되어 온 name 속성들만 Enumeration 타입으로 받아옴
		while (enu.hasMoreElements())
		{
			String name = (String) enu.nextElement();
			String[] values = request.getParameterValues(name);
			for (String value : values)
			{
				System.out.println("name = " + name + ", value = " + value);
			}
		}
	
	}

}

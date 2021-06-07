package com.kwonees.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello World!</h1>");
		out.println("<hr>");
		out.println("<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Cras cursus, lacus quis convallis suscipit, arcu augue vulputate neque, "
				+ "et consectetur metus sem et nunc. Quisque et lorem ac lacus laoreet laoreet. "
				+ "In feugiat, massa at fringilla egestas, quam erat auctor sapien, "
				+ "sit amet ultricies sapien orci eu nulla. Etiam quis ullamcorper urna, non iaculis nisl. "
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Nam pretium neque quis enim ornare gravida. Sed luctus, libero ut ultricies sodales,"
				+ " odio lacus ultricies ligula, sed imperdiet elit ipsum volutpat risus. "
				+ "Donec nibh erat, venenatis id tincidunt ac, viverra vel lorem. Mauris et augue ac "
				+ "nunc sodales varius et non leo. Proin diam sapien, congue vitae porttitor quis, "
				+ "elementum eu risus. Nam sagittis vestibulum sapien, vel feugiat lacus maximus at. "
				+ " egestas urna eu tortor egestas aliquet.</p>");
		out.close();
	}

}

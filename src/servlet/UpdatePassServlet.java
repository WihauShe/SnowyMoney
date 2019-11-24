package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

public class UpdatePassServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.getRequestDispatcher("error.html").forward(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		UserDao userDao = new UserDao();
		String userPhone = request.getParameter("phone");
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");
		String email = userDao.getEmailByPhone(userPhone);
		
		if(email==""||!email.equals(userEmail)){
			request.getRequestDispatcher("error.html").forward(request, response);
		}else {
			if(userDao.updatePassByPhone(userPhone, userPassword)>0){
				request.getRequestDispatcher("register_success.html").forward(request, response);
			}else {
				request.getRequestDispatcher("error.html").forward(request, response);
			}
			
		}
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}

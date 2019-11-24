package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.JobDao;
import entity.User;

public class DeleteJobServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String id = request.getParameter("id");
		JobDao jobDao = new JobDao();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(jobDao.deleteJobById(Integer.parseInt(id))>0){
			response.sendRedirect("searchJobs?userid="+user.getUserId());;
		}else {
			request.getRequestDispatcher("error.html").forward(request, response);
		}
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
		request.getRequestDispatcher("error.html").forward(request, response);
	}

}

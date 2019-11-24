package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.JobDao;
import entity.Job;
import entity.User;

public class AddJobServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
		 * Constructor of the object.
		 */

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.getRequestDispatcher("error.html").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String jobCategory = request.getParameter("category").trim();
		String jobSex = request.getParameter("sex").trim();
		String jobPlace = request.getParameter("place").trim();
		String jobDemand = request.getParameter("demand").trim();
		String jobSalary = request.getParameter("salary").trim();
		String jobContact = request.getParameter("contact").trim();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null){
			request.getRequestDispatcher("error.html").forward(request, response);
		}else {
			User user = (User)session.getAttribute("user");
			int userId = user.getUserId();
			Job job = new Job(0, jobCategory, jobSex, jobPlace, jobDemand, jobSalary, jobContact, userId);
			JobDao jobDao = new JobDao();
			if(jobDao.addJob(job)>0){
				request.getRequestDispatcher("add_success.html").forward(request, response);
			}else {
				request.getRequestDispatcher("error.html").forward(request, response);
			}
		}
		
		
	}

}

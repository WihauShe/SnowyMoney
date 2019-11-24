package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JobDao;
import entity.Job;

public class SearchJobsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String userid = request.getParameter("userid").trim();
		JobDao jobDao = new JobDao();
		ArrayList<Job> jobList = new ArrayList<Job>();
		jobList = jobDao.getJobsById(Integer.parseInt(userid));
		request.setAttribute("jobs", jobList);
		request.getRequestDispatcher("job_user.jsp").forward(request, response);
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
		String category = request.getParameter("category");
		String sex = request.getParameter("sex");
		String place = request.getParameter("place");
		JobDao jobDao = new JobDao();
		ArrayList<Job> jobList = new ArrayList<Job>();
		jobList = jobDao.getJobsByTerms(category, sex, place);
		request.setAttribute("jobs", jobList);
		request.getRequestDispatcher("job_results.jsp").forward(request, response);
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

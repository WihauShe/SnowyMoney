package action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.JobDao;
import entity.Job;
import entity.User;

public class SearchPjobsAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		JobDao jobDao = new JobDao();
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("user");
		int userid = user.getUserId();
		ArrayList<Job> jobList = new ArrayList<Job>();
		jobList = jobDao.getJobsById(userid);
		ActionContext.getContext().put("jobs", jobList);
		return SUCCESS;
	}
	
}

package action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.JobDao;
import entity.Job;
import entity.User;

public class AddJobAction extends ActionSupport implements ModelDriven<Job>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Job job;
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		JobDao jobDao = new JobDao();
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("user");
		int userId = user.getUserId();
		job.setUserId(userId);
		if(jobDao.addJob(job)>0)
			return SUCCESS;
		else {
			return ERROR;
		}
	}


	@Override
	public Job getModel() {
		// TODO Auto-generated method stub
		if(job==null){
			job = new Job();
		}
		return job;
	}
	
}

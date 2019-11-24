package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.JobDao;
import entity.Job;

public class SearchJobsAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String category;
	private String sex;
	private String place;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		JobDao jobDao = new JobDao();
		ArrayList<Job> jobList = new ArrayList<Job>();
		jobList = jobDao.getJobsByTerms(category, sex, place);
		ActionContext.getContext().put("jobs", jobList);
		return SUCCESS;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	
}

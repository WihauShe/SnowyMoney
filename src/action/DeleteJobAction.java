package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.JobDao;

public class DeleteJobAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int id;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		JobDao jobDao = new JobDao();
		
		if(jobDao.deleteJobById(id)>0){
			return SUCCESS;
		}else {
			return ERROR;
		}
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}

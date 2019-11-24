package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.UserDao;
import entity.User;

public class AddUserAction extends ActionSupport implements ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		if(userDao.addUser(user)>0)
			return SUCCESS;
		else {
			return ERROR;
		}
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		if(user==null){
			user = new User();
		}
		return user;
	}
	
}

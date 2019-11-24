package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class UpdatePassAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userPhone;
	private String userEmail;
	private String userPassword;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		String email = userDao.getEmailByPhone(userPhone);
		if(email==""||!email.equals(userEmail)){
			return ERROR;
		}else {
			if(userDao.updatePassByPhone(userPhone, userPassword)>0){
				return SUCCESS;
			}else {
				return ERROR;
			}
			
		}
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
}

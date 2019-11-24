package action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import dao.WalletDao;
import entity.User;
import entity.Wallet;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userPhone;
	private String userPassword;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		String password = userDao.getPassByPhone(userPhone);
		if(password==""||!password.equals(userPassword)){
			return ERROR;
		}else {
			int userId = userDao.getUserIdByPhone(userPhone);
			HttpSession session = ServletActionContext.getRequest().getSession();
			User user = userDao.getUserById(userId);
			session.setAttribute("user", user);
			WalletDao walletDao = new WalletDao();
			int balance = walletDao.getBalanceById(userId);
			if(balance==-1){
				walletDao.addWallet(new Wallet(userId,0));
			}else{
				session.setAttribute("wallet", new Wallet(userId, balance));
			}
			return SUCCESS;
		}
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}

package entity;

public class User {
	private int userId;
	private String userName;
	private String userPhone;
	private String userSex;
	private int userAge;
	private String userEmail;
	private String userPassword;
	
	public User(){
		
	}
	public User(int userId,String userName,String userPhone,String userSex,int userAge,String userEmail,String userPassword){
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userSex = userSex;
		this.userAge = userAge;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
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

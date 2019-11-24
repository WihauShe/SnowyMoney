package entity;

public class Job {
	private int jobId;
	private String jobCategory;
	private String jobSex;
	private String jobPlace;
	private String jobDemand;
	private String jobSalary;
	private String jobContact;
	private int userId;
	
	public Job(){
		
	}
	public Job(int jobId,String jobCategory, String jobSex, String jobPlace, String jobDemand, String jobSalary,
			String jobContact,int userId) {
		super();
		this.jobId = jobId;
		this.jobCategory = jobCategory;
		this.jobSex = jobSex;
		this.jobPlace = jobPlace;
		this.jobDemand = jobDemand;
		this.jobSalary = jobSalary;
		this.jobContact = jobContact;
		this.userId = userId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobCategory() {
		return jobCategory;
	}
	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}
	public String getJobSex() {
		return jobSex;
	}
	public void setJobSex(String jobSex) {
		this.jobSex = jobSex;
	}
	public String getJobPlace() {
		return jobPlace;
	}
	public void setJobPlace(String jobPlace) {
		this.jobPlace = jobPlace;
	}
	public String getJobDemand() {
		return jobDemand;
	}
	public void setJobDemand(String jobDemand) {
		this.jobDemand = jobDemand;
	}
	public String getJobSalary() {
		return jobSalary;
	}
	public void setJobSalary(String jobSalary) {
		this.jobSalary = jobSalary;
	}
	public String getJobContact() {
		return jobContact;
	}
	public void setJobContact(String jobContact) {
		this.jobContact = jobContact;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}

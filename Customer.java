package booking.model;

public class Customer {
	private int custID;
	private String custName;
	private String custUsername;
	private String custEmail;
	private String custPwd;
	private int custPhonenum;
	private boolean valid;
	
	public Customer() {
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustUsername() {
		return custUsername;
	}

	public void setCustUsername(String custUsername) {
		this.custUsername = custUsername;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustPwd() {
		return custPwd;
	}

	public void setCustPwd(String custPwd) {
		this.custPwd = custPwd;
	}

	public int getCustPhonenum() {
		return custPhonenum;
	}

	public void setCustPhonenum(int custPhonenum) {
		this.custPhonenum = custPhonenum;
	}
	
	
}

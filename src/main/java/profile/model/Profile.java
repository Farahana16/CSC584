package profile.model;

public class Profile {
	private int custid;
	private String custname;
	private String custusername;
	private String custemail;
	private String custpwd;
	private int custphonenum;
	
	public Profile(){
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getCustusername() {
		return custusername;
	}

	public void setCustusername(String custusername) {
		this.custusername = custusername;
	}

	public String getCustemail() {
		return custemail;
	}

	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}

	public String getCustpwd() {
		return custpwd;
	}

	public void setCustpwd(String custpwd) {
		this.custpwd = custpwd;
	}

	public int getCustphonenum() {
		return custphonenum;
	}

	public void setCustphonenum(int custphonenum) {
		this.custphonenum = custphonenum;
	}
	
	
	

}

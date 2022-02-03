package booking.model;

public class Payment {
	
	private int id;
	private String payType;
	private String cardNum;
	private String name;
	private String expDate;;
	private int secCode;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public int getSecCode() {
		return secCode;
	}
	public void setSecCode(int secCode) {
		this.secCode = secCode;
	}
	
	

}

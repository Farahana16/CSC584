package booking.model;

public class Camp {
	private int campID;
	private String campLocation;
	private int campLimitGuest;
	private String campType;
	
	public Camp() {}

	public int getCampID() {
		return campID;
	}

	public void setCampID(int campID) {
		this.campID = campID;
	}

	public String getCampLocation() {
		return campLocation;
	}

	public void setCampLocation(String campLocation) {
		this.campLocation = campLocation;
	}

	public int getCampLimitGuest() {
		return campLimitGuest;
	}

	public void setCampLimitGuest(int campLimitGuest) {
		this.campLimitGuest = campLimitGuest;
	}

	public String getCampType() {
		return campType;
	}

	public void setCampType(String campType) {
		this.campType = campType;
	}
	
	
}

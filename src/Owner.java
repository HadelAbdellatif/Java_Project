import java.util.GregorianCalendar;

public class Owner  {
	// Data Field
	private String Name;
	private String RegisterionNo;
	private String Address;
	private String Tel;
	private GregorianCalendar DateOfRegistration;

	public Owner() { // no-argument constructor

	}

	public Owner(String name, String registerionNo, String address, String tel, GregorianCalendar dateOfRegistration) { // constructor
		Name = name;
		RegisterionNo = registerionNo;
		Address = address;
		Tel = tel;
		this.DateOfRegistration = dateOfRegistration;
	}

	// getters and setters

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRegisterionNo() {
		return RegisterionNo;
	}

	public void setRegisterionNo(String registerionNo) {
		RegisterionNo = registerionNo;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public GregorianCalendar getDateOfRegistration() {
		return DateOfRegistration;
	}

	public void setDateOfRegistration(GregorianCalendar dateOfRegistration) {
		DateOfRegistration = dateOfRegistration;
	}
	
	
	@Override
	public String toString() { // toString method
		return "Owner [Name=" + Name + ", RegisterionNo=" + RegisterionNo + ", Address=" + Address + ", Tel=" + Tel
				+ "]";
	}

}

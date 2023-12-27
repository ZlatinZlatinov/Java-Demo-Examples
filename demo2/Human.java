package kontrolna;

public abstract class Human {

	private String firstName;
	private String lastName; 
	private int workingHours = 0;
	
	protected void setFirstName(String fName) {
		if(fName != null && !fName.isBlank()) {
			this.firstName = fName;
		}  else {
			throw new Error("Can not instantiate, because First Name is empty or null");
		}
	} 
	
	protected void setLastName(String lName) {
		if(lName != null && !lName.isBlank()) {
			this.lastName = lName;
		} else {
			throw new Error("Can not instantiate, because Last Name is empty or null");
		}
	} 
	
	protected void setWorkingHours(int h) {
		if(h >= 0) {
			this.workingHours = h;
		}  else {
			throw new Error("Can not instantiate, because Wokring Hours is less than 0");
		}
	} 
	
	public String getFirstname() {
		return this.firstName;
	} 
	
	public String getLastName() {
		return this.lastName;
	} 
	
	public int getWH() {
		return this.workingHours;
	} 
	
	protected abstract int calculateDailyWage(int dailyWage); 
	
	public int calculateSalary(int daiLywage) {
		return 22 * this.calculateDailyWage(daiLywage);
	} 
	
	@Override 
	public String toString() {
		return "Object Human: { " 
				+ "firstName: " + this.getFirstname() + ", " 
				+ "lastName: " + this.getLastName() + ", " 
				+ "workingHours: " + this.getWH() + " }";
	}
}

package kontrolna;

public class Student extends Human{
	
	private final int workingHours = 4;
	private int facultyNumber;
	
	public Student() {
		super.setFirstName("Random");
		super.setLastName("Student");
		super.setWorkingHours(0);
		this.facultyNumber = 0;
	} 
	
	public Student(String fName, String lName, int fN) {
		super.setFirstName(fName);
		super.setLastName(lName);
		super.setWorkingHours(workingHours);
		this.setFacultyNumber(fN);
	} 
	
	public Student(Student s) {
		super.setFirstName(s.getFirstname());
		super.setLastName(s.getLastName());
		super.setWorkingHours(s.getWH());
		this.setFacultyNumber(s.getFacultyNumber());
	}
	
	private void setFacultyNumber(int fN) {
		if(fN > 0) {
			this.facultyNumber = fN;
		} else {
			throw new Error("Can not instantiate, because Faculty Number is less than or equal to 0");
		}
	} 
	
	public int getFacultyNumber() {
		return this.facultyNumber;
	}
	
	public boolean equals(Student s) {
		return super.equals(s) && this.getFacultyNumber() == s.getFacultyNumber();
	}
	
	@Override
	protected int calculateDailyWage(int daiLywage) {
		return this.workingHours * daiLywage;
	} 
	
	@Override 
	public String toString() {
		return super.toString() + "\nStudent with faculty number: " + this.getFacultyNumber();
	}

}

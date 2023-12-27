package kontrolna;

public class Worker extends Human{

	private final int workingHours = 8;
	private String postion;
	
	public Worker() {
		super.setFirstName("Random");
		super.setLastName("Worker");
		super.setWorkingHours(0);
		this.postion = "Visitor";
	}
	
	public Worker(String fName, String lName, String pos) {
		super.setFirstName(fName);
		super.setLastName(lName);
		super.setWorkingHours(this.workingHours);
		this.setPosition(pos);
	} 
	
	public Worker(Worker w) {
		super.setFirstName(w.getFirstname());
		super.setLastName(w.getLastName());
		super.setWorkingHours(w.getWH());
		this.setPosition(w.getPosition());
	}
	
	protected void setPosition(String pos) {
		if(pos != null) {
			this.postion = pos;
		}
	} 
	
	public String getPosition() {
		return this.postion;
	}
	
	@Override
	protected int calculateDailyWage(int dailyWage) {
		return this.workingHours * dailyWage;
	}  
	
	@Override 
	public String toString() {
		return super.toString() + "\nWorking as " + this.getPosition();
	}
}

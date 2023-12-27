package kontrolna;

public class Main {

	public static void main(String[] args) {
		
		int dailyWage = 2;
		
		Student pesho = new Student("John", "Cena", 123456); 
		System.out.println(pesho.getFirstname() + "'s daily wage: " + pesho.calculateSalary(dailyWage));
		
		Student ivanStudent = new Student("Ivan", "Ivanov", 123321);
		System.out.println(ivanStudent.toString());
		
		Worker ramboWorker = new Worker("John", "Rambo", "Veteran");
		System.out.println(ramboWorker.getLastName() + "'s salary: " + ramboWorker.calculateSalary(300));
		System.out.println(pesho instanceof Human);

	}

}

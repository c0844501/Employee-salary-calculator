package Part2;

public class SalariedEmployee extends Employee {

	private double weeklySalary;
	protected static int numEmployee;
	//Constructor with exception handling
	public SalariedEmployee(String first, String last, String sin, double weeklySalary) throws InvalidSINException {
		super(first, last, sin);
		if (!isValidSalary(weeklySalary)) {
			throw new IllegalArgumentException("Error: weekly salary cannot be a negative value");
		} else {
			this.weeklySalary = weeklySalary;
		}
		numEmployee++;
	}
	//getter and setter
	public double getSalary() {
		return weeklySalary;
	}

	public void setSalary(double weeklySalary) {
		if (!isValidSalary(weeklySalary)) {
			throw new IllegalArgumentException("Error: weekly salary cannot be a negative value");
		} else {
			this.weeklySalary = weeklySalary;
		}
	}

	@Override
	public double earnings() {
		return weeklySalary;
	}

	@Override
	public String toString() {
		return "Type: Salaried\n" + "Name: " + this.getLastName() + ", " + this.getFirstName() + "\n" + "SIN: "
				+ getSin() + "\nWeekly Salary: $" + this.getSalary();
	}

	private boolean isValidSalary(double salary) {
		if (salary < 0) {
			return false;
		}
		return true;
	}

}

package Part2;

public class HourlyEmployee extends Employee {

	private double hours;
	private double hourlyRate;
	protected static int numEmployee;
	//Constructor with exception handling
	public HourlyEmployee(String first, String last, String sin, double hours, double rate) throws InvalidSINException {
		super(first, last, sin);
		if (!isValidRate(rate)) {
			throw new IllegalArgumentException("Error: hourly rate of pay must be minimum wage or higher");
		} else {
			this.hourlyRate = rate;
		}
		if (!isValidHour(hours)) {
			throw new IllegalArgumentException("Error: hours worked cannot be a negative value");
		} else {
			this.hours = hours;
		}
		numEmployee++;
	}
	
	//getter and setter
	public double getHours() {
		return hours;
	}

	public void setHours(double h) {
		if (!isValidHour(h)) {
			throw new IllegalArgumentException("Error: hours worked cannot be a negative value");
		} else {
			this.hours = h;
		}
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		if (!isValidRate(hourlyRate)) {
			throw new IllegalArgumentException("Error: hourly rate of pay must be minimum wage or higher");
		} else {
			this.hourlyRate = hourlyRate;
		}
	}

	@Override
	public double earnings() {
		return hours <= 40 ? hours * hourlyRate : (40 * hourlyRate + (1.5 * (hours - 40) * hourlyRate));
	}

	@Override
	public String toString() {
		return "Type: Hourly\n" + "Name: " + this.getLastName() + ", " + this.getFirstName() + "\n" + "SIN: " + getSin()
				+ "\nHourly Rate: $" + this.getHourlyRate() + "\nHours Worked: " + this.getHours();
	}

	private boolean isValidHour(double hour) {
		if (hour < 0)
			return false;
		else
			return true;
	}

	private boolean isValidRate(double hourlyRate) {
		if (hourlyRate < 14.10)
			return false;
		else
			return true;
	}

}

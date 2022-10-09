package Part2;

public class CommissionEmployee extends Employee {
	//Class variable
	private double commisionRate;
	private double grossSales;
	protected static int numEmployee;
	
	//Constructor with exception handling
	public CommissionEmployee(String first, String last, String sin, double rate, double sales)
			throws InvalidSINException {
		super(first, last, sin);
		rate = rate / 100;
		if (!isValidCommissionRate(rate)) {
			throw new IllegalArgumentException("Error: commission rate should be between 0% and 100%");
		} else {
			this.commisionRate = rate;
		}
		if (!isValidGrossSales(sales)) {
			throw new IllegalArgumentException("Error: gross sales must be a value of 0 or greater");
		} else {
			this.grossSales = sales;
		}
		this.grossSales = sales;
		numEmployee++;
	}

	//Copy constructor with exception handling
	public CommissionEmployee(CommissionEmployee commissionEmployee) throws InvalidSINException {
		super(commissionEmployee.firstName, commissionEmployee.lastName, commissionEmployee.sin);
		this.commisionRate = commissionEmployee.getCommisionRate();
		this.grossSales = commissionEmployee.getGrossSales();
		numEmployee++;
	}
	//getter and setter
	public double getCommisionRate() {
		return commisionRate;
	}

	public void setCommisionRate(double r) {
		r = r / 100;
		if (!isValidCommissionRate(r)) {
			throw new IllegalArgumentException("Error: commission rate should be between 0% and 100%");
		} else {
			this.commisionRate = r;
		}
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double s) {
		if (!isValidGrossSales(s)) {
			throw new IllegalArgumentException("Error: gross sales must be a value of 0 or greater");
		} else {
			this.grossSales = s;
		}
	}

	@Override
	public double earnings() {
		return this.getCommisionRate() * this.getGrossSales();
	}

	@Override
	public String toString() {
		return "Type: Commission\n" + "Name: " + this.getLastName() + ", " + this.getFirstName() + "\n" + "SIN: "
				+ getSin() + "\nGross Sales: $" + this.getGrossSales() + "\nCommission Rate: "
				+ this.getCommisionRate();
	}

	private boolean isValidCommissionRate(double rate) {
		if (rate < 0 || rate > 100)
			return false;
		else
			return true;
	}

	private boolean isValidGrossSales(double grossSales) {
		if (grossSales < 0)
			return false;
		else
			return true;
	}

}

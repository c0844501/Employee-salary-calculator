package Part2;

public abstract class Employee {

	protected String firstName;
	protected String lastName;
	protected String sin;
	protected Employee managedBy;
	protected static int numEmployee;
	
	//Constructor with exception handling
	public Employee(String first, String last, String sin) throws InvalidSINException {
		this.firstName = first;
		this.lastName = last;
		if (isValidSinNumber(sin)) {
			this.sin = sin;
		}
	}

	//getter and setter
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first) {
		if (first == null || first.trim().length() == 0) {
			throw new IllegalArgumentException("Error: Invalid first name provided");
		} else {
			this.firstName = first;
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last) {
		if (last == null || last.trim().length() == 0) {
			throw new IllegalArgumentException("Error: Invalid first name provided");
		} else {
			this.lastName = last;
		}
	}

	public String getSin() {
		return sin;
	}

	public void setSin(String sin) throws InvalidSINException {
		if (isValidSinNumber(sin)) {
			this.sin = sin;
		}
	}

	public Employee getManager() {
		return managedBy;
	}

	public void setManager(Employee mgr) {
		this.managedBy = mgr;
	}

	@Override
	public boolean equals(Object obj) {
		Employee employee = (Employee) obj;
		return employee.sin == this.sin;
	}

	public static int count() {
		return numEmployee;
	}

	public abstract double earnings();

	@Override
	public String toString() {
		return "Name: " + getLastName() + ", " + getFirstName() + "\n" + "SIN: " + getSin();
	}

	private boolean isValidSinNumber(String sinNumber) throws InvalidSINException {
		boolean isValidSin = false;
		int ninthDigit = 0, evenPlaceSum = 0, oddPlaceSum = 0, totalSum = 0, nearestTenth = 0, resultValue = 0;
		String sinNo = sinNumber.replaceAll("\\s", "");

		if (sinNo == null || sinNo.trim().length() == 0 || sinNo.length() != 9 || !sinNo.matches("[0-9]+")) {
			throw new InvalidSINException();
		}

		ninthDigit = Integer.parseInt(String.valueOf(sinNo.charAt(8)));
		for (int i = 0; i < sinNo.length(); i++) {
			if (i % 2 != 0) {
				int sum = 2 * Integer.parseInt(String.valueOf(sinNo.charAt(i)));
				if (sum > 9) {
					sum = (sum / 10) + sum % 10;
				}
				evenPlaceSum += sum;
			}
		}
		for (int i = 0; i < sinNo.length() - 1; i++) {
			if (i % 2 == 0) {
				oddPlaceSum += Integer.parseInt(String.valueOf(sinNo.charAt(i)));
			}
		}
		totalSum = oddPlaceSum + evenPlaceSum;
		nearestTenth = ((totalSum / 10) + 1) * 10;
		resultValue = nearestTenth - totalSum;
		if (resultValue == ninthDigit) {
			isValidSin = true;
		}

		if (!isValidSin) {
			throw new InvalidSINException();
		}
		return isValidSin;
	}
}

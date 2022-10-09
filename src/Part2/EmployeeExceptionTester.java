package Part2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeExceptionTester {

	public static void main(String[] args) throws InvalidSINException {
		//user input
		Scanner in = new Scanner(System.in);
		int choice = 0;
		String firstName = " ", lastName  = " ", sin = " ";
		double weeklySalary, hours, hourlyRate, rate, sales;
		//loop for enter the details of employee
		System.out.println("--------------Name: Sonu Yadav----------------");
		System.out.println("--------------Student ID: C0844501------------");
		do {
			System.out.println("Welcome to Employee Exception Tester!\n");
			System.out.println("Which of the following types of employees would you like to create:");
			System.out.println("1. Salaried \n2. Hourly \n3. Commission\n");
			System.out.println("Please enter your selection: ");
			try
			{
				choice = in.nextInt();
				
				if(!(choice == 1 || choice == 2 || choice == 3))
				{
					throw new InputMismatchException();
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("You have entered incorrect choice. We will now re-prompt you for choice.\n");
			}
			
		} while (!(choice == 1 || choice == 2 || choice == 3));
		
		boolean objcreatedflag = false;
		
		do {
			//Case statement and action based on user input
		switch (choice) {
		case 1: 
			System.out.println("\nPlease enter employee’s first name: ");
			firstName = in.nextLine();
			firstName = in.nextLine();
			System.out.println("Please enter employee’s last name: ");
			lastName = in.nextLine();
			
			System.out.println("Please enter employee’s SIN: ");
			sin = in.nextLine();
			
			System.out.println("Please enter employee’s weekly salary: $");
			weeklySalary = in.nextInt();
			System.out.println("*************************************************");
			try {
				SalariedEmployee salariedEmployee = new SalariedEmployee(firstName, lastName, sin, weeklySalary);
				objcreatedflag = true;
				System.out.println("\nEmployee successfully created!\n");
				System.out.println(salariedEmployee.toString());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				System.out.println("You have entered incorrect information. We will now re-prompt you for all inputs.\n");
				objcreatedflag = false;
			}
			break;

		case 2:
			System.out.println("\nPlease enter employee’s first name: ");
			firstName = in.nextLine();
			firstName = in.nextLine();
			
			System.out.println("Please enter employee’s last name: ");
			lastName = in.nextLine();
			
			System.out.println("Please enter employee’s SIN: ");
			sin = in.nextLine();
			
			System.out.println("Please enter employee’s worked hours: ");
			hours = in.nextInt();
			
			System.out.println("Please enter employee’s hourly rate of pay: ");
			hourlyRate = in.nextInt();
			
			
			System.out.println("*************************************************");
			try {
				HourlyEmployee hourlyEmployee = new HourlyEmployee(firstName, lastName, sin, hours, hourlyRate);
				objcreatedflag = true;
				System.out.println("\nEmployee successfully created!\n");
				System.out.println(hourlyEmployee.toString());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				System.out.println("You have entered incorrect information. We will now re-prompt you for all inputs.\n");
				objcreatedflag = false;
			}
			break;
		
		case 3:
			System.out.println("\nPlease enter employee’s first name: ");
			firstName = in.nextLine();
			firstName = in.nextLine();

			System.out.println("Please enter employee’s last name: ");
			lastName = in.nextLine();
			
			System.out.println("Please enter employee’s SIN: ");
			sin = in.nextLine();
			
			System.out.println("Please enter employee’s commission rate: ");
			rate = in.nextInt();
			
			System.out.println("Please enter employee’s gross sales: ");
			sales = in.nextInt();
			
			
			System.out.println("*************************************************");
			try {
				CommissionEmployee commissionEmployee = new CommissionEmployee(firstName, lastName, sin, rate, sales);
				objcreatedflag = true;
				System.out.println("\nEmployee successfully created!\n");
				System.out.println(commissionEmployee.toString());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				System.out.println("You have entered incorrect information. We will now re-prompt you for all inputs.\n");
				objcreatedflag = false;
			}
			break;
		
		}
		} while(!objcreatedflag);
		
		in.close();
		}

	}

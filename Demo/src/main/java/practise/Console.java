/*Title: Employee Application
 * Author: Nithyashri R
 * Modified date: 31.03.2022
 * Reviewed by: 
 */
package practise;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
public class Console implements ConsoleApp {
	static Console console=new Console();
	static String name;
	static String password;
	static String employeeId,employeeName,dateOfBirth,dateOfJoining;
	long employeeNumber;
	static Scanner input=new Scanner(System.in);
	static Employee employee=new Employee();
	static Configure configure=new Configure();
	//list for storing employee details
	 CopyOnWriteArrayList list=new CopyOnWriteArrayList();
	
	 //Method for add operation
	public void getDetails()
	{
		System.out.println("Enter Employee id:");
		 employeeId=input.next();
		System.out.println("Enter employee's name:");
		 employeeName=input.next();
		System.out.println("Enter employee's Date of birth:");
		 dateOfBirth=input.next();
		System.out.println("Enter employee's mobile number:");
		employeeNumber = input.nextLong();
		System.out.println("Enter Date of Joining:");
		 dateOfJoining=input.next();
		 Employee employee=new Employee(employeeId,employeeName,dateOfBirth,employeeNumber,dateOfJoining);
		list.add(employee);
	}
	//method for print operation
	public void printDetails()
	{
		if(list.size()==0)
		{
			System.out.println("No details added");
		}
		else
		{
			System.out.println("1-->Show all details\n 2-->Show specific individual employee detail");
			System.out.println("Enter your option:");
			int choice=input.nextInt();
			switch(choice)
			{
			case 1:
				Iterator itr=list.iterator();
				
				while(itr.hasNext())
				{
					Employee emp=(Employee) itr.next();
					System.out.println("Employee's id:" +emp.employeeId+ "\n");
					System.out.println("Employee's name:" +emp.employeeName+ "\n");
					System.out.println("Employee's Date of Birth:" +emp.dateOfBirth+ "\n");
					System.out.println("Employee's mobile number:" +emp.employeeNumber+ "\n");
					System.out.println("Employee's Date of Joining:" +emp.dateOfJoining+ "\n");
					System.out.println("Company name:" +employee.company+ "\n");
					System.out.println("....................................");

				}
				break;
			
			case 2:
				System.out.println("Enter Id of the employee which want to display:");
				itr=list.iterator();
				String id=input.next();
				while(itr.hasNext())
				{
					Employee emp=(Employee) itr.next();
					if(emp.employeeId.equals(id))
					{
						System.out.println("Employee's id:" +emp.employeeId+ "\n");
						System.out.println("Employee's name:" +emp.employeeName+ "\n");
						System.out.println("Employee's Date of Birth:" +emp.dateOfBirth+ "\n");
						System.out.println("Employee's mobile number:" +emp.employeeNumber+ "\n");
						System.out.println("Employee's Date of Joining:" +emp.dateOfJoining+ "\n");
						System.out.println("Company name:" +employee.company+ "\n");
						System.out.println("....................................");
					}
				}
				
			}	
			
			 
		}
	}
	//Method for update operation
	public void updateDetails()
	{
		String employeeId;
		System.out.println("Enter the ID of employee whose data want to modify:");
		employeeId=input.next();
		Iterator itr=list.iterator();
		while(itr.hasNext())
		{
			Employee emp=(Employee) itr.next();
			if(emp.employeeId.equals(employeeId))
			{
				System.out.println("Which data wants to modify(Name,DOB,  Number,DOJ)?");
				String option=input.next();
				switch(option)
				{
				case "Name":
					System.out.println("Enter the updated name");
					String name=input.next();
					emp.employeeName=name;
					System.out.println("Employee name updated");
					break;
				case "DOB":
					System.out.println("Enter the updated Date of Birth");
					String dob=input.next();
					emp.dateOfBirth=dob;
					System.out.println("Employee date of birth updated");
					break;
				case "Number":
					System.out.println("Enter the updated Mobile number");
					long number=input.nextLong();
					emp.employeeNumber=number;
					System.out.println("Employee Mobile number updated");
					break;
				}
			}
		}
		
	}
	//Method for delete operation
	public void delete(int choice)
	{
		String employeeId;
		if(choice==1)
		{
			list.removeAll(list);
			System.out.println("...All data deleted successfully...");
		}
		else
		{
			System.out.println("Enter the employee id which want to delete:");
			employeeId=input.next();
			 Iterator itr=list.iterator();
			while(itr.hasNext())
			{
				Employee emp=(Employee) itr.next();
				if(emp.employeeId.equals(employeeId))
				{
					list.remove(emp);
					System.out.println("All data with employee id "+employeeId+ "  are deleted");
				}
			}
			
		}
	}
	//Method for asking user about the delete option
	public void deleteDetails()
	{
		boolean i=true;
		while(i)
		{
			System.out.println("1-->Want to delete all details\n");
			System.out.println("2-->want to delete specific detail");
			System.out.println("Enter your option:");
			int choice=input.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Delete all details");
				i=false;
				delete(choice);
				break;
			case 2:
				System.out.println("Delete specific details");
				i=false;
				delete(choice);
				break;
				default:
					System.out.println("...You entered wrong option...\n Kindly choose correct option");
			}
		}
	}
	//Method for getting count of employee details
	public void noOfEmployees()
	{
		int n;
		System.out.println("enter number of candidate's details want to add:");
		n=input.nextInt();
		while(n>0)
		{
			getDetails();
			
			n--;
		}
		System.out.println("... Details added successfully...");
	}
	//method for getting input for CRUD operation
	public void action()
	{
		
		boolean i=true;
		while(i)
		{
			System.out.println("********************************");
			System.out.println("1--->Add employee details\n");
			System.out.println("2--->view employee details\n");
			System.out.println("3--->Update employee details\n");
			System.out.println("4--->Delete the employee details\n");
			System.out.println("0--->Quit the program\n");
			System.out.println("Please enter the anyone option mentioned above:");
			int act=input.nextInt();
			switch(act)
			{
			case 1:
				System.out.println("Add details:\n");
				console.noOfEmployees();
				break;
			case 2:
				System.out.println("view details:\n");
				printDetails();
				break;
			case 3:
				System.out.println("Update details:");
				updateDetails();
				break;
			case 4:
				System.out.println("Delete details\n");
				deleteDetails();
				break;
			case 0:
				i=false;
				System.out.println("Do you want to store this details in db(yes or no)?");
				String choice=input.next();
				if(choice.equals("yes"))
				{
					configure.addDb(list);
				}
				else
				{
					System.out.println("...Thanks you...");
				}
				
			}
		}
	}
	
	//method for getting user credentials
	public static void userCredentials()
	{
		
	   System.out.println("............Welcome to employee database......");
	   System.out.println("Enter your user name:");
	   name=input.nextLine();
	   System.out.println("Enter correct password:");
	   password=input.nextLine();
	   configure.login(name,password);
	}

	public static void main(String[] args) {
		
		console.userCredentials();

	}

}

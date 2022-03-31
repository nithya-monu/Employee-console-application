package practise;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class Employee extends Console
{
	static String company="Aspire systems";
	 String employeeId,employeeName, dateOfBirth,dateOfJoining;
	long  employeeNumber;
	Employee()
	{
		
	}
	public Employee(String employeeId, String employeeName, String dateOfBirth,long employeeNumber, String dateOfJoining) {
		// TODO Auto-generated constructor stub
		this.employeeId=employeeId;
		this.employeeName=employeeName;
		this.dateOfBirth=dateOfBirth;
		this.employeeNumber=employeeNumber;
		this.dateOfJoining=dateOfJoining;
	}
	
	
	
	
	
}


package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.mysql.cj.xdevapi.Statement;

/*public class configure  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s="Nithya shri";
		System.out.println("Orginal string is" +" "+s);
		System.out.println(s+123+'!');
		String str=s.concat("y");
		System.out.println(str.toUpperCase().charAt(1));
		System.out.println(str.charAt(1));
	}
}

*/

public class Configure extends Console {
	static //Method for checking username and password with db
	String driver="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/practise";
	static String user="root";
	static String pswrd="Aspire@123";
		public static void login(String name, String password) 
		{
			try
			{
			String query="select name,password from login where name=? and password=?";
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,user,pswrd);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println("credentials valid!!!");
				console.action();
			}
			else
			{
				System.out.println("Invalid crdentials");
				System.out.println("Please try again");
			}
			}
			catch(ClassNotFoundException e)
			{
				System.out.println("Driver connection problem");
			}
			catch(SQLException e)
			{
				System.out.println("sql exception occured");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		public void addDb(CopyOnWriteArrayList list)
		{
			java.util.Iterator itr= list.iterator();
			String query2="insert into employee values(?,?,?,?,?)";
			try
			{
				Connection con=DriverManager.getConnection(url,user,pswrd);
				while(itr.hasNext())
				{
					Employee emp=(Employee) itr.next();
					PreparedStatement ps=con.prepareStatement(query2);
					ps.setString(1,emp.employeeId );
					ps.setString(2,emp.employeeName );
					ps.setString(3,emp.dateOfBirth);
					ps.setLong(4,emp.employeeNumber );
					ps.setString(5,emp.dateOfJoining );
					ps.executeUpdate();
				}
				System.out.println("All details are stored in db successfully");
				System.out.println("...Thank you...");
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
}
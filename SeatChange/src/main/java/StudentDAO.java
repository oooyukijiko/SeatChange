
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	private String url;
	private String username;
	private String password;
	
	
	public StudentDAO() {
		this.url = "jdbc:mysql://localhost:3305/student?allowPublicKeyRetrieval=true&useSSL=false";
		this.username = "root";
		this.password = "592311";
	}
	
	public void Set_Name_SQL(int studentNum, String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
		
		try {
			
			Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
			String sql_Sentence = "UPDATE student SET 名前 = '" + name + "' WHERE 出席番号 = " + studentNum + ";";
			System.out.println(sql_Sentence);
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql_Sentence);
			connection.close();
		}catch (SQLException  e) {
			System.out.println(e);
		}
	}
	
	public void Set_Seat_SQL(int studentNum, Integer seatNum) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
			String sql_Sentence;
			if (seatNum == null) {
		           sql_Sentence = "UPDATE student SET 席順 = NULL WHERE 出席番号 = " + studentNum + ";";
		       } else {
		           sql_Sentence = "UPDATE student SET 席順 = " + seatNum + " WHERE 出席番号 = " + studentNum + ";";
		       }
			System.out.println(sql_Sentence);
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql_Sentence);
			connection.close();
		}catch (SQLException  e) {
			System.out.println(e);
		}
	}
	
	public void display() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
			Statement statement = connection.createStatement();
		    ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
		    while (resultSet.next()) {
		      System.out.println(resultSet.getString("出席番号") + " " + resultSet.getString("名前")  + " " + resultSet.getString("席順"));
		      System.out.println();
		    }
		    connection.close();
		}catch (SQLException  e) {
			System.out.println(e);
		}
	}
	
	public int ConfirmationOfExistence(int seatNum) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM student WHERE 席順 = ?");
			preparedStatement.setInt(1, seatNum);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
                return resultSet.getInt(1);  // 結果セットの最初の列から値を取得
            }
			connection.close();
		}catch (SQLException  e) {
			System.out.println(e);
			
		}
		return 0;
	}
	
	public int ConfirmationOfExistence(String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM student WHERE 名前 = ?");
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
                return resultSet.getInt(1);  // 結果セットの最初の列から値を取得
            }
			connection.close();
		}catch (SQLException  e) {
			System.out.println(e);
			
		}
		return 0;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	
	
	public static void main(String[] args) {
		StudentDAO sql = new StudentDAO();
		sql.display();
	}
	
}

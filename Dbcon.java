package shoppingcart1.connection;

/*import cn.techtutorial.connection.ClassNotFoundException;
import cn.techtutorial.connection.Connection;
import cn.techtutorial.connection.SQLException;*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Dbcon {
	private static Connection connection = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if(connection == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercee","root","");
            System.out.print("connected");
        }
        return connection;
    }
}

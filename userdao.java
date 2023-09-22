package shoppingcart1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*import java.SQLException;
import cn.techtutorial.dao.String;
import cn.techtutorial.model.User;*/
import shoppingcart1.model.user;
public class userdao {
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

	public userdao(Connection con) {
		this.con = con;
	}
	
	public user userLogin(String email, String password) {
		user user1 = null;
        try {
            query = "select * from users where email=? and password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()){
            	user1 = new user();
            	user1.setId(rs.getInt("id"));
            	user1.setName(rs.getString("name"));
            	user1.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return user1;
    }

}

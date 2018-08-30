package genesislab.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import genesislab.app.model.User;
import genesislab.app.util.DBUtil;

public class UserDAOImpl implements UserDAO
{
	Connection connection = null;
	
	public UserDAOImpl()
	{
		 connection = DBUtil.getConnection();
		 System.out.println("connection "+connection);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkUser(String username, String password) {
		// TODO Auto-generated method stub
		try
		{
			System.out.println("before execution");
			String sql = "SELECT * FROM users where usrName = ? AND password = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			System.out.println("Came here");
			if(rs.next())
			{
				return true;
			}
			else
				return false;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
}

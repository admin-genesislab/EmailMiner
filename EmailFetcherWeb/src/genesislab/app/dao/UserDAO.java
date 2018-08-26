package genesislab.app.dao;

import genesislab.app.model.User;

public interface UserDAO 
{
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	boolean checkUser(String username, String password);
	
}

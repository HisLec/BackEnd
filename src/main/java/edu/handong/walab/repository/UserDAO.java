package edu.handong.walab.repository;

import java.util.List;

import edu.handong.walab.model.domain.User;

public interface UserDAO {
	
	public void insertUser(User user);
	
	public User insertUserForAdmin(User user);
	
	public User getUserByToken(String token);
	
	public User getUserByEmail(String email);
	
	public User getUserByID(int id);
	
	public void updateUserByToken(User user);
	
	public void deleteUserTokenByEmail(String email);

	public int getLastId();

	public List<User> readAllUser(String keyword);

	public void updateUserStatus(int status, int id);
	
	public void deleteUser(String email);

	public void updateDelDate(String email);

	public void updateDelDateByUserId(int user_id);

}

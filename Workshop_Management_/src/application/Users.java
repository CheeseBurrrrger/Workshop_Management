package application;

import java.util.ArrayList;
import java.util.List;

public class Users {
	private static List<User> Users= new ArrayList<User>();
	User admin= new User("admin", "AdminSuperUser@root.com", "admin");
	User Mekanik1 = new User("Arif", "Arif@mekanik.com", "mekanikArif");
	private static int idUser;
	public Users() {
		setup();
	}
	private void setup() {
		Users.add(admin);
		Users.add(Mekanik1);
		System.out.println("setup success");
	}
	public static int getSize() {
		return Users.size();
	}
	public static List<User> getUsers() {
		return Users;
	}
	public static User getUsers(int i) {
		return Users.get(i);
	}
	public void setUsers(User users) {
		Users.add(users);
	}
}
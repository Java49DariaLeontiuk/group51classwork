package telran.user;

import telran.user.model.User;

public class UserAppl {

	public static void main(String[] args) {
		User user = new User("peter@gmail.com", "3uyCttre\"w");
		System.out.println(user);
		user.setEmale("john@gmail.com");
		user.setPassword("oiuyqrwe");
		System.out.println(user);
		

	}

}

package my.controller.services;

import java.util.Arrays;
import java.util.List;

import my.model.entities.User;

public class ListUsers {
	
	User user = new User();
	
	public List<User> listAll() {
		return Arrays.asList(user);
	}
}

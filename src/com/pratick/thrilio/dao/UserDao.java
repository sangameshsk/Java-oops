package com.pratick.thrilio.dao;

import com.pratick.thrilio.DataStore;
import com.pratick.thrilio.entities.User;

public class UserDao {
	public User[] grtUsers() {
		return DataStore.getUsers();
	}
}

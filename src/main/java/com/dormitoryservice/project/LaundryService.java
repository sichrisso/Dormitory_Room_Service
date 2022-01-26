package com.dormitoryservice.project;

import java.util.List;

import com.dormitoryservice.project.security.User;


public interface LaundryService {
	List<Laundry> getAllLaundrys();
	void saveLaundry(Laundry laundry);
	Laundry getLaundryById(long id);
	void deleteLaundryById(long id);
	boolean saveLaundryRegister (Laundry laundry, User user);
}

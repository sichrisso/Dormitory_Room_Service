package com.dormitoryservice.project;

import java.util.List;

import com.dormitoryservice.project.security.User;

public interface FoodService {
	List<Food> getAllFoods();
	boolean saveFood(Food food, User user);
	boolean saveFood(Food food);
	Food getFoodById(long id);
	void deleteFoodById(long id);
}

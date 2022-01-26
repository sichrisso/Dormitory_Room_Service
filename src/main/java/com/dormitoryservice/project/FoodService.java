package com.dormitoryservice.project;

import java.util.List;

import com.dormitoryservice.project.Security.User;

public interface FoodService {
	List<Food> getAllFoods();
	boolean saveFood(Food food, User user);
	boolean saveFood(Food food);
	Food getFoodById(long id);
	void deleteFoodById(long id);
	// Page<Food> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
    // Page<Food> findPaginated(int pageNo, int pageSize, String sortField, String sortDir);
}

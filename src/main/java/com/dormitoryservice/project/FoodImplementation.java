package com.dormitoryservice.project;


import java.util.List;
import java.util.Optional;

import com.dormitoryservice.project.Security.User;
import com.dormitoryservice.project.Security.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FoodImplementation implements FoodService {

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Food> getAllFoods() {
		return (List<Food>) foodRepository.findAll();
	}

	@Override
	public boolean saveFood(Food food, User user) {
		try {
			userRepo.save(user);
			System.out.println("\n\n\n");
			System.out.println(user);
			System.out.println("\n\n\n");
			foodRepository.save(food);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean saveFood(Food food) {
		try {
			foodRepository.save(food);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Food getFoodById(long id) {
		Optional<Food> optional = foodRepository.findById(id);
		Food food = null;
		if (optional.isPresent()) {
			food = optional.get();
		} else {
			throw new RuntimeException(" Food not found for id :: " + id);
		}
		return food;
	}

	@Override
	public void deleteFoodById(long id) {
		foodRepository.deleteById(id);
		
	}

	/*@Override
	public void deleteFoodById(long id) {
		this.foodRepository.deleteById(id);
	}

	@Override
	public Page<Food> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.foodRepository.findAll(pageable);
	}*/
}

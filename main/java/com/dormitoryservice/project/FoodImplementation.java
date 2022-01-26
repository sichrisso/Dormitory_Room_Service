package com.dormitoryservice.project;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class FoodImplementation implements FoodService {

	@Autowired
	private FoodRepository foodRepository;

	@Override
	public List<Food> getAllFoods() {
		return foodRepository.findAll();
	}

	@Override
	public void saveFood(Food food) {
		this.foodRepository.save(food);
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

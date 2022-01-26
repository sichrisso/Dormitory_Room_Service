package com.dormitoryservice.project;


import com.dormitoryservice.project.Security.User;
// import com.dormitoryservice.project.Security.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FoodController {
	
	@Autowired
	private FoodService foodService;

	@Autowired
	private PasswordEncoder encoder;

	// @Autowired
	// private FoodRepository foodrepo;

	// @Autowired
	// private UserRepository userRepo;
	
	@GetMapping("/food")
	public String viewRegisterPage(Model model) {
        model.addAttribute("listFoods", foodService.getAllFoods());
        return "food";	
	}
    

	@GetMapping("/foodregister")
    public String foodRegistration() {
        return "FoodRegistration";
    }


	@PostMapping("/foods")
	public String foodsRegistration(@ModelAttribute("food") Food food) {
		User user = new User();
		user.setUsername(food.getUserName());
		user.setPassword(encoder.encode(food.getFoodPassword()));
		user.setPhone(String.valueOf(food.getContact()));
		user.setFullName(food.getFoodPlace());
		user.setUserRole("FOOD");

		
		if(foodService.saveFood(food, user)){
			return "redirect:/login";
		}else{
		return "redirect:/food?field";}
	}

	@GetMapping("/insertMenu/{id}")
	public String insertMenu(@PathVariable ( value = "id") long id, Model model) {
		
		
		Food food = foodService.getFoodById(id);
		
		
		model.addAttribute("food", food);
		return "InsertMenu";
	}
	@GetMapping("/showNewFoodForm")
	public String showNewFoodForm(Model model) {
		
		Food food = new Food();
		model.addAttribute("food", food);
		return "new_food";
	}
	
	@PostMapping("/saveFood")
	public String saveFood(@ModelAttribute("food") Food food) {
		
		foodService.saveFood(food);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		Food food = foodService.getFoodById(id);
		
		model.addAttribute("food", food);
		return "update_food";
	}
	
	@GetMapping("/deleteFood/{id}")
	public String deleteFood(@PathVariable (value = "id") long id) {
		
		this.foodService.deleteFoodById(id);
		return "redirect:/";
	}
	
}




package com.dormitoryservice.project;

import java.util.List;

import com.dormitoryservice.project.Security.User;
import com.dormitoryservice.project.Security.UserRepository;

//import org.mindrot.jbcrypt.BCrypt;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import lombok.RequiredArgsConstructor;


@Controller
public class FoodController {
	
	@Autowired
	private FoodService foodService;

	@Autowired
	private PasswordEncoder encoder;
	// private final PasswordEncoder passwordEncoder;

	@Autowired
	private FoodRepository foodrepo;

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/food")
	public String viewRegisterPage(Model model) {
        model.addAttribute("listFoods", foodService.getAllFoods());
        return "food";
		/*return findPaginated(1, "foodPlace", "asc", model);*/		
	}
    

	@GetMapping("/foodregister")
    public String foodRegistration() {
        return "FoodRegistration";
    }

	// @PostMapping
    // public String processRegistration(FoodRegistrationForm form) {
    //     foodRepository.save(form.toUser(passwordEncoder));
    //     return "redirect:/login";
    // }

	@PostMapping("/foods")
	public String foodsRegistration(@ModelAttribute("food") Food food) {
		User user = new User();
		user.setUsername(food.getUserName());
		user.setPassword(encoder.encode(food.getFoodPassword()));
		user.setPhone(String.valueOf(food.getContact()));
		user.setFullName(food.getFoodPlace());

		// save Food to database
		if(foodService.saveFood(food, user)){
			return "redirect:/login";
		}else{
		return "redirect:/loginfaild";}
	}

	@GetMapping("/insertMenu/{id}")
	public String insertMenu(@PathVariable ( value = "id") long id, Model model) {
		
		// get Laundry from the service
		Food food = foodService.getFoodById(id);
		
		// set Laundry as a model attribute to pre-populate the form
		model.addAttribute("food", food);
		return "InsertMenu";
	}
	@GetMapping("/showNewFoodForm")
	public String showNewFoodForm(Model model) {
		// create model attribute to bind form data
		Food food = new Food();
		model.addAttribute("food", food);
		return "new_food";
	}
	
	@PostMapping("/saveFood")
	public String saveFood(@ModelAttribute("food") Food food) {
		// save Food to database
		foodService.saveFood(food);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get Food from the service
		Food food = foodService.getFoodById(id);
		
		// set Food as a model attribute to pre-populate the form
		model.addAttribute("food", food);
		return "update_food";
	}
	
	@GetMapping("/deleteFood/{id}")
	public String deleteFood(@PathVariable (value = "id") long id) {
		
		// call delete Food method 
		this.foodService.deleteFoodById(id);
		return "redirect:/";
	}
	
	
	// @GetMapping("/page/{pageNo}")
	// public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
	// 		@RequestParam("sortField") String sortField,
	// 		@RequestParam("sortDir") String sortDir,
	// 		Model model) {
	// 	int pageSize = 5;
		
	// 	Page<Food> page = foodService.findPaginated(pageNo, pageSize, sortField, sortDir);
	// 	List<Food> listFoods = page.getContent();
		
	// 	model.addAttribute("currentPage", pageNo);
	// 	model.addAttribute("totalPages", page.getTotalPages());
	// 	model.addAttribute("totalItems", page.getTotalElements());
		
	// 	model.addAttribute("sortField", sortField);
	// 	model.addAttribute("sortDir", sortDir);
	// 	model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
	// 	model.addAttribute("listFoods", listFoods);
	// 	return "food";
	// }
}




package com.dormitoryservice.project;

import com.dormitoryservice.project.security.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LaundryController {

	@Autowired
	private LaundryService laundryService;

	@Autowired
	private PasswordEncoder encoder;

	// @Autowired
	// private UserRepository userRepo;

	@GetMapping("/laundry")
	public String viewRegisterPage(Model model) {
        model.addAttribute("listLaundrys", laundryService.getAllLaundrys());
        return "laundry";	
	}
    
	@PostMapping("/saveLaundry")
	public String saveLaundry(@ModelAttribute("laundry") Laundry laundry) {
		laundryService.saveLaundry(laundry);
		return "redirect:/laundry";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable ( value = "id") long id, Model model) {
		
		Laundry laundry = laundryService.getLaundryById(id);
		
		model.addAttribute("laundry", laundry);
		return "edit_laundry";
	}
	
	@GetMapping("/deleteLaundry/{id}")
	public String deleteLaundry(@PathVariable (value = "id") long id) {
		
		this.laundryService.deleteLaundryById(id);
		return "redirect:/laundry";
	}

	@GetMapping("/laundryregister")
    public String laundryRegistration() {
        return "LaundryRegistration";
    }

	@RequestMapping("/laundryregister")

	@PostMapping("/laundry")
	public String saveLaundryRegister(@ModelAttribute("laundry") Laundry laundry) {
		User user = new User();
		user.setUsername(laundry.getLuserName());
		user.setPassword(encoder.encode(laundry.getLaundryPassword()));
		user.setPhone(String.valueOf(laundry.getLauContact()));
		user.setFullName(laundry.getFirstName());
		user.setUserRole("LAUNDRY");
		
	
		if(laundryService.saveLaundryRegister(laundry, user)){
			return "redirect:/login";
		}else{
		return "redirect:/loginfaild";}
		
	}
}

package com.dormitoryservice.project;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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

	@GetMapping("/laundry")
	public String viewRegisterPage(Model model) {
        model.addAttribute("listLaundrys", laundryService.getAllLaundrys());
        return "laundry";
		/*return findPaginated(1, "LaundryPlace", "asc", model);*/		
	}
    
	@PostMapping("/saveLaundry")
	public String saveLaundry(@ModelAttribute("laundry") Laundry laundry) {
		// save Laundry to database
		laundryService.saveLaundry(laundry);
		return "redirect:/laundry";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable ( value = "id") long id, Model model) {
		
		// get Laundry from the service
		Laundry laundry = laundryService.getLaundryById(id);
		
		// set Laundry as a model attribute to pre-populate the form
		model.addAttribute("laundry", laundry);
		return "edit_laundry";
	}
	
	@GetMapping("/deleteLaundry/{id}")
	public String deleteLaundry(@PathVariable (value = "id") long id) {
		
		// call delete Laundry method 
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
		// save Food to database
		laundryService.saveLaundry(laundry);
		return "redirect:/login";
	}
	
	
	/*@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Laundry> page = laundryService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Laundry> listLaundrys = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listLaundrys", listLaundrys);
		return "food";
	}*/
}

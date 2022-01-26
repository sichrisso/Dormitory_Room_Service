package com.dormitoryservice.project;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;

	@GetMapping("/menu/{id}")
	public String viewRegisterPage(@PathVariable ( value = "id") long id,Model model) {
        model.addAttribute("listMenus", menuService.getAllMenus(id));
        model.addAttribute("id", id);
        return "menu";
		/*return findPaginated(1, "MenuPlace", "asc", model);*/		
	}
    
	@GetMapping("/addmenu/{id}")
	public String showNewMenuForm(@PathVariable ( value = "id") long id, Model model) {
		// create model attribute to bind form data
		Menu menu = new Menu();
		menu.setFoodId(id);
		model.addAttribute("menu", menu);
		return "InsertMenu";
	}
	
	@PostMapping("/saveMenu")
	public String saveMenu(@ModelAttribute("menu") Menu menu) {
		// save Menu to database
		long id =menu.getFoodId();
		menuService.saveMenu(menu);
		return "redirect:/menu/" + id;
	}

	@PostMapping("/saveInsertMenu")
	public String saveInsertMenu(@ModelAttribute("menu") Menu menu) {
		// save Menu to database
		long id =menu.getFoodId();
		menuService.saveInsertMenu(menu);
		return "redirect:/addmenu/" + id;
	}

	
	@GetMapping("/update/{id}")
	public String update(@PathVariable ( value = "id") long id, Model model) {
		
		// get Menu from the service
		Menu menu = menuService.getMenuById(id);
		
		// set Menu as a model attribute to pre-populate the form
		model.addAttribute("menu", menu);
		return "update_menu";
	}

	@GetMapping("/insertMenu")
    public String insertMenu() {
        return "InsertMenu";
    }

	//@RequestMapping("/insertMenu")
	

	@GetMapping("/deleteMenu/{id}")
	public String deleteMenu(@PathVariable (value = "id") long id) {
		
		// call delete Menu method 
		this.menuService.deleteMenuById(id);
		return "redirect:/menu";
	}
	

	// @PostMapping("/menu")
	// public String saveInsertMenu(@ModelAttribute("menu") Menu menu) {
	// 	// save Food to database
	// 	menuService.saveInsertMenu(menu);
	// 	return "redirect:/menu";
	// }

	// @GetMapping("/insertMenu/{id}")
	// public String insertMenu(@PathVariable ( value = "id") long id, Model model) {
		
	// 	// get Laundry from the service
	// 	Menu menu = menuService.getMenuById(id);
		
	// 	// set Laundry as a model attribute to pre-populate the form
	// 	model.addAttribute("menu", menu);
	// 	return "InsertMenu";
	// }
	
	
	
	/*@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Menu> page = menuService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Menu> listMenus = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listMenus", listMenus);
		return "food";
	}*/
}

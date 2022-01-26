package com.dormitoryservice.project;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;

	@GetMapping("/menu/{id}")
	public String viewRegisterPage(@PathVariable ( value = "id") long id,Model model) {
        model.addAttribute("listMenus", menuService.getAllMenus(id));
        model.addAttribute("id", id);
        return "menu";	
	}
    
	@GetMapping("/addmenu/{id}")
	public String showNewMenuForm(@PathVariable ( value = "id") long id, Model model) {
		Menu menu = new Menu();
		menu.setFoodId(id);
		model.addAttribute("menu", menu);
		return "InsertMenu";
	}
	
	@PostMapping("/saveMenu")
	public String saveMenu(@ModelAttribute("menu") Menu menu) {
		long id =menu.getFoodId();
		menuService.saveMenu(menu);
		return "redirect:/menu/" + id;
	}

	@PostMapping("/saveInsertMenu")
	public String saveInsertMenu(@ModelAttribute("menu") Menu menu) {
		long id =menu.getFoodId();
		menuService.saveInsertMenu(menu);
		return "redirect:/addmenu/" + id;
	}

	
	@GetMapping("/update/{id}")
	public String update(@PathVariable ( value = "id") long id, Model model) {

		Menu menu = menuService.getMenuById(id);
		model.addAttribute("menu", menu);
		return "update_menu";
	}

	@GetMapping("/insertMenu")
    public String insertMenu() {
        return "InsertMenu";
    }	

	@GetMapping("/deleteMenu/{id}")
	public String deleteMenu(@PathVariable (value = "id") long id) {
	
		this.menuService.deleteMenuById(id);
		return "redirect:/food";
	}
}

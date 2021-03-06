package com.dormitoryservice.project;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class MenuImplementation implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Override
	public List<Menu> getAllMenus(long id) {
		 menuRepository.findAll();
		 return menuRepository.findByFoodId(id);
	}

	@Override
	public void saveMenu(Menu menu) {
		this.menuRepository.save(menu);
	}
	
	@Override
	public void saveInsertMenu(Menu menu) {
		this.menuRepository.save(menu);
	}

	@Override
	public Menu getMenuById(long id) {
		Optional<Menu> optional = menuRepository.findById(id);
		Menu menu = null;
		if (optional.isPresent()) {
			menu = optional.get();
		} else {
			throw new RuntimeException(" Menu not found for id :: " + id);
		}
		return menu;
	}

	@Override
	public void deleteMenuById(long id) {
		this.menuRepository.deleteById(id);
	}
}

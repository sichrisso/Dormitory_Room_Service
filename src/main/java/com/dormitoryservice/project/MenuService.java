package com.dormitoryservice.project;

import java.util.List;


public interface MenuService {
	List<Menu> getAllMenus(long id);
	void saveMenu(Menu menu);
	Menu getMenuById(long id);
	void deleteMenuById(long id);
	void saveInsertMenu(Menu menu);
	/*Page<Menu> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);*/
}

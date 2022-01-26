package com.dormitoryservice.project;

import java.util.List;


public interface LaundryService {
	List<Laundry> getAllLaundrys();
	void saveLaundry(Laundry laundry);
	Laundry getLaundryById(long id);
	void deleteLaundryById(long id);
	void saveLaundryRegister (Laundry laundry);
	/*Page<Laundry> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);*/
}

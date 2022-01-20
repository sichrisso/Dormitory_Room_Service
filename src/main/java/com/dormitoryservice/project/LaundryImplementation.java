package com.dormitoryservice.project;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class LaundryImplementation implements LaundryService {

	@Autowired
	private LaundryRepository laundryRepository;

	@Override
	public List<Laundry> getAllLaundrys() {
		return laundryRepository.findAll();
	}

	@Override
	public void saveLaundry(Laundry laundry) {
		this.laundryRepository.save(laundry);
	}

	@Override
	public void saveLaundryRegister(Laundry laundry) {
		this.laundryRepository.save(laundry);
	}


	@Override
	public Laundry getLaundryById(long id) {
		Optional<Laundry> optional = laundryRepository.findById(id);
		Laundry laundry = null;
		if (optional.isPresent()) {
			laundry = optional.get();
		} else {
			throw new RuntimeException(" Laundry not found for id :: " + id);
		}
		return laundry;
	}

	@Override
	public void deleteLaundryById(long id) {
		this.laundryRepository.deleteById(id);
	}

	/*@Override
	public Page<Laundry> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.laundryRepository.findAll(pageable);
	}*/
}

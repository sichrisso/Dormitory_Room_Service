package com.dormitoryservice.project;


import java.util.List;
import java.util.Optional;

import com.dormitoryservice.project.security.User;
import com.dormitoryservice.project.security.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaundryImplementation implements LaundryService {

	@Autowired
	private LaundryRepository laundryRepository;

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Laundry> getAllLaundrys() {
		return laundryRepository.findAll();
	}

	@Override
	public void saveLaundry(Laundry laundry) {
		this.laundryRepository.save(laundry);
	}

	@Override
	public boolean saveLaundryRegister(Laundry laundry, User user) {
		try {
			userRepo.save(user);
			System.out.println("\n\n\n");
			System.out.println(user);
			System.out.println("\n\n\n");
			laundryRepository.save(laundry);
			return true;
		} catch (Exception e) {
			return false;
		}
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
}

package com.example.lab5n6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lab5n6.entity.Cust_details;
import com.example.lab5n6.repository.Cust_detailsRepository;

@Service
public class Cust_detailsService {
	@Autowired
	Cust_detailsRepository cust_detailsRepository;
	
	public List<Cust_details> getAllCust_details() {
		return cust_detailsRepository.findAll();
	}
	
	public Optional<Cust_details> getCust_DetailsById(Long cst_id) {
		return cust_detailsRepository.findById(cst_id);
	}
	
	public Cust_details createCust_details(Cust_details cust_details) {
		return cust_detailsRepository.save(cust_details);
	}
	
	public Cust_details updateCust_details(Long cst_id, Cust_details cust_details) {
		return cust_detailsRepository.findById(cst_id)
				.map(updatedCust_details -> {
					updatedCust_details.setCsdet_contact(cust_details.getCsdet_contact());
					updatedCust_details.setCsdet_email(cust_details.getCsdet_email());
					updatedCust_details.setCsdet_mobile(cust_details.getCsdet_mobile());
					updatedCust_details.setCsdet_status(cust_details.getCsdet_status());
					updatedCust_details.setCsdet_type(cust_details.getCsdet_type());
					updatedCust_details.setCstdet_dob(cust_details.getCstdet_dob());
					return cust_detailsRepository.save(updatedCust_details);
				})
				.orElseThrow(()-> new RuntimeException("Can't find cust_details with id" + cst_id));
	}
	
	public void deleteCust_details(Long cst_id) {
		cust_detailsRepository.findById(cst_id).ifPresentOrElse(
				cust_detailsRepository::delete,
				()-> {
					throw new RuntimeException("Can't find cust_details with id" + cst_id);
				}
		);
	}
	
	
}

package com.example.lab5n6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lab5n6.entity.Cust_name;
import com.example.lab5n6.repository.Cust_nameRepository;

@Service
public class Cust_nameService {
	@Autowired
	Cust_nameRepository cust_nameRepository;
	
	public List<Cust_name> getAllCust_name() {
		return cust_nameRepository.findAll();
	}
	
	public Optional<Cust_name> getCust_nameById(Long cst_id) {
		return cust_nameRepository.findById(cst_id);
	}
	
	public Cust_name createCust_name(Cust_name cust_name) {
		return cust_nameRepository.save(cust_name);
	}
	
	public Cust_name updateCust_name(Long cst_id, Cust_name cust_name) {
		return cust_nameRepository.findById(cst_id)
				.map(cst_name-> {
					cst_name.setCstname_cls_id(cust_name.getCstname_cls_id());
					cst_name.setCstname_value(cust_name.getCstname_value());
					return cust_nameRepository.save(cst_name);					
				})
				.orElseThrow(()-> new RuntimeException("Cust_name not found with id: " + cst_id));
	}
		
	public void deleteCust_name(Long cst_id) {
		cust_nameRepository.findById(cst_id).ifPresentOrElse(
				cust_nameRepository::delete,
				() -> {
					throw new RuntimeException("Cust_name not found with id: "+cst_id);
				}
		);
	}
}

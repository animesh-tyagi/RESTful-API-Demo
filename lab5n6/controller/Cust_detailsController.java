package com.example.lab5n6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.lab5n6.entity.Cust_details;
import com.example.lab5n6.service.Cust_detailsService;

@RestController
@RequestMapping("/api/cust-details")
public class Cust_detailsController {
	@Autowired
	Cust_detailsService cust_detailsService;
	
	@GetMapping
	public List<Cust_details> getAllCust_details() {
		return cust_detailsService.getAllCust_details();
	}
	@GetMapping("/{cst_id}")
	public ResponseEntity<Cust_details> getCust_detailsById(@PathVariable Long cst_id) {
		return cust_detailsService.getCust_DetailsById(cst_id)
				.map(cust_details -> new ResponseEntity<>(cust_details,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@PostMapping
	public ResponseEntity<Cust_details> createCust_details(@RequestBody Cust_details cust_details) {
		Cust_details newCust_details = cust_detailsService.createCust_details(cust_details);
		return new ResponseEntity<>(newCust_details,HttpStatus.OK);
	}
	
	
	
	@PutMapping("/{cst_id}")
	public ResponseEntity<Cust_details> updateCust_details(@PathVariable Long cst_id, @RequestBody Cust_details cust_details) {
		try {
			Cust_details updatedCust_details = cust_detailsService.updateCust_details(cst_id, cust_details);
			return new ResponseEntity<>(updatedCust_details,HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/{cst_id}")
	public ResponseEntity<Void> deleteCust_details(@PathVariable Long cst_id) {
		try {
			cust_detailsService.deleteCust_details(cst_id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			
	}
	
}

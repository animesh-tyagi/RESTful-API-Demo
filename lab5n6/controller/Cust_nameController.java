package com.example.lab5n6.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.lab5n6.entity.Cust_name;
import com.example.lab5n6.service.Cust_nameService;

@RestController
@RequestMapping("/api/cust-name")
public class Cust_nameController {
	@Autowired
	Cust_nameService cust_nameService;
	
	@GetMapping
	public List<Cust_name> getAllCust_name() {
		return cust_nameService.getAllCust_name();
	}
	
	@GetMapping("/{cst_id}")
	public ResponseEntity<Cust_name> getCust_nameById(@PathVariable Long cst_id) {
		return cust_nameService.getCust_nameById(cst_id)
				.map(cust_name -> new ResponseEntity<>(cust_name,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@PostMapping
	public ResponseEntity<Cust_name> createCust_name(@RequestBody Cust_name cust_name) {
		Cust_name savedCust_name = cust_nameService.createCust_name(cust_name);
		return new ResponseEntity<>(savedCust_name,HttpStatus.CREATED);
	}
	@PutMapping("/{cst_id}")
	public ResponseEntity<Cust_name> updateCust_name(@PathVariable Long cst_id, @RequestBody Cust_name cust_name) {
		try {
			Cust_name updatedCust_name = cust_nameService.updateCust_name(cst_id,cust_name);
			return new ResponseEntity<>(updatedCust_name,HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/{cst_id}")
	public ResponseEntity<Void> deleteCust_name(@PathVariable Long cst_id) {
		try {
			cust_nameService.deleteCust_name(cst_id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

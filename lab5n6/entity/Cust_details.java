package com.example.lab5n6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cust_details {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cst_id;
	private String csdet_type;
	private String cstdet_dob;
	private String csdet_status;
	private String csdet_contact;
	private Long csdet_mobile;
	private String csdet_email;
	public Long getCst_id() {
		return cst_id;
	}
	public void setCst_id(Long cst_id) {
		this.cst_id = cst_id;
	}
	public String getCsdet_type() {
		return csdet_type;
	}
	public void setCsdet_type(String csdet_type) {
		this.csdet_type = csdet_type;
	}
	public String getCstdet_dob() {
		return cstdet_dob;
	}
	public void setCstdet_dob(String cstdet_dob) {
		this.cstdet_dob = cstdet_dob;
	}
	public String getCsdet_status() {
		return csdet_status;
	}
	public void setCsdet_status(String csdet_status) {
		this.csdet_status = csdet_status;
	}
	public String getCsdet_contact() {
		return csdet_contact;
	}
	public void setCsdet_contact(String csdet_contact) {
		this.csdet_contact = csdet_contact;
	}
	public Long getCsdet_mobile() {
		return csdet_mobile;
	}
	public void setCsdet_mobile(Long csdet_mobile) {
		this.csdet_mobile = csdet_mobile;
	}
	public String getCsdet_email() {
		return csdet_email;
	}
	public void setCsdet_email(String csdet_email) {
		this.csdet_email = csdet_email;
	}
	
	
}

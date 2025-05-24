package com.example.lab5n6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cust_name {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cst_id;
	private Long cstname_cls_id;
	private String cstname_value;
	public Long getCst_id() {
		return cst_id;
	}
	public void setCst_id(Long cst_id) {
		this.cst_id = cst_id;
	}
	public Long getCstname_cls_id() {
		return cstname_cls_id;
	}
	public void setCstname_cls_id(Long cstname_cls_id) {
		this.cstname_cls_id = cstname_cls_id;
	}
	public String getCstname_value() {
		return cstname_value;
	}
	public void setCstname_value(String cstname_value) {
		this.cstname_value = cstname_value;
	}
	
}

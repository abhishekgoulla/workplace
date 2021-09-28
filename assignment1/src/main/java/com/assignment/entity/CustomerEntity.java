package com.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CustomerEntity {
	@Id
	private int id;
	private String name;
	private int Mobile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMobile() {
		return Mobile;
	}

	public void setMobile(int i) {
		Mobile = i;
	}



	

	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", name=" + name + ", Mobile=" + Mobile + "]";
	}

}

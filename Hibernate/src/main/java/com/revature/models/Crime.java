package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//JPA = Java Persistence API
//JPA is the specification, Hibernate is the implementation

@Entity
@Table(name="crime")
public class Crime implements Serializable{
	
	// Our ID will be auto generated
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) // this will auto generate a primary key
	private int id;
	
	@Column(name="crime_name", unique=true, nullable=false)
	private String crimeName;
	
	@Column(name="description")
	private String description;
	
	public Crime() {
		
	}

	public Crime(int id, String crimeName, String description) {
		super();
		this.id = id;
		this.crimeName = crimeName;
		this.description = description;
	}

	public Crime(String crimeName, String description) {
		super();
		this.crimeName = crimeName;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCrimeName() {
		return crimeName;
	}

	public void setCrimeName(String crimeName) {
		this.crimeName = crimeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(crimeName, description, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Crime))
			return false;
		Crime other = (Crime) obj;
		return Objects.equals(crimeName, other.crimeName) && Objects.equals(description, other.description)
				&& id == other.id;
	}

	@Override
	public String toString() {
		return "Crime [id=" + id + ", crimeName=" + crimeName + ", description=" + description + "]";
	}
	
	
}

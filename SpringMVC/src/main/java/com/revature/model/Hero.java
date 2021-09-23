package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HERO")
public class Hero {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "h_name", unique = true, nullable = false)
	private String name;
	
	private String superpower;
	
	@Column(nullable = false, name="h_has_cape")
	private boolean hasCape;

	public Hero() {
		super();
	}

	public Hero(String name, String superpower, boolean hasCape) {
		super();
		this.name = name;
		this.superpower = superpower;
		this.hasCape = hasCape;
	}

	public Hero(int id, String name, String superpower, boolean hasCape) {
		super();
		this.id = id;
		this.name = name;
		this.superpower = superpower;
		this.hasCape = hasCape;
	}

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

	public String getSuperpower() {
		return superpower;
	}

	public void setSuperpower(String superpower) {
		this.superpower = superpower;
	}

	public boolean isHasCape() {
		return hasCape;
	}

	public void setHasCape(boolean hasCape) {
		this.hasCape = hasCape;
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", superpower=" + superpower + ", hasCape=" + hasCape + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(hasCape, id, name, superpower);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Hero))
			return false;
		Hero other = (Hero) obj;
		return hasCape == other.hasCape && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(superpower, other.superpower);
	}
	
	
}

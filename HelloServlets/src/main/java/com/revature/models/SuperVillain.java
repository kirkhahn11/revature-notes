package com.revature.models;

import java.util.Objects;

public class SuperVillain {

	private String name;
	private String superPower;
	private double bounty;
	public SuperVillain(String name, String superPower, double bounty) {
		super();
		this.name = name;
		this.superPower = superPower;
		this.bounty = bounty;
	}
	public SuperVillain() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuperPower() {
		return superPower;
	}
	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}
	public double getBounty() {
		return bounty;
	}
	public void setBounty(double bounty) {
		this.bounty = bounty;
	}
	@Override
	public String toString() {
		return "SuperVillain [name=" + name + ", superPower=" + superPower + ", bounty=" + bounty + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bounty, name, superPower);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SuperVillain))
			return false;
		SuperVillain other = (SuperVillain) obj;
		return Double.doubleToLongBits(bounty) == Double.doubleToLongBits(other.bounty)
				&& Objects.equals(name, other.name) && Objects.equals(superPower, other.superPower);
	}
	
	
}

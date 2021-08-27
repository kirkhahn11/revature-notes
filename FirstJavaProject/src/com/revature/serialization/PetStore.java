package com.revature.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PetStore {

	//every petstore has a database
	// here we'll first instantiate an arrayList and infer that it will hold Pet Objects

	private List<Pet> petDB = new ArrayList<>();
	
	public static void main(String[] args) {

		
		// Instantiate PetStore objects
		PetStore petco = new PetStore();
		PetStore petsmart = new PetStore();
		
		// 2 ways to add a Pet object to petco's petDB

		// 1) First we instnatiate the object, then we add it to the Collection
//		Pet p1 = new Pet("Finn", 1004, "Cat", "Jerry", 4, Color.GREY);
		
//		petco.petDB.add(p1);
		
		// 2) instantiate and add the new object at the same time
//		petco.petDB.add(new Pet("Spot", 3002, "Dog", "Larry", 10, Color.BROWN));
		
//		
//		// enhanced for loop
//		for(Pet p : petco.petDB) {
//			System.out.println(p.getName());
//		}
//		
//		petco.seriallize();
		
		petsmart.deserialize();
		
		for(Pet newPet : petsmart.petDB) {
			System.out.println("The newly deserialized pet is...");
			System.out.println(newPet);
		}
	
	}
	
	// seriallize() method
	public void seriallize() {
		
		// we're writing to a file here. We need to use the Java.io package
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/pet.db"))) {
			
			//this is the code to execute!
			oos.writeObject(this.petDB);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// deserialize() method
	@SuppressWarnings("unchecked")
	public void deserialize() {
		
	try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/pet.db"))) {
		
			// when a petstore object calls this method, it will call it on it's petDB array
		this.petDB = (ArrayList<Pet>) ois.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

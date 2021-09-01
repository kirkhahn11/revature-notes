package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

import com.revature.model.Animal;

public class Driver {

	public static void main(String[] args) {

		/**
		 * List
		 * 
		 * - ordered collection (sometimes called a sequence)
		 * - may contain duplicates
		 * - We use the list interface when we want to use the following operations:
		 * 
		 * 1) positional access (indexes)
		 * 		example get(), set(), add(), remove() - CRUD
		 * 2) searching 
		 * 3) iteration 
		 * 4) range view (how big is the list)
		 */
		
		List<Animal> animalList = new ArrayList<Animal>();
		
		Animal a1 = new Animal("Dog", 12); // we have no way of defining whether a1 and a3 are the same object
		Animal a2 = new Animal("Tiger", 4);
		Animal a3 = new Animal("Dog", 12);
		
		animalList.add(a1);
		animalList.add(a2);
		animalList.add(a3);
		
		for(Animal a : animalList) {
			System.out.println(a.hashCode());
		}
		
		// vectors are synchronized (thread safe) has a stack
		
		// vectors increase 100% when they need to expand
		List<Integer> numbers = new Vector<Integer>();
		
		numbers.add(3);
		numbers.add(74);
		numbers.add(-3000);
		
		/** 
		 * Sets 
		 * 
		 * - unordered
		 * - DO NOT allow duplicates
		 *     They maintain a strong contract on the objects hashCode and equals methods
		 */
		
		System.out.println("+++++++++++++ SETS BELOW +++++++++++++");
		
		Set<Animal> animalSet = new LinkedHashSet<Animal>(); //LinkedHashSet maintains order HashSet does not
		
		animalSet.add(a1); // the same as a3
		animalSet.add(a2);
		animalSet.add(a3); // the Set will refuse to accept this duplicate
		
		for(Animal a : animalSet) {
			System.out.println(a);
		}
		
		
		/**
		 * Queues 
		 * -- A collection used to hold elements prior to processing
		 * -- follows a FIFO order (first in, first out) 
		 * 
		 * 
		 */
		
		// LinkedList also available under Queue interface
		
		Queue<Animal> animalQ = new LinkedList<Animal>();
		
		animalQ.add(a1);
		animalQ.add(a2);
		animalQ.add(a3);
		
		while(animalQ.size() != 0) {
			System.out.println("Queue size: " + animalQ.size());
			System.out.println("Processing... " + animalQ.poll()); //removes head of the queue
		}
		
		/**
		 * Collections utility class!
		 * 
		 * - static methods that operate on a collection
		 */
		
		System.out.println("vectors before sorting");
		
		System.out.println(numbers);
		
		System.out.println("sorting vector....");
		Collections.sort(numbers); // Collections is the utility class, Collection is the interface
		
		System.out.println(numbers);
		
		
		
		
		
	}
	

}
